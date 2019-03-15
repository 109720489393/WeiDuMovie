package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyAdapter_Yin;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.fragment.Fragment_Yin;
import com.bw.movie.fragment.Fragment_Yin1;
import com.bw.movie.fragment.Fragment_Yin2;
import com.bw.movie.fragment.Fragment_Yin3;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YinActivity extends BaseActivity {

    @BindView(R.id.view_page)
    ViewPager viewPage;
    @BindView(R.id.r1)
    RadioButton r1;
    @BindView(R.id.r2)
    RadioButton r2;
    @BindView(R.id.r3)
    RadioButton r3;
    @BindView(R.id.r4)
    RadioButton r4;
    @BindView(R.id.view_group)
    RadioGroup viewGroup;
    private boolean misScrolled;

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void getData() {
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment_Yin());
        list.add(new Fragment_Yin1());
        list.add(new Fragment_Yin2());
        list.add(new Fragment_Yin3());
        viewPage.setAdapter(new MyAdapter_Yin(getSupportFragmentManager(), list));
        viewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r1:
                        viewPage.setCurrentItem(0, true);
                        break;
                    case R.id.r2:
                        viewPage.setCurrentItem(1, true);
                        break;
                    case R.id.r3:
                        viewPage.setCurrentItem(2, true);
                        break;
                    case R.id.r4:
                        viewPage.setCurrentItem(3, true);
                        break;
                }
            }
        });
        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                viewGroup.check(viewGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                switch (i) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        misScrolled = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        misScrolled = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (viewPage.getCurrentItem() == viewPage.getAdapter().getCount() - 1 && !misScrolled) {
                            startActivity(new Intent(YinActivity.this, LoginActivity.class));
                            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                            finish();
                        }
                        misScrolled = true;
                        break;
                }


            }
        });
    }

    @Override
    protected int getView() {
        return R.layout.activity_main2;
    }
}
