package np.cnblabs.asmt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import np.cnblabs.asmt.adapter.CustomRealmRecyclerAdapter;
import np.cnblabs.asmt.model.realmModel.RealmModelData;

/**
 * Created by sanjogstha on 12/24/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class RealmActivity extends AppCompatActivity {

    TextInputLayout emailTextInputLayout, nameTextInputLayout;
    EditText emailET, nameET;

    String email, name;
    RecyclerView recyclerView;
    private CustomRealmRecyclerAdapter customRecyclerAdapter;
    private ArrayList<RealmModelData> studentModelList;

    Realm realm;
    private RealmModelData realmModelData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        emailTextInputLayout = findViewById(R.id.emailTextInputLayout);
        nameTextInputLayout = findViewById(R.id.nameTextInputLayout);
        emailET = findViewById(R.id.emailET);
        nameET = findViewById(R.id.nameET);

        recyclerView = findViewById(R.id.recyclerView);

        studentModelList = new ArrayList<>();
        realm = ASMTApplication.getRealmInstance();

        final RealmResults<RealmModelData> realmResults = realm
                .where(RealmModelData.class)
                .findAll();

        studentModelList.addAll(realmResults);

        customRecyclerAdapter = new CustomRealmRecyclerAdapter(this, studentModelList);

        customRecyclerAdapter.setOnClick(new CustomRealmRecyclerAdapter.setOnClickListener() {
            @Override
            public void onClick(String email) {
                realmModelData = fetchRealmfromEmail(email);
                if(realmModelData != null){
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(@NonNull Realm realm) {
                            realmModelData.deleteFromRealm();
                            studentModelList.clear();
                            studentModelList.addAll(realm
                                    .where(RealmModelData.class)
                                    .findAll());
                            customRecyclerAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customRecyclerAdapter);
    }

    public void validateRealmField(View view) {
        final String email = emailET.getText().toString();
        final String name = nameET.getText().toString();

        if(!Utils.validateEmail(email, emailTextInputLayout, emailET, this))
            return;

        if(!Utils.validateName(name, nameTextInputLayout, nameET, this))
            return;

        realmModelData = fetchRealmfromEmail(email);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {

                if(realmModelData == null){
                    //create table here
                    realmModelData = realm.createObject(RealmModelData.class, email);
                    realmModelData.setName(name);
                    studentModelList.add(realmModelData);
                }else{
                    realmModelData.setName(name);
                }
            }
        });
        customRecyclerAdapter.notifyDataSetChanged();
    }

    private RealmModelData fetchRealmfromEmail(String email) {
        return realm
                .where(RealmModelData.class)
                .equalTo(RealmModelData.EMAIL, email)
                .findFirst();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(realm != null)
            realm.close();
    }
}
