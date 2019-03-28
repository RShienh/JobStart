package com.humber.jobstart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.humber.jobstart.models.Jobs;

public class JobsAdapter extends FirestoreRecyclerAdapter<Jobs, JobsAdapter.JobsHolder> {

    private OnItemClickListener listener;

    public JobsAdapter(@NonNull FirestoreRecyclerOptions<Jobs> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull JobsHolder holder, int position, @NonNull Jobs model) {
        holder.mTitle.setText(model.getTitle());
        holder.mDate.setText(model.getPostDate());
        holder.mStatus.setText(model.getStatus());
        holder.mType.setText(model.getType());
        holder.mPay.setText(model.getSalary());
    }

    @NonNull
    @Override
    public JobsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.job_item, viewGroup, false);
        return new JobsHolder(v);
    }


    class JobsHolder extends RecyclerView.ViewHolder {

        TextView mTitle, mDate, mType, mStatus, mPay;

        public JobsHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.xJobTitle);
            mDate = itemView.findViewById(R.id.xJobDate);
            mType = itemView.findViewById(R.id.xJobType);
            mStatus = itemView.findViewById(R.id.xJobStatus);
            mPay = itemView.findViewById(R.id.xJobPay);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION && listener != null) {
                    listener.OnItemClick(getSnapshots().getSnapshot(pos), pos);
                }
            });

        }
    }

    public interface OnItemClickListener {
        void OnItemClick(DocumentSnapshot documentSnapshot, int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
