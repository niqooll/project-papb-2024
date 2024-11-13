package ekardi.mobile.projekpam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ekardi.mobile.projekpam.databinding.FragmentProfilBinding;

public class ProfilFragment extends Fragment {

    private FragmentProfilBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfilBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Load saved data
        String savedUsername = getActivity().getSharedPreferences("ProfileData", getActivity().MODE_PRIVATE).getString("username", "Rasyad Ekardi");
        String savedEmail = getActivity().getSharedPreferences("ProfileData", getActivity().MODE_PRIVATE).getString("email", "rasyadpe@student.ub.ac.id");
        binding.tvNama.setText(savedUsername);
        binding.tvEmail.setText(savedEmail);

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfil.class);
                intent.putExtra("nama", binding.tvNama.getText().toString());
                intent.putExtra("email", binding.tvEmail.getText().toString());
                startActivityForResult(intent, 1);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == getActivity().RESULT_OK && data != null) {
            String newNama = data.getStringExtra("nama");
            String newEmail = data.getStringExtra("email");
            if (newNama != null) binding.tvNama.setText(newNama);
            if (newEmail != null) binding.tvEmail.setText(newEmail);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Clear binding reference
    }
}