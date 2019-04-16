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


/**
 * The type Events adapter.
 * This adapter handles the data from FireStore to Recycler List View
 */
public class EventsAdapter extends FirestoreRecyclerAdapter<Events, EventsAdapter.EventsHolder> {

    /**
     * Instantiates a new Events adapter.
     *
     * @param options the options
     */
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

    /**
     * The type Events holder.
     */
    class EventsHolder extends RecyclerView.ViewHolder {
        /**
         * The M event date.
         */
        TextView mEventDate, /**
         * The M event details.
         */
        mEventDetails;

        /**
         * Instantiates a new Events holder.
         *
         * @param view the view
         */
        public EventsHolder(View view) {
            super(view);
            mEventDate = view.findViewById(R.id.xEventDate);
            mEventDetails = view.findViewById(R.id.xEventDetails);
        }
    }

}
