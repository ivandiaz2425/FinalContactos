package com.example.jonmid.contactosbasededatos.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.contactosbasededatos.Models.Comment;
import com.example.jonmid.contactosbasededatos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonmid on 9/11/17.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    List<Comment> commentList = new ArrayList<>();
    Context context;

    public CommentAdapter(List<Comment> commentList, Context context) {
        this.commentList = commentList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewTitle.setText(commentList.get(position).getTitle());
        holder.textViewComment.setText(commentList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewTitle;
        TextView textViewComment;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            textViewTitle = (TextView) item.findViewById(R.id.id_tv_item_comment_title);
            textViewComment = (TextView) item.findViewById(R.id.id_tv_item_comment_comment);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
        }
    }

}
