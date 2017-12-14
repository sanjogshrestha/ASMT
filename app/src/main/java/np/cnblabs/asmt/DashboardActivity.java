package np.cnblabs.asmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by sanjogstha on 12/13/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class DashboardActivity extends AppCompatActivity{
    Button listViewButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        listViewButton = findViewById(R.id.listViewButton);
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ListViewActivity.class));
            }
        });
    }

    public void startSpinnerActivity(View view) {
        startActivity(new Intent(this, SpinnerActivity.class));
    }
}
