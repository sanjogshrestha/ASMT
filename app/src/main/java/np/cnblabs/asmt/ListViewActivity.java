package np.cnblabs.asmt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import np.cnblabs.asmt.adapter.CustomListAdapter;

/**
 * Created by sanjogstha on 12/14/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class ListViewActivity extends AppCompatActivity{
    ListView listView;
    CustomListAdapter customListAdapter;
    String[] sports = {"baseball", "cricket", "hockey", "karate",
            "soccer", "table tennis"};
    int[] sportsIcon = {R.drawable.baseball, R.drawable.cricket, R.drawable.hockey,
            R.drawable.karate, R.drawable.soccer, R.drawable.tt};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = findViewById(R.id.listView);

        customListAdapter = new CustomListAdapter(this, sports, sportsIcon);
        listView.setAdapter(customListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this,
                        adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
