package com.example.orientacion_de_pantallas.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orientacion_de_pantallas.R;

public class ConversationsListViewHolder extends RecyclerView.ViewHolder {

    ImageView imgContact;
    TextView tvName, tvMessage, tvTime;

    public ConversationsListViewHolder(@NonNull View itemView) {
        super(itemView);

        imgContact   = (ImageView) itemView.findViewById(R.id.ivContact);
        tvName      = (TextView) itemView.findViewById(R.id.tvName);
        tvMessage  = (TextView) itemView.findViewById(R.id.tvMessage);
        tvTime  = (TextView) itemView.findViewById(R.id.tvTime);

    }

    public ImageView getImgContact() {
        return imgContact;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvMessage() {
        return tvMessage;
    }

    public TextView getTvTime() {
        return tvTime;
    }
}
