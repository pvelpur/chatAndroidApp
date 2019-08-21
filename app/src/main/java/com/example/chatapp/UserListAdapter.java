package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Need to implement ViewHolder -> It is what gets the data out of an XML and allows us to use it
// https://developer.android.com/guide/topics/ui/layout/recyclerview
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    ArrayList<UserObject> userList;

    public UserListAdapter(ArrayList<UserObject> userList){

        this.userList = userList;

    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, null, false);

        // Sometime the recylceview messes up dimensions (wrap_context) so these lines of code
        // fix any possible mishaps
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        UserListViewHolder recyclerview = new UserListViewHolder(layoutView);
        return recyclerview;
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.mName.setText(userList.get(position).getName());
        holder.mPhone.setText(userList.get(position).getPhonenum());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class UserListViewHolder extends RecyclerView.ViewHolder {
        public TextView mName, mPhone;
        public UserListViewHolder(View view) {
            super(view);

            // Doing find by id inside the view holder so we can access all the things inside of
            // item_user.xml
            mName = view.findViewById(R.id.name);
            mPhone = view.findViewById(R.id.phone);
        }
    }
}
