package com.humber.jobstart;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.humber.jobstart.models.Jobs;

public class JobsActivity extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference jobsRef = db.collection("Jobs");

    private JobsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        Query q = jobsRef.orderBy("postDate", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Jobs> options = new FirestoreRecyclerOptions.Builder<Jobs>().setQuery(q, Jobs.class).build();

        mAdapter = new JobsAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.xJobsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);


        mAdapter.setOnItemClickListener(new JobsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(DocumentSnapshot documentSnapshot, int position) {
                Jobs jobs = documentSnapshot.toObject(Jobs.class);
                String id = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();
                //send data to another activity
            }
        });
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
