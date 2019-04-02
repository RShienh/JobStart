package com.humber.jobstart.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.humber.jobstart.Models.Events;
import com.humber.jobstart.R;


public class EventsAdapter extends FirestoreRecyclerAdapter<Events, EventsAdapter.EventsHolder> {

    public EventsAdapter(@NonNull FirestoreRecyclerOptions<Events> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull EventsHolder holder, int position, @NonNull Events model) {
        holder.mEventDate.setText(model.getEventDate());
        holder.mEventDetails.setText(model.getEventDetails());
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_item, viewGroup, false);
        return new EventsHolder(v);
    }

    class EventsHolder extends RecyclerView.ViewHolder {
        TextView mEventDate, mEventDetails;

        public EventsHolder(View view) {
            super(view);
            mEventDate = view.findViewById(R.id.xEventDate);
            mEventDetails = view.findViewById(R.id.xEventDetails);
        }
    }

}
