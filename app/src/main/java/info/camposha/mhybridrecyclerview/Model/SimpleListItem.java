package info.camposha.mhybridrecyclerview.Model;

public class SimpleListItem<M> {

    public static final int TYPE_ITEM = 0;
    public static final int TYPE_PROGRESS = 1;
    public static final int TYPE_ADVERT = 2;
    public static final int TYPE_SCROLLABLE = 3;

    private final int mListType;
    private final M mModel;

    public SimpleListItem(int listType, M model) {
        mListType = listType;
        mModel = model;
    }

    public <M> M getModel() {
        return (M) mModel;
    }

    public int getListType() {
        return mListType;
    }
}
