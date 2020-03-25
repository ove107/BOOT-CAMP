package com.example.room1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;


class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
   private List<Employee> emp ;
    private LayoutInflater inflater;


    public EmployeeAdapter( Context context) {

    //    Employee empl=new Employee("1234567890","Suman","ad@bd.com");
      //  this.emp.add(empl);

        inflater = LayoutInflater.from(context);
    }
    void setEmp(List<Employee> empl){
        emp = empl;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.employee_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
       if(emp!=null){
        holder.name.setText(emp.get(position).getName());
        holder.phone.setText(emp.get(position).getPhone());
        holder.add.setText(emp.get(position).getAddress());
    }
    else{
           holder.name.setText("NO TEXT");
           holder.phone.setText("NO TEXT");
           holder.add.setText("NO TEXT");
       }
    }

    @Override
    public int getItemCount() {
        if (emp != null)
            return emp.size();
        else return 0;
        //return this.emp.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView phone;
        TextView add;
        //EmployeeAdapter ea;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          //  ea = employeeAdapter;
            name = itemView.findViewById(R.id.name_d);
            add = itemView.findViewById(R.id.add_d);
            phone = itemView.findViewById(R.id.phone_d);
        }
    }
}
