package org.michaelevans.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleRecycle extends RecyclerView.Adapter<SimpleRecycle.ItemViewHolder> {

    private final Context mContext;

    public SimpleRecycle(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycle_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.txtDemo.setText(position+"= position");
    }



    @Override
    public int getItemCount() {
        return 100;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtDemo;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txtDemo=itemView.findViewById(R.id.txt_demo);
        }
    }

}
