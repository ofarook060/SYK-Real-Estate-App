package com.sykmm.realestate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sykmm.realestate.models.WpPost;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<WpPost> posts;
    private OnPostClickListener listener;

    public interface OnPostClickListener {
        void onPostClick(WpPost post);
    }

    public PostAdapter(Context context, List<WpPost> posts, OnPostClickListener listener) {
        this.context = context;
        this.posts = posts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        WpPost post = posts.get(position);

        // Title
        holder.title.setText(post.getTitle() != null ? post.getTitle().getRendered() : "No Title");

        // Featured image
        String imageUrl = post.getFeaturedImageUrl();

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.thumbnail);
        } else {
            holder.thumbnail.setImageResource(R.drawable.placeholder);
        }

        // Click event
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onPostClick(post);
        });
    }

    @Override
    public int getItemCount() {
        return posts != null ? posts.size() : 0;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView thumbnail;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.postTitle);
            thumbnail = itemView.findViewById(R.id.postImage);
        }
    }
}