package com.example.billblender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {
    private List<String> sections;

    public BillAdapter(List<String> sections) {
        this.sections = sections;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bill_section, parent, false);
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {
        holder.textView.setText(sections.get(position));
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    static class BillViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.bill_section_text);
        }
    }
}
