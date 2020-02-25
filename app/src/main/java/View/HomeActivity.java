package View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.utility.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import View.Fragment.ThirdFragment;
import View.Adapter.CategoryViewPagerAdapter;
import View.Fragment.FirstFragment;
import View.Fragment.SecondFragment;


public class HomeActivity extends AppCompatActivity {


    public Toolbar homeToolbar;
    public TabLayout categoryTabLayout;
    public ViewPager categoryViewpager;


    public CategoryViewPagerAdapter mCategoryViewPagerAdapter;
    private BottomNavigationView mBottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        setUpViewpager(categoryViewpager);
        categoryTabLayout.setupWithViewPager(categoryViewpager);


    }

    private void setUpViewpager(ViewPager viewpager) {

        mCategoryViewPagerAdapter = new CategoryViewPagerAdapter(getSupportFragmentManager());

        mCategoryViewPagerAdapter.addFragment(new FirstFragment(),"Today");
        mCategoryViewPagerAdapter.addFragment(new SecondFragment(),"Tommorrow");
        mCategoryViewPagerAdapter.addFragment(new ThirdFragment(),"Yesterday");

        viewpager.setAdapter(mCategoryViewPagerAdapter);


    }

    private void initViews() {

        homeToolbar = findViewById(R.id.home_toolbar);
        categoryTabLayout = findViewById(R.id.category_tab_layout);
        categoryViewpager = findViewById(R.id.category_viewpager);

        categoryTabLayout = findViewById(R.id.category_tab_layout);

        mBottomNavigationView = findViewById(R.id.home_bottomNavigationView);


    }
}
