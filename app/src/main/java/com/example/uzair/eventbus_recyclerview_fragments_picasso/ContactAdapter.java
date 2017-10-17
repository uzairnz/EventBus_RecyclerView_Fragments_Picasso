package com.example.uzair.eventbus_recyclerview_fragments_picasso;

/**
 * Created by UZAIR on 10/16/2017.
 */


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.id;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private static final String TAG = "MTAG";
    private List<Contact> contactList;


    Context c;




    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, number;
        public Button delete;
        public ImageView image;
        public TextView email;
        public RelativeLayout item;

        public MyViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.name);
            number = view.findViewById(R.id.number);
            image = view.findViewById(R.id.image);
            delete= view.findViewById(R.id.delete);
            email= view.findViewById(R.id.email);
            item = view.findViewById(R.id.item);
        }
    }



    public ContactAdapter(List<Contact> contactList, Context ctx) {

        this.contactList = contactList;
        c = ctx;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Contact contact= contactList.get(position);
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());
        Picasso.with(c).load("https://pbs.twimg.com/profile_images/824716853989744640/8Fcd0bji.jpg")
                .resize(180,180).into(holder.image);
        holder.email.setText(contact.getEmail());
        holder.item.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Contact contact = contactList.get(position);
                Gson gson = new Gson();
                String str = gson.toJson(contact);
                Intent callIntent = new Intent(c, detailsActivity.class);
                callIntent.putExtra("Contact", str);
                c.startActivity(callIntent);

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View view) {
            // Get the clicked item label
            Contact itemLabel = contactList.get(position);
            // Remove the item on remove/button click
            contactList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, contactList.size());

            // Show the removed item label
            Toast.makeText(c, "Removed : " + itemLabel, Toast.LENGTH_SHORT).show();
        }

        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
