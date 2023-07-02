package com.pucpr.alertaja.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pucpr.alertaja.R;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    public interface OnItemLongClickListener {
        boolean onItemLongClick(View view, int position);
    }
    private OnItemLongClickListener longClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1, textView2, textView3, textView4;
        public ViewHolder(View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView2);
            textView2 = itemView.findViewById(R.id.textView4);
            textView3 = itemView.findViewById(R.id.textView5);
            textView4 = itemView.findViewById(R.id.textView6);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(longClickListener != null) {
                        return longClickListener.onItemLongClick(view, getAdapterPosition());
                    }
                    return false;
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(
                R.layout.recycler_view_item,
                parent,
                false
                );
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event e = DataModel.getInstance().getEvent(position);
        holder.textView1.setText(e.getName());
        holder.textView2.setText("Descrição: " + e.getDescricao());
        holder.textView3.setText("Local do evento: " + e.getLocal());
        holder.textView4.setText("Data do evento: " + e.getData());
        Log.v("ProductAdapter","Item[" + position + "]:" + e.getName());
    }

    @Override
    public int getItemCount() {
        return DataModel.getInstance().getEvents().size();
    }
}
