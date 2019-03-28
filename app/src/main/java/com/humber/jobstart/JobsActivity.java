package com.humber.jobstart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.gson.Gson;
import com.humber.jobstart.models.Jobs;

public class JobsActivity extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference jobsRef = db.collection("Jobs");

    private JobsAdapter mAdapter;
    private LottieAnimationView mBackAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        mBackAnim = findViewById(R.id.xJobsAnim);

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

        mBackAnim.setVisibility(View.GONE);
        mAdapter.setOnItemClickListener((documentSnapshot, position) -> {
            Jobs jobs = documentSnapshot.toObject(Jobs.class);
            Intent i = new Intent(getApplicationContext(), ViewJobActivity.class);
            Gson gson = new Gson();
            String myJson = gson.toJson(jobs);
            i.putExtra("job", myJson);
            startActivity(i);
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
