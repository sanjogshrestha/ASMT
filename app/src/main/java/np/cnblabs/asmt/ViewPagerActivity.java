package np.cnblabs.asmt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import np.cnblabs.asmt.fragment.Bhaktapur;
import np.cnblabs.asmt.fragment.Kathmandu;
import np.cnblabs.asmt.fragment.Lalitpur;

/**
 * Created by sanjogstha on 12/28/17.
 * CNB LABS
 * sanjogshrestha.nepal@gmail.com
 */

public class ViewPagerActivity extends AppCompatActivity{
    ViewPager viewPager;
    Toolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.viewPager);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);

        CustomViewPagerAdapter customViewPagerAdapter =
                new CustomViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(customViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class CustomViewPagerAdapter extends FragmentStatePagerAdapter {
        String[] tabList = {"Kathmandu", "Bhaktapur", "Lalitpur"};

        CustomViewPagerAdapter(FragmentManager supportFragmentManager,
                               Context context) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Kathmandu.newInstance();

                case 1:
                    return Bhaktapur.newInstance();

                case 2:
                    return Lalitpur.newInstance();

            }
            return null;
        }

        @Override
        public int getCount() {
            return tabList.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabList[position];
        }
    }
}
