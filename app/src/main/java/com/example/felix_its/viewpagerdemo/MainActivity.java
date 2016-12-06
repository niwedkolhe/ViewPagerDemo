package com.example.felix_its.viewpagerdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.felix_its.viewpagerdemo.presenter.LoginPresenter;
import com.example.felix_its.viewpagerdemo.view.ILoginView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * Initialization of UI
     */
    private void init() {

        viewPager =(ViewPager)findViewById(R.id.pager);
        tabLayout = (TabLayout)findViewById(R.id.tabs);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {

        SimplePagerAdapter simplePagerAdapter = new SimplePagerAdapter(getSupportFragmentManager());

        simplePagerAdapter.addFragment(new OneFragment(),"ONE");
        simplePagerAdapter.addFragment(new TwoFragment(),"TWO");
        simplePagerAdapter.addFragment(new OneFragment(),"ONE");

        viewPager.setAdapter(simplePagerAdapter);
    }

    @Override
    public void showProgress() {
        //Show progress bar
        viewPager.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        //Hide progress bar
        viewPager.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {

    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void setValidationError() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tabs:

                LoginPresenter loginPresenter = new LoginPresenter(this);
                loginPresenter.setValidation("abc","xyz");

                break;
        }

    }

    /**
     * Creating Adapter for ViewPager
     */
    public class SimplePagerAdapter extends FragmentPagerAdapter{
        private List<Fragment>fragmentList  = new ArrayList<>();
        private List<String>fragmentTitleList = new ArrayList<>();

        public SimplePagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        public void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
}
