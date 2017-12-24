package np.cnblabs.asmt;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import np.cnblabs.asmt.model.PostModel;
import np.cnblabs.asmt.model.TreeHouseModel;

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

        new FetchAPI(this).execute("http://blog.teamtreehouse.com/api/get_recent_summary/");
    }

    public class FetchAPI extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog = null;

        private WeakReference<AsyncActivity> activityReference;

        // only retain a weak reference to the activity
        FetchAPI(AsyncActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(AsyncActivity.this);
            progressDialog.setMessage("Loading Data");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            try {
                url = new URL(strings[0]);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                if(urlConnection.getResponseCode() ==  HttpURLConnection.HTTP_OK) {
                    InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);
            if(json != null){
                // get a reference to the activity if it is still there
                AsyncActivity activity = activityReference.get();
                if (activity == null) return;

                // modify the activity's UI
                ListView listView = activity.findViewById(R.id.listView);

                Gson gson = new Gson();
                TreeHouseModel treeHouseModel = gson.fromJson(json, TreeHouseModel.class);
                List<String> newList = new ArrayList<>();
                for (PostModel postModel : treeHouseModel.getPosts()) {
                    newList.add(postModel.getTitle());
                }

                if(progressDialog != null && progressDialog.isShowing()) progressDialog.cancel();

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AsyncActivity.this,
                        android.R.layout.simple_list_item_1, newList);
                listView.setAdapter(adapter);
            }
        }
    }
}
