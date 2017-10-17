package com.example.uzair.eventbus_recyclerview_fragments_picasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.gson.Gson;
import org.greenrobot.eventbus.EventBus;
/**
 * Created by UZAIR on 10/17/2017.
 */


public class detailsActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Gson gs = new Gson();
        String trg = getIntent().getStringExtra("Contact");
        contactDetailEvent contactDetailsEvent = new contactDetailEvent(trg);
        EventBus.getDefault().post(contactDetailsEvent);

    }
}

