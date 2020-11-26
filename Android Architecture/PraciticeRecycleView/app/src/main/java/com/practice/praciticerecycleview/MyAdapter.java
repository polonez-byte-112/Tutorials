package com.practice.praciticerecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String name[];
    String description[];
    int images[];
    Context context;

    public MyAdapter(Context context,  String s1[], String s2[], int images[]){
        this.context=context;

        description =s2;
        name =s1;
        this.images=images;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.my_row, parent,false);
        //Tak zwracamy ten layout my row  do MyViewHolder (klasa nizej)
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


    holder.myText1.setText(name[position]);
    holder.myText2.setText(description[position]);
    holder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myText1 = itemView.findViewById(R.id.myTitle);
            myText2 = itemView.findViewById(R.id.myDesc);
            imageView = itemView.findViewById(R.id.myImg);

        }
    }
}
