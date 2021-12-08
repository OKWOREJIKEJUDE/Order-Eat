package com.example.ordereat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {
    MainActivity mainActivity;
    int[] images;
    String[] firstString;
    String[] secondString;

    public Adapter(MainActivity mainActivity, int[] images, String[] firstString, String[] secondString) {
        this.mainActivity = mainActivity;
        this.images = images;
        this.firstString = firstString;
        this.secondString = secondString;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_pager_adapter, container,false);

        ImageView myImages;
        TextView headingFF;
        TextView mydescription;
        //Button myNext;

        myImages = view.findViewById(R.id.pagerGIRLpng);
        headingFF = view.findViewById(R.id.pagerFirst);
        mydescription = view.findViewById(R.id.pagerThird);
        //myNext = view.findViewById(R.id.myNext);

        myImages.setBackgroundResource(images[position]);
        headingFF.setText(firstString[position]);
        mydescription.setText(secondString[position]);
       /* myNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity, GoActivity.class);
                intent.putExtra("position", position);
                mainActivity.startActivity(intent);
                mainActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                //WelcomePage welcomePage = new WelcomePage();
                //welcomePage.open();
            }
        });

        */


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        container.removeView((View) object);
    }
}
