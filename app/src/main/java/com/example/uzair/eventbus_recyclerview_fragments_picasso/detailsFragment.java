package com.example.uzair.eventbus_recyclerview_fragments_picasso;

/**
 * Created by UZAIR on 10/16/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class detailsFragment extends Fragment {
    EventBus myEventBus;
    View rootView;
    Gson gson;
    TextView name;
    TextView number;
    TextView email;

    public detailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        gson = new Gson();
        EventBus.getDefault().register(this);
        rootView = inflater.inflate(R.layout.fragment, container, false);
        name = (TextView) rootView.findViewById(R.id.name);
        email = (TextView) rootView.findViewById(R.id.email);
        number = (TextView) rootView.findViewById(R.id.number);

        return rootView;
    }

    @Subscribe
    public void onEvent(contactDetailEvent event) {
        String str = event.getMessage();
        Contact contact = gson.fromJson(str, Contact.class);
        name.setText(contact.getName().toString());
        email.setText(contact.getEmail().toString());
        number.setText(contact.getNumber().toString());

    }

}