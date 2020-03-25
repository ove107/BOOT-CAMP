package com.example.backgroundtask;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {


    public String URL="";
    EditText editText;
    ImageView image;
    Button button;
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Get the layout from image.xml
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.edittxt);

// Locate the ImageView in activity_main.xml
        image = (ImageView) findViewById(R.id.image);

// Locate the Button in activity_main.xml
        button = (Button) findViewById(R.id.AsyncDownload);

// Capture button click
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {

//get the image url from the text box
                URL=editText.getText().toString();

// Execute DownloadImage AsyncTask
                new DownloadImage(image).execute(URL);
            }
        });
    }

    // DownloadImage AsyncTask
    private  class DownloadImage extends AsyncTask<String, Void, Bitmap> {
ImageView img;
        DownloadImage(ImageView img){
            this.img=img;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
// Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
// Set progressdialog title
            mProgressDialog.setTitle("Download Image Using AsyncTask Tutorial");
// Set progressdialog message
            mProgressDialog.setMessage("Downloading...please wait...");
            mProgressDialog.setIndeterminate(false);
// Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {


            InputStream in = null;
            Bitmap bitmap = null;
            try {
// Download Image from URL
                String url = URL[0];

                in  = new java.net.URL(url).openStream();
         bitmap = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            } /*finally {
              if(in != null)
                 try {
                   in.close();
                } catch (IOException e) {
                   Log.e("TAG", "Exception while closing inputstream"+ e);
                 }
              }*/
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
// Set the bitmap into ImageView
            img.setImageBitmap(result);
// Close progressdialog
            mProgressDialog.dismiss();
        }
    }
}