package ekardi.mobile.projekpam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import ekardi.mobile.projekpam.databinding.FragmentRiwayatBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RiwayatFragment extends Fragment {
    private AdapterRiwayat adapter;
    private OkHttpClient client = new OkHttpClient();
    private ArrayList<ItemRiwayat> items = new ArrayList<>();
    private FragmentRiwayatBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRiwayatBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Setup RecyclerView
        binding.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterRiwayat(items, getActivity());
        binding.mRecyclerView.setAdapter(adapter);


        fetchCategories("http://192.168.0.4/PAM/konser.json"); // Ganti URL sesuai kebutuhan

        return view;
    }

    private void fetchCategories(String url) {
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(getActivity(), "Failed to fetch data: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String jsonResponse = response.body().string();
                    Gson gson = new Gson();
                    Type categoryListType = new TypeToken<ArrayList<ItemRiwayat>>() {}.getType();
                    ArrayList<ItemRiwayat> categories = gson.fromJson(jsonResponse, categoryListType);
                    requireActivity().runOnUiThread(() -> {
                        items.clear();
                        items.addAll(categories);
                        adapter.notifyDataSetChanged();
                    });
                } else {
                    requireActivity().runOnUiThread(() ->
                            Toast.makeText(getActivity(), "Failed to fetch data", Toast.LENGTH_SHORT).show()
                    );
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Clear binding reference
    }
}