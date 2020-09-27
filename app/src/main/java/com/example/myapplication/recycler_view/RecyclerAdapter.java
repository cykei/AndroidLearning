package com.example.myapplication.recycler_view;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardViewHolder> {

    private Context context;
    private ArrayList<CardItem> mItems;

    private int lastPosition = -1;

    public RecyclerAdapter(Context context, ArrayList<CardItem> mItems) {
        this.context = context;
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //새로운 뷰를 만든다.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_carditem, parent, false);
        CardViewHolder holder = new CardViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.imageView.setImageResource(mItems.get(position).poster); //public 이 아닌데 그냥 참조가 되네?
        holder.textView.setText(mItems.get(position).title);

        setAnimation(holder.imageView, position); // 동작 확인 필수
    }

    @Override
    public int getItemCount() {
        return (mItems!=null ? mItems.size() : 0);
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        // 왜 Public 으로 선언할 수 있지?
        // 한 파일에 Public class는 하나밖에 생성할 수 없는거 아니었나?

        public ImageView imageView;
        public TextView textView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.card_image);
            textView = (TextView) itemView.findViewById(R.id.card_title);
        }
    }

    private void setAnimation(View viewToAnimate, int position){
        // 새로 보여지는 뷰라면 애니메이션을 해줍니다.
        if( position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
