package com.pucpr.alertaja.controlles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.pucpr.alertaja.R;
import com.pucpr.alertaja.model.DataModel;
import com.pucpr.alertaja.model.Event;
import com.pucpr.alertaja.model.EventAdapter;

public class ListEvents extends AppCompatActivity {

    RecyclerView recyclerView;
    EventAdapter adapter = new EventAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_events);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        DataModel.getInstance().CreateDatabase(getApplicationContext());
        recyclerView.setLayoutManager(
                new LinearLayoutManager(ListEvents.this)
        );
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                ListEvents.this,DividerItemDecoration.VERTICAL
        );
        recyclerView.addItemDecoration(itemDecoration);




        adapter.setOnItemLongClickListener(new EventAdapter.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(View v, int position) {
            Event event = DataModel.getInstance().getEvent(position);
            DataModel.getInstance().removeEvent(position);
            ;
            adapter.notifyItemRemoved(position);

            View contextView = findViewById(android.R.id.content);
            Snackbar.make(contextView, R.string.remove_event, Snackbar.LENGTH_LONG).show();
            return true;
        }
    });
    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public  void addNewEventOnClick(View v){
        Intent intent = new Intent(ListEvents.this, EventDetails.class);
        startActivity(intent);
//        adapter.notifyItemInserted(0);
    }
}