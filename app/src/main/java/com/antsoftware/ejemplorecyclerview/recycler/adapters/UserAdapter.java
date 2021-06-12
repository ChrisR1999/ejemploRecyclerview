package com.antsoftware.ejemplorecyclerview.recycler.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.antsoftware.ejemplorecyclerview.R;
import com.antsoftware.ejemplorecyclerview.recycler.models.UserModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserModel> userModelList;

    public UserAdapter(ArrayList<UserModel> userModelList){
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
        String id = userModelList.get(position).getId();
        String name = userModelList.get(position).getName();
        String age = userModelList.get(position).getAge();
        String Registry = userModelList.get(position).getRegistry();

        holder.id.setText(id);
        holder.name.setText(name);
        holder.age.setText(age);
        holder.Registry.setText(Registry);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView id;
        private final TextView name;
        private final TextView age;
        private final TextView Registry;

        public ViewHolder(View v){
            super(v);
            id = (TextView) v.findViewById(R.id.tvID);
            name = (TextView) v.findViewById(R.id.tvName);
            age = (TextView) v.findViewById(R.id.tvAge);
            Registry = (TextView) v.findViewById(R.id.tvRegistry);
        }
    }
}
