package info.camposha.mhybridrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import info.camposha.mhybridrecyclerview.RecyclerHelpers.HybridListItemsAdapter;
import info.camposha.mhybridrecyclerview.Model.CarouselItem;
import info.camposha.mhybridrecyclerview.Model.SimpleListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HybridListItemsAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.customList);
        mRecyclerView.setAdapter(mListAdapter = new HybridListItemsAdapter(getLayoutInflater()));

        List<CarouselItem> carousels = new ArrayList<>();

        carousels.add(new CarouselItem("Dunkirk", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/Dunkirk.jpg"));
        carousels.add(new CarouselItem("Jumanji", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/Jumanji.jpg"));
        carousels.add(new CarouselItem("The Maze Runner", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/The_Maze_Runner.jpg"));
        carousels.add(new CarouselItem("John Wick", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/John_Wick.jpg"));
        carousels.add(new CarouselItem("Coco", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/Coco.jpg"));
        carousels.add(new CarouselItem("Lucy", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/Lucy.jpg"));
        carousels.add(new CarouselItem("Batman", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/Batman_Superman.jpg"));
        carousels.add(new CarouselItem("Ted 2", "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/images/movies/Ted_2.jpg"));

        mListAdapter.addItem(new SimpleListItem<>(SimpleListItem.TYPE_SCROLLABLE, carousels));

        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-1"));
        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-2"));
        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-3"));

        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ADVERT, "Advert-to load from model"));

        mListAdapter.addItem(new SimpleListItem<Void>(SimpleListItem.TYPE_PROGRESS, null));

        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-5"));
        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-5"));

        mListAdapter.addItem(new SimpleListItem<>(SimpleListItem.TYPE_SCROLLABLE, carousels));

        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-5"));
        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-5"));
        mListAdapter.addItem(new SimpleListItem<String>(SimpleListItem.TYPE_ITEM, "Item-5"));
    }
}
