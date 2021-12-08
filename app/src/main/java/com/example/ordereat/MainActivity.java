package com.example.ordereat;

import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button myNext;
    private int current_position;
    TabLayout tabindicator;
    ViewPager viewPager;
    int images [] = {R.drawable.deliveryaddressamico1, R.drawable.icecreamselleramico1, R.drawable.coffeebreakpana1};
    String firstString [] = {"Get quality food delivered to you at your door step.", "Sell Food with Ease, Save your restaurant from overcrowding", "Chop Better food, Wahala no dey finish for our country"};
    String secondString [] = {"Food is not a commodity, food is life", "Dont want overcrowding in your restaurant? We ghat you.", "Good food is the foundation of genuine happiness"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myNext = (Button) findViewById(R.id.myNext);
        tabindicator = (TabLayout) findViewById(R.id.tabIndicator);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        final Adapter adapter = new Adapter(MainActivity.this, images, firstString, secondString);
        viewPager.setAdapter(adapter);
        tabindicator.setupWithViewPager(viewPager);
        tabindicator.setSelectedTabIndicatorHeight(0); //THIS LINE IS USED TO REMOVE TAB INDICATOR
        tabindicator.setSelected(false);
        tabindicator.setEnabled(false);
        tabindicator.setClickable(false);



        myNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touching();

                current_position = viewPager.getCurrentItem();
                if (current_position <  images.length){
                    current_position++;
                    viewPager.setCurrentItem(current_position);
                }
                if (current_position == 3){
                    Intent myIntent = new Intent(MainActivity.this, GPSActivity.class);
                    startActivity(myIntent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 2){
                    myNext.setText("Start");
                }else {
                    myNext.setText("Next");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void touching(){
    }
}
