package np.cnblabs.asmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer_layout;
    NavigationView nav_view;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawer_layout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawer_layout.isDrawerOpen(Gravity.START)){
            drawer_layout.closeDrawer(Gravity.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_list:
                startActivity(new Intent(this, ListViewActivity.class));
                break;

            case R.id.nav_recyclerView:
                startActivity(new Intent(this, RecyclerActivity.class));
                break;

            case R.id.nav_spinner:
                startActivity(new Intent(this, SpinnerActivity.class));
                break;

            case R.id.nav_contact:
                startActivity(new Intent(this, ContactActivity.class));
                break;

            case R.id.nav_async:
                startActivity(new Intent(this, AsyncActivity.class));
                break;

        }
        if(drawer_layout.isDrawerOpen(Gravity.START)){
            drawer_layout.closeDrawer(Gravity.START);
        }
        return true;
    }
}
