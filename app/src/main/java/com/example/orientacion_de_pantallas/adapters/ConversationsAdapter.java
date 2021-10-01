package com.example.orientacion_de_pantallas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orientacion_de_pantallas.R;
import com.example.orientacion_de_pantallas.models.ConversationModel;
import com.example.orientacion_de_pantallas.viewHolders.ConversationsListViewHolder;

import java.util.List;

public class ConversationsAdapter extends RecyclerView.Adapter<ConversationsListViewHolder> {

    List<ConversationModel> lstConversations;

    public ConversationsAdapter(List<ConversationModel> lstConversations) {
        this.lstConversations = lstConversations;
    }

    @NonNull
    @Override
    public ConversationsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_conversations, parent, false);
        return new ConversationsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationsListViewHolder holder, int position) {

        holder.getImgContact().setImageResource(lstConversations.get(position).getImgContact());
        holder.getTvName().setText(lstConversations.get(position).getName());
        holder.getTvMessage().setText(lstConversations.get(position).getMessage());
        holder.getTvTime().setText(lstConversations.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        //Nota. Del tamaño de la lista.
        return this.lstConversations.size();
    }
}
