package com.example.walkthrough_tutorial_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter  extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    //Arrays

    public int[] slide_imgs = {R.drawable.eat_icon, R.drawable.code_icon, R.drawable.sleep_icon};
    public String[] slide_titles={"Eat", "Code", "Sleep"};
    public String[] slide_descs={
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sed maximus nisi. Aliquam pretium odio eget nunc iaculis, nec interdum erat maximus. Maecenas elit nibh, sagittis sit amet lacus eu, commodo lobortis mi. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sed maximus nisi. Aliquam pretium odio eget nunc iaculis, nec interdum erat maximus. Maecenas elit nibh, sagittis sit amet lacus eu, commodo lobortis mi. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sed maximus nisi. Aliquam pretium odio eget nunc iaculis, nec interdum erat maximus. Maecenas elit nibh, sagittis sit amet lacus eu, commodo lobortis mi. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."
    };

    public SliderAdapter(Context context){
        this.context=context;

    }



    @Override
    public int getCount() {
        return slide_titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }


    //By były te kulki z przewijaniem
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImage = (ImageView) view.findViewById(R.id.slide_img);
        TextView slideTitle = (TextView) view.findViewById(R.id.slide_title);
        TextView slideDesc = (TextView) view.findViewById(R.id.slide_desc);


        slideImage.setImageResource(slide_imgs[position]);
        slideTitle.setText(slide_titles[position]);
        slideDesc.setText(slide_descs[position]);

        container.addView(view);

       return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((ConstraintLayout) object);
    }
}
