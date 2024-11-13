package ekardi.mobile.projekpam;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigation = findViewById(R.id.navBar);

        // Set listener untuk BottomNavigationView
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                // Menggunakan if-else untuk menentukan fragment yang dipilih
                if (item.getItemId() == R.id.navHome) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.navRiwayat) {
                    selectedFragment = new RiwayatFragment();
                } else if (item.getItemId() == R.id.navProfil) {
                    selectedFragment = new ProfilFragment();
                }

                // Ganti fragment hanya jika selectedFragment tidak null
                if (selectedFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, selectedFragment);
                    transaction.commit();
                }
                return true;
            }
        });

        // Set fragment default saat Activity pertama kali dibuka
        if (savedInstanceState == null) {
            bottomNavigation.setSelectedItemId(R.id.navHome); // Set default item
        }
    }
}