package com.humber.jobstart.Activities.Calendars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.humber.jobstart.Adapters.EventsAdapter;
import com.humber.jobstart.Models.Events;
import com.humber.jobstart.R;

/**
 * The type Chauncey calendar activity.
 * This Activity is used to display the data related to Chauncey Calendar
 * It fetches data using FireStore cloud NoSQL database
 */
public class ChaunceyCalendarActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String collectionPath = "ChaunceyEvents";
    private CollectionReference chaunceyRef = db.collection(collectionPath);
    private EventsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chauncey_calendar);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        Query q = chaunceyRef.orderBy("eventDate", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Events> options = new FirestoreRecyclerOptions.Builder<Events>().setQuery(q, Events.class).build();

        mAdapter = new EventsAdapter(options);

        final RecyclerView recyclerView = findViewById(R.id.xChaunceyEventRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}