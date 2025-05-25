package com.example.ttuguide.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ttuguide.R;
import com.example.ttuguide.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    private TextView profileText;
    SwitchCompat switchLang, switchTheme;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    FloatingActionButton qrFloatBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        qrFloatBtn=findViewById(R.id.qrFloatBtn);
        qrFloatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator( MainActivity.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Scan a QR Code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();
            }
        });



        replaceFragment(new HomeFragment());
       binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int items = item.getItemId();

            if (items == R.id.Home){
                replaceFragment(new HomeFragment());
            } else if (items ==R.id.university_in) {
                replaceFragment(new InFragment());
            }
            else if (items ==R.id.university_out) {
                replaceFragment(new OutFragment());
            }
            else if (items ==R.id.menu) {
                showBottomDialog();
            } else if (items ==R.id.menu) {

            }
            return true;

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                // Handle cancelation
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                // Handle successful scan
                String scannedUrl = result.getContents();
                openScannedLink(scannedUrl);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void openScannedLink(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);
        LinearLayout layoutSettings = dialog.findViewById(R.id.layoutSettings);
        LinearLayout layoutThemes = dialog.findViewById(R.id.layoutThemes);
        LinearLayout layoutProfile = dialog.findViewById(R.id.layoutProfile);
        LinearLayout layoutNotifications = dialog.findViewById(R.id.layoutNotifications);
        LinearLayout layoutGallery = dialog.findViewById(R.id.layoutGallary);
        LinearLayout layoutAboutUniv = dialog.findViewById(R.id.layoutAboutUniv);
        LinearLayout layoutAboutUs = dialog.findViewById(R.id.layoutAbouUs);
        LinearLayout layoutSchedule = dialog.findViewById(R.id.layoutSchedule);
        TextView profileText = dialog.findViewById(R.id.profileText);



        cancelButton.setOnClickListener(view -> dialog.dismiss());

        layoutSettings.setOnClickListener(view -> {
            //dialog.dismiss();  // Close the main bottom sheet dialog
            showSettingsDialog();  // Open the settings dialog
        });

//        layoutProfile.setOnClickListener(view -> {
//
//
//            FirebaseUser currentUser = mAuth.getCurrentUser();
//            if (currentUser != null) {
//                String userId = currentUser.getUid();
//                DatabaseReference userRef = databaseReference.child(userId).child("username");
//                userRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        String username = dataSnapshot.getValue(String.class);
//                        if (username != null) {
//                            profileText.setText("Welcome, " + username);
//                        } else {
//                            profileText.setText("Welcome");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                        profileText.setText("Welcome");
//                    }
//                });
//            } else {
//                Toast.makeText(MainActivity.this, "User not authenticated", Toast.LENGTH_SHORT).show();
//            }
//
//            Toast.makeText(MainActivity.this, "Log in", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//            finish();
//            dialog.dismiss();
//        });

        layoutNotifications.setOnClickListener(view -> {
            Toast.makeText(this, "Notifications Selected", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        layoutGallery.setOnClickListener(view -> {
            replaceFragment(new Gallery());
            dialog.dismiss();
        });

        layoutAboutUniv.setOnClickListener(view -> {
            replaceFragment(new AboutUniversity());
            dialog.dismiss();
        });

     layoutAboutUs.setOnClickListener(view -> {
         replaceFragment(new AboutUs());
         dialog.dismiss();
     });


        layoutSchedule.setOnClickListener(view -> {
            replaceFragment(new Schedule());
            dialog.dismiss();
        });


        dialog.show();

        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int) (getResources().getDisplayMetrics().heightPixels * 0.75));
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setWindowAnimations(R.style.DialogAnimation);
            window.setGravity(Gravity.BOTTOM);
        }
    }

    private void showSettingsDialog() {
        final Dialog settingsDialog = new Dialog(this);
        settingsDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        settingsDialog.setContentView(R.layout.settings_bottom_layout);

        ImageView cancelButton = settingsDialog.findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(view -> {
            settingsDialog.dismiss();
            //showBottomDialog();  // Open the main bottom sheet dialog again
        });

        switchLang = settingsDialog.findViewById(R.id.switchLang);
        switchTheme = settingsDialog.findViewById(R.id.switchTheme);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Load switch states from SharedPreferences
        switchLang.setChecked(sharedPreferences.getBoolean("Lang_Switch", false));
        //switchTheme.setChecked(sharedPreferences.getBoolean("Theme_Switch", false));

        // Set listeners for switches
        switchLang.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("Lang_Switch", isChecked);
            editor.commit();

            if (isChecked) {
                setLocale("ar"); // Change to Arabic
            } else {
                setLocale("en"); // Change to English
            }
            recreate(); // Restart activity to apply language change

        });

        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            //editor.putBoolean("Theme_Switch", isChecked);
            //editor.apply();
            // Implement your theme change logic here
        });

        settingsDialog.show();

        Window window = settingsDialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int) (getResources().getDisplayMetrics().heightPixels * 0.75));
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            // window.setWindowAnimations(R.style.DialogAnimation);
            window.setGravity(Gravity.BOTTOM);
        }
    }

    private void loadLocale() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Activity.MODE_PRIVATE);
        String language = sharedPreferences.getString("My_Lang", "ar");
        setLocale(language);
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.commit();
    }

}