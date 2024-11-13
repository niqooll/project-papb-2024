package ekardi.mobile.projekpam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfil extends AppCompatActivity {

    private EditText etNama, etEmail;
    private Button btnApply;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        // Inisialisasi view
        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.editEmail);
        btnApply = findViewById(R.id.btnApply);
        btnBack = findViewById(R.id.btnBack);

        // Ambil data dari Intent
        Intent intent = getIntent();
        String currentNama = intent.getStringExtra("nama");
        String currentEmail = intent.getStringExtra("email");

        // Set data ke EditText
        if (currentNama != null) {
            etNama.setText(currentNama);
        }
        if (currentEmail != null) {
            etEmail.setText(currentEmail);
        }

        // Set listener untuk tombol Apply
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNama = etNama.getText().toString();
                String newEmail = etEmail.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("nama", newNama);
                resultIntent.putExtra("email", newEmail);
                setResult(RESULT_OK, resultIntent);
                finish(); // Kembali ke ProfilFragment
            }
        });

        // Set listener untuk tombol Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Kembali ke ProfilFragment tanpa mengirim data
            }
        });
    }
}