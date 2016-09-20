package com.example.dell.apptabtest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.SpringBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

/**
 * Created by dell on 2016/7/26.
 */
public class TestActivity4 extends Activity {
    private IndicatorViewPager indicatorViewPager;

    private int unSelectColor;

    private int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};

    private LayoutInflater inflate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test_ac_4);

        ViewPager viewPager = (ViewPager) findViewById(R.id.guide_viewPager);
        Indicator indicator = (ScrollIndicatorView) findViewById(R.id.spring_indicator);
        inflate = LayoutInflater.from(getApplicationContext());

        int selectColor = Color.parseColor("#f8f8f8");
        unSelectColor = Color.parseColor("#010101");
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor));
        indicator.setScrollBar(new SpringBar(getApplicationContext(), Color.GRAY));

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);

        indicatorViewPager.setAdapter(adapter);
    }

    private IndicatorViewPager.IndicatorViewPagerAdapter adapter=new IndicatorViewPager.IndicatorViewPagerAdapter() {
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            int padding = DisplayUtil.dipToPix(getApplicationContext(), 10);
            textView.setPadding(padding, 0, padding, 0);
            textView.setText(String.valueOf(position));
            textView.setTextColor(unSelectColor);
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = new View(getApplicationContext());
                convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            convertView.setBackgroundResource(images[position]);
            return convertView;
        }
    };
}
