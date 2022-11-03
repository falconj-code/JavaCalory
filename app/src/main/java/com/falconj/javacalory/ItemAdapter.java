package com.falconj.javacalory;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<DataModel> mList;
    private List<String> list = new ArrayList<>();

    public ItemAdapter(List<DataModel> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meal_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        DataModel model = mList.get(position);
        holder.mMealName.setText(model.getItemText());
        holder.mMealImage.setImageResource(model.getMealImage());

        boolean isExpandable = model.isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if (isExpandable) {
            holder.mArrowImage.setImageResource(R.drawable.ic_arrow_up);
        } else {
            holder.mArrowImage.setImageResource(R.drawable.ic_arrow_down);
        }

        NestedAdapter adapter = new NestedAdapter(list);
        holder.nestedRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedRecyclerView.setHasFixedSize(true);
        holder.nestedRecyclerView.setAdapter(adapter);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setExpandable(!model.isExpandable());
                list = model.getNestedList();
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private RelativeLayout expandableLayout;
        private ImageView mMealImage;
        private TextView mMealName;
        private ImageView mArrowImage;
        private RecyclerView nestedRecyclerView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.meal_linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            mMealImage = itemView.findViewById(R.id.iv_meal_image);
            mMealName = itemView.findViewById(R.id.tv_meal_name);
            mArrowImage = itemView.findViewById(R.id.iv_arrow);
            nestedRecyclerView = itemView.findViewById(R.id.rv_child);
        }
    }
}
