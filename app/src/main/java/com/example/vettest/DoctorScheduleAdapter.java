package com.example.vettest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class DoctorScheduleAdapter extends RecyclerView.Adapter<DoctorScheduleAdapter.myViewHolder> {

    Context context;
    ArrayList<DoctorScheduleModel> doctorSchedule;

    public DoctorScheduleAdapter(Context context, ArrayList<DoctorScheduleModel> doctorSchedule) {
        this.context = context;
        this.doctorSchedule = doctorSchedule;
    }

    @NonNull
    @Override
    public DoctorScheduleAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.doctor_schedule,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorScheduleAdapter.myViewHolder holder, int position) {
        DoctorScheduleModel schedule=doctorSchedule.get(position);

        holder.name.setText(schedule.title);
        holder.pet.setText(schedule.animal);
        holder.timeOfService.setText(schedule.time);
        holder.dateOfService.setText(schedule.date);
        holder.customerName.setText(schedule.patient_name);
        holder.customerEmail.setText(schedule.patient_email);


    }

    @Override
    public int getItemCount() {
        return doctorSchedule.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView name,pet,timeOfService,dateOfService,customerName,customerEmail;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.titleInfo);
            pet=itemView.findViewById(R.id.petInfo);
            timeOfService=itemView.findViewById(R.id.timeInfo);
            dateOfService=itemView.findViewById(R.id.dateInfo);
            customerEmail=itemView.findViewById(R.id.customerEmailInfo);
            customerName=itemView.findViewById(R.id.customerUsernameInfo);
        }
    }
}

