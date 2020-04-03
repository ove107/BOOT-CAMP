package com.example.jetpackexercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpackexercise1.databinding.EmployeeListBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.jetpackexercise1.BR.*;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private List<Employee> emp;
    private Context context;

    public EmployeeAdapter(List<Employee> emp, Context context) {
        this.emp = emp;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.employee_list, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
        Employee empl = emp.get(position);
        holder.binding.setEmp(empl);

    }

    @Override
    public int getItemCount() {
        return emp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EmployeeListBinding binding;
        public ViewHolder(@NonNull EmployeeListBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        public void bind(Object emp){
            binding.setVariable(BR.emp,emp);
            binding.executePendingBindings();
            //binding.setEmp(emp);

        }

    }
}
