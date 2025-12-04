package com.sykmm.realestate.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sykmm.realestate.PostAdapter;
import com.sykmm.realestate.R;
import com.sykmm.realestate.api.ApiClient;
import com.sykmm.realestate.models.WpPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerHome);
        progressBar = view.findViewById(R.id.progressHome);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadPosts();

        return view;
    }

    private void loadPosts() {
        progressBar.setVisibility(View.VISIBLE);

        ApiClient.getApiService().getPosts().enqueue(new Callback<List<WpPost>>() {
            @Override
            public void onResponse(Call<List<WpPost>> call, Response<List<WpPost>> response) {
                progressBar.setVisibility(View.GONE);

                if (!response.isSuccessful() || response.body() == null) {
                    Toast.makeText(getContext(), "Failed to load posts", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<WpPost> posts = response.body();

                PostAdapter adapter = new PostAdapter(
                        getContext(),
                        posts,
                        post -> {
                            // TODO: Open Post Details Activity
                            Toast.makeText(getContext(), post.getTitle().getRendered(), Toast.LENGTH_SHORT).show();
                        }
                );

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<WpPost>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}