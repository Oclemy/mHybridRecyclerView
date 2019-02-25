package info.camposha.mhybridrecyclerview.RecyclerHelpers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import info.camposha.mhybridrecyclerview.Model.CarouselItem;
import info.camposha.mhybridrecyclerview.Model.SimpleListItem;
import info.camposha.mhybridrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class HybridListItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<SimpleListItem<?>> mListItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    public HybridListItemsAdapter(LayoutInflater inflater) {
        mInflater = inflater;
    }

    @Override
    public int getItemViewType(int position) {
        return mListItems.get(position).getListType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case SimpleListItem.TYPE_ADVERT://inflate advert here
                viewHolder = new MyViewHolders.AdViewHolder(mInflater.inflate(R.layout.item_adview_layout, parent, false));
                break;
            case SimpleListItem.TYPE_PROGRESS://inflate progress here
                viewHolder = new MyViewHolders.LoadingProgressViewHolder(mInflater.inflate(R.layout.item_progress_layout, parent, false));
                break;
            case SimpleListItem.TYPE_SCROLLABLE://inflate scrollable here
                viewHolder = new MyViewHolders.ScrollableViewHolder(mInflater.inflate(R.layout.item_scrollable_layout, parent, false));
                break;
            default://inflate item here
                viewHolder = new MyViewHolders.ItemViewHolder(mInflater.inflate(R.layout.item_list_layout, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SimpleListItem<?> listItem = mListItems.get(position);

        switch (listItem.getListType()) {
            case SimpleListItem.TYPE_ADVERT://bind advert view
                bindAdViewHolder((MyViewHolders.AdViewHolder) holder);
                break;
            case SimpleListItem.TYPE_PROGRESS://bind progress view
                bindProgressViewHolder((MyViewHolders.LoadingProgressViewHolder) holder);
                break;
            case SimpleListItem.TYPE_SCROLLABLE://bind scrollable view
                bindScrollableViewHolder((MyViewHolders.ScrollableViewHolder) holder, listItem);
                break;
            default://bind item view
                bindItemViewHolder((MyViewHolders.ItemViewHolder) holder, listItem);
                break;
        }
    }

    public void addItem(SimpleListItem<?> item) {
        mListItems.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<SimpleListItem<?>> items) {
        mListItems.addAll(items);
        notifyDataSetChanged();
    }

    void clearItems() {
        mListItems.clear();
        notifyDataSetChanged();
    }

    private void bindItemViewHolder(MyViewHolders.ItemViewHolder holder, SimpleListItem<?> listItem) {

    }

    private void bindScrollableViewHolder(MyViewHolders.ScrollableViewHolder holder, SimpleListItem<?> listItem) {
        List<CarouselItem> scrollables = listItem.getModel();
        holder.setItems(scrollables);
    }

    private void bindProgressViewHolder(MyViewHolders.LoadingProgressViewHolder holder) {

    }

    private void bindAdViewHolder(MyViewHolders.AdViewHolder holder) {

    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }
}
