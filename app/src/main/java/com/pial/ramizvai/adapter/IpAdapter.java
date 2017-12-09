package com.pial.ramizvai.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pial.ramizvai.R;
import com.pial.ramizvai.listener.clickListener;
import com.pial.ramizvai.pojoClass.UrlPojo;

import java.util.ArrayList;

/**
 * Created by pial on 12/10/17.
 */

public class IpAdapter extends RecyclerView.Adapter<IpAdapter.IPHolder>{

    private ArrayList<UrlPojo> urlPojoArrayList = new ArrayList<>();
    private clickListener clickListener;

    public IpAdapter(ArrayList<UrlPojo> urlPojoArrayList, com.pial.ramizvai.listener.clickListener clickListener) {
        this.urlPojoArrayList = urlPojoArrayList;
        this.clickListener = clickListener;
    }

    @Override
    public IPHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ip_layout, parent, false);
        IpAdapter.IPHolder ipHolder = new IpAdapter.IPHolder(view);
        return ipHolder;
    }

    @Override
    public void onBindViewHolder(IPHolder holder, int position) {
        UrlPojo urlPojo = urlPojoArrayList.get(position);
        holder.url.setText(urlPojo.getUrlName());
    }

    @Override
    public int getItemCount() {
        return urlPojoArrayList.size();
    }

    public class IPHolder extends RecyclerView.ViewHolder {
        private TextView url;
        public IPHolder(View itemView) {
            super(itemView);
            url =itemView.findViewById(R.id.urlName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onClik(urlPojoArrayList.get(getAdapterPosition()).getUrlName());
                }
            });
        }
    }
}
