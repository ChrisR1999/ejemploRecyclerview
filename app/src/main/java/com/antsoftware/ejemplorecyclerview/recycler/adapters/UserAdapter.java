package com.antsoftware.ejemplorecyclerview.recycler.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.antsoftware.ejemplorecyclerview.R;
import com.antsoftware.ejemplorecyclerview.db.models.StudentsModel;
import com.antsoftware.ejemplorecyclerview.recycler.models.UserModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<StudentsModel> userModelList;

    public UserAdapter(ArrayList<StudentsModel> userModelList){
        this.userModelList = userModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int Registry = userModelList.get(position).getRegistry();
        String name = userModelList.get(position).getName();
        int age = userModelList.get(position).getAge();
        String subjects = userModelList.get(position).getSubjects();

        holder.registry.setText(String.valueOf(Registry));
        holder.name.setText(name);
        holder.age.setText(String.valueOf(age));
        holder.subjects.setText(subjects);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView registry;
        private final TextView name;
        private final TextView age;
        private final TextView subjects;

        public ViewHolder(View v){
            super(v);

            registry = (TextView) v.findViewById(R.id.tvRegistry);
            name = (TextView) v.findViewById(R.id.tvName);
            age = (TextView) v.findViewById(R.id.tvAge);
            subjects = (TextView) v.findViewById(R.id.tvSubjects);

        }
    }
}
