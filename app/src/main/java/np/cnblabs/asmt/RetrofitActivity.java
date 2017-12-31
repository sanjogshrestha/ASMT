package np.cnblabs.asmt;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import np.cnblabs.asmt.model.PostModel;
import np.cnblabs.asmt.model.TreeHouseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sanjogstha on 12/31/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class RetrofitActivity extends  BaseActivity{

    @BindView(R.id.listView) ListView listView;
    Call<TreeHouseModel> summary;
    Realm realm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ButterKnife.bind(this);

        realm = Realm.getDefaultInstance();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();

        summary = getWebService().getSummary();
        summary.enqueue(new Callback<TreeHouseModel>() {
            @Override
            public void onResponse(@NonNull Call<TreeHouseModel> call, @NonNull Response<TreeHouseModel> response) {
                if(!isDestroyed() && progressDialog.isShowing())
                    progressDialog.cancel();
                if(response.isSuccessful()){
                    TreeHouseModel treeHouseModel = response.body();
                    if(treeHouseModel == null) return;

                    List<String> newList = new ArrayList<>();
                    for (PostModel postModel : treeHouseModel.getPosts()) {
                        newList.add(postModel.getTitle());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(RetrofitActivity.this,
                            android.R.layout.simple_list_item_1,
                            newList);

                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TreeHouseModel> call, @NonNull Throwable t) {
                if(!isDestroyed() && progressDialog.isShowing())
                    progressDialog.cancel();
                Toast.makeText(RetrofitActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(summary.isExecuted()) summary.cancel();
        super.onBackPressed();
    }
}
