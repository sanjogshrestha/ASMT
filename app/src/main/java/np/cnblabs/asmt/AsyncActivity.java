package np.cnblabs.asmt;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by sanjogstha on 12/21/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class AsyncActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        listView = findViewById(R.id.listView);

        new FetchAPI().execute("url");
    }

    private class FetchAPI extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            return null;
        }



        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
        }
    }
}
