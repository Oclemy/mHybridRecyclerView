package info.camposha.mhybridrecyclerview.RecyclerHelpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import info.camposha.mhybridrecyclerview.Model.CarouselItem;
import info.camposha.mhybridrecyclerview.R;

public class MyViewHolders {
    public static class AdViewHolder extends RecyclerView.ViewHolder {
        public AdViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Clicked on simple list item.", Toast.LENGTH_SHORT).show();
        }
    }

    public static class LoadingProgressViewHolder extends RecyclerView.ViewHolder {

        public LoadingProgressViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ScrollableViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView mRecyclerView;
        private final ItemsAdapter mItemsAdapter;

        public ScrollableViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.horizontalList);
            mRecyclerView.setAdapter(mItemsAdapter = new ItemsAdapter(itemView.getContext()));
        }

        public void setItems(List<CarouselItem> scrollables) {
            if (mItemsAdapter.getItemCount() == 0) {
                mItemsAdapter.setItems(scrollables);
            }
        }

        class ItemsAdapter extends RecyclerView.Adapter<ScrollableItemViewHolder> {

            private final List<CarouselItem> mScrollables = new ArrayList<>();
            private final LayoutInflater mLayoutInflater;
            private final Context mContext;

            ItemsAdapter(Context context) {
                mContext = context;
                mLayoutInflater = LayoutInflater.from(context);
            }

            @NonNull
            @Override
            public ScrollableItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ScrollableItemViewHolder(mLayoutInflater.inflate(R.layout.item_horizontal_list_layout, parent, false));
            }

            @Override
            public void onBindViewHolder(@NonNull ScrollableItemViewHolder holder, int position) {
                CarouselItem item = mScrollables.get(position);
                holder.setTitle(item.mLabel);
                Glide.with(mContext.getApplicationContext()).load(item.mImageUrl).into(holder.mImg);
            }

            @Override
            public int getItemCount() {
                return mScrollables.size();
            }

            void setItems(List<CarouselItem> scrollable) {
                mScrollables.clear();
                mScrollables.addAll(scrollable);
                notifyDataSetChanged();
            }
        }

        class ScrollableItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private final ImageView mImg;
            private final TextView mTxt;
            private String mTitle;

            ScrollableItemViewHolder(View itemView) {
                super(itemView);
                mImg = itemView.findViewById(R.id.imageView2);
                mTxt = itemView.findViewById(R.id.scrollableItem);
                itemView.setOnClickListener(this);
            }

            void setTitle(String title) {
                mTitle = title;
                mTxt.setText(title);
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), mTitle, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
