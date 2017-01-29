package yongjaekwon.testapplication2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Kwon on 2017-01-28.
 */

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView taskView;
        public TextView dateView;
        public CheckBox checkMe;
        public ViewHolder(View itemView) {
            super(itemView);
            taskView = (TextView) itemView.findViewById(R.id.contact_name);
            dateView = (TextView) itemView.findViewById(R.id.contact_date);
            checkMe = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

    private List<BucketItem> mBucketItems;
    private Context mContext;

    // Pass in the contact array into the constructor
    public BucketListAdapter(Context context, List<BucketItem> bucketItems) {
        mBucketItems = bucketItems;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public BucketListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(BucketListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        BucketItem bucketItem = mBucketItems.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.taskView;
        TextView dateView = viewHolder.dateView;
        textView.setText(bucketItem.getName());
        dateView.setText(new SimpleDateFormat("yyyy-MM-dd").format(bucketItem.getDate()));
        if(!bucketItem.isOnline()) {
            textView.setClickable(false);
            textView.setActivated(false);
            textView.setEnabled(false);
        }
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mBucketItems.size();
    }
}
