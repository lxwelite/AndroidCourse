package com.sanda.androidcourse.chapter05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sanda.androidcourse.R;

public class MenuActivity extends AppCompatActivity {

    private Button btnLeft, btnRight;
    private String buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.chapter5_activity_menu);

        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(v -> {
            buttonText = btnLeft.getText().toString();
            replaceFragment(LeftFragment.newInstance(buttonText));
        });

        btnRight.setOnClickListener(v -> {
            buttonText = btnRight.getText().toString();
            replaceFragment(RightFragment.newInstance(buttonText));
        });

        // 默认显示 LeftFragment
        replaceFragment(LeftFragment.newInstance(btnLeft.getText().toString()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}