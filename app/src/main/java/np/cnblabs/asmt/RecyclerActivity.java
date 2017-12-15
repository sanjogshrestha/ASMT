package np.cnblabs.asmt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.cnblabs.asmt.adapter.CustomRecyclerAdapter;
import np.cnblabs.asmt.model.StudentModel;

/**
 * Created by sanjogstha on 12/15/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class RecyclerActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    List<StudentModel> studentModelList;
    CustomRecyclerAdapter customRecyclerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);

        feedData();

        customRecyclerAdapter = new CustomRecyclerAdapter(this, studentModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customRecyclerAdapter);
    }

    private void feedData() {
        studentModelList = new ArrayList<>();
        StudentModel studentModel = new StudentModel("Prem", "Dang", 111, 31);
        studentModelList.add(studentModel);

        studentModel = new StudentModel("Jhuppe", "Dhading", 30, 222);
        studentModelList.add(studentModel);

        studentModel = new StudentModel("Mama", "Nuwakot", 29, 333);
        studentModelList.add(studentModel);

        studentModel = new StudentModel("Sabal", "Gorkha", 36, 444);
        studentModelList.add(studentModel);

        studentModel = new StudentModel("Bishal", "Nuwakot", 12, 555);
        studentModelList.add(studentModel);
    }
}
