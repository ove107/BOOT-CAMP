package com.example.jetpackexercise1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class AddEmployee extends Fragment {

    EditText name_a,add_a,email_a,phone_a;
    Button add_e;
    AddEmployeeListener adl;
    public interface AddEmployeeListener {
        void onImplementEmployeeListener(CharSequence name,CharSequence add,CharSequence email,CharSequence phone);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_employee, container, false);
        name_a=view.findViewById(R.id.name);
        add_a=view.findViewById(R.id.Address);
        email_a=view.findViewById(R.id.email);
        phone_a=view.findViewById(R.id.phone);
        add_e=view.findViewById(R.id.addu);
        add_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence name =name_a.getText();
                CharSequence email=email_a.getText();
                CharSequence add = add_a.getText();
                CharSequence phone = phone_a.getText();
                adl.onImplementEmployeeListener(name,add,email,phone);
                name_a.setText("");
                email_a.setText("");
                add_a.setText("");
                phone_a.setText("");
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AddEmployeeListener){
            adl = (AddEmployeeListener)context;
        }
        else{
            throw new RuntimeException(context.toString()+" Implement add Employee listener");
        }
    }
}
