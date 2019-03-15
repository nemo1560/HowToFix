package com.example.nemo1.ifixit.V;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nemo1.ifixit.Entity.Results;
import com.example.nemo1.ifixit.Interfaces.onClickURL;
import com.example.nemo1.ifixit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.RecycleViewHolder> {
    private List<Results>resultsList;
    private onClickURL onClickURL;
    private static int index;

    public DetailAdapter(List<Results> resultsList,onClickURL onClickURL ) {
        this.resultsList = resultsList;
        this.onClickURL = onClickURL;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_custom,viewGroup,false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecycleViewHolder recycleViewHolder, int i) {
        recycleViewHolder.title.setText(resultsList.get(i).getTitle());
        recycleViewHolder.summary.setText(resultsList.get(i).getSummary());
        if(resultsList.get(i).getImage() != null){
            Picasso.get().load(resultsList.get(i).getImage().getLarge()).into(recycleViewHolder.img_device);
        }
        else {
            recycleViewHolder.img_device.setImageResource(R.drawable.no_data_found);
        }
        index = i;
        recycleViewHolder.img_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == recycleViewHolder.img_device.getId()){
                    onClickURL.sendURL(resultsList.get(index).getUrl());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    //Create to ViewHolder
    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        private TextView title
                ,summary;
        private ImageView img_device;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            summary = itemView.findViewById(R.id.summary);
            img_device = itemView.findViewById(R.id.img_device);
        }
    }
}
