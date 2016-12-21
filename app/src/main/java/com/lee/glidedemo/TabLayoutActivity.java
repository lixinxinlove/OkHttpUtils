
package com.lee.glidedemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lee.glidedemo.fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        initTab();

    }

    private void initTab() {

        List<Fragment> mList = new ArrayList<>();
        List<String> titles = new ArrayList<>();

        OrderFragment orderFragment1 = new OrderFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("title", "title1");
        orderFragment1.setArguments(bundle1);

        OrderFragment orderFragment2 = new OrderFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("title", "title2");
        orderFragment2.setArguments(bundle2);

        OrderFragment orderFragment3 = new OrderFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString("title", "title3");
        orderFragment3.setArguments(bundle3);

        OrderFragment orderFragment4 = new OrderFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putString("title", "title4");
        orderFragment4.setArguments(bundle4);

        OrderFragment orderFragment5 = new OrderFragment();
        Bundle bundle5 = new Bundle();
        bundle5.putString("title", "title5");
        orderFragment5.setArguments(bundle5);

        mList.add(orderFragment1);
        mList.add(orderFragment2);
        mList.add(orderFragment3);
        mList.add(orderFragment4);
        mList.add(orderFragment5);

        titles.add("全部");
        titles.add("已完成");
        titles.add("待发货");
        titles.add("待审核");
        titles.add("待支付");


        adapter = new OrderAdapter(getSupportFragmentManager(), mList, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
