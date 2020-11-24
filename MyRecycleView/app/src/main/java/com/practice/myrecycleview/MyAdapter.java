package com.practice.myrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String data1[], data2[];
    int images[];

    Context context;

    public MyAdapter(Context context, String s1[], String s2[], int images[]){
        this.context=context;
        data1= s1;
        data2 = s2;
        this.images= images;
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
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Teraz odbieramy i znajdujemy id etc
        //Ta klasa przekazuje do onBind
        TextView myText1, myText2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myText1= itemView.findViewById(R.id.myTextView1);
            myText2= itemView.findViewById(R.id.myTextView2);
            imageView = itemView.findViewById(R.id.myImageView);



        }
    }
}
