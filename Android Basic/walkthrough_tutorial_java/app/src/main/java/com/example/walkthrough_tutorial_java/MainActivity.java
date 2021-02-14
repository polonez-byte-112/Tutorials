package com.example.walkthrough_tutorial_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;
    private SliderAdapter sliderAdapter;

    private int mCurrentPage;



    private Button mBackBtn, mNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.sliderLayout);

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewPagerListener);


        mBackBtn = (Button) findViewById(R.id.back_btn);
        mNextBtn = (Button) findViewById(R.id.next_btn);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentPage+1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentPage-1);
            }
        });
    }


    public  void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            mDotLayout.addView(mDots[i]);
        }


        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }



    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                addDotsIndicator(position);
                mCurrentPage =position;
                if(position==0){
                    mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(false);

                    mBackBtn.setVisibility(View.INVISIBLE);
                    mNextBtn.setText("Next");
                    mBackBtn.setText("");
                }else if(position == (mDots.length -1)){
                    mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(true);
                    mNextBtn.setText("Finish");
                    mBackBtn.setText("Back");
                }else{
                    mNextBtn.setEnabled(true);
                    mBackBtn.setEnabled(true);
                    mBackBtn.setVisibility(View.VISIBLE);
                    mNextBtn.setText("Next");
                    mBackBtn.setText("Back");
                }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}