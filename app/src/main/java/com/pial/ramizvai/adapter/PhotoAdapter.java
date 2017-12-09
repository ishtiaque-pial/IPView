package com.pial.ramizvai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pial.ramizvai.R;
import com.pial.ramizvai.pojoClass.PhotoPojo;

import java.util.ArrayList;

/**
 * Created by pial on 12/10/17.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    private ArrayList<PhotoPojo> photoPojos;
    private Context context;

    public PhotoAdapter(ArrayList<PhotoPojo> photoPojos, Context context) {
        this.photoPojos = photoPojos;
        this.context = context;
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_layout, parent, false);
        PhotoAdapter.PhotoHolder photoHolder = new PhotoAdapter.PhotoHolder(view);
        return photoHolder;
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        Glide.with(context)
                .load(photoPojos.get(position).getPhotoUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return photoPojos.size();
    }

    public class PhotoHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public PhotoHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
