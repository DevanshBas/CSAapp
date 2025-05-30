package com.example.billblender;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemixActivity extends AppCompatActivity {

    private List<String> billSections;
    private BillAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remix);

        billSections = new ArrayList<>();
        billSections.add("Section 1: Allocate $10M to education.");
        billSections.add("Section 2: Reduce emissions by 20% by 2030.");
        billSections.add("Section 3: Increase minimum wage to $15/hr.");
        billSections.add("Section 4: Create 5,000 new green jobs.");
        billSections.add("Section 5: Set up annual policy review.");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new BillAdapter(billSections);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                0) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                int fromPos = viewHolder.getAdapterPosition();
                int toPos = target.getAdapterPosition();
                Collections.swap(billSections, fromPos, toPos);
                adapter.notifyItemMoved(fromPos, toPos);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // No swipe functionality needed
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
