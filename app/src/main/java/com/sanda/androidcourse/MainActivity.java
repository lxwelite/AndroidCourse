package com.sanda.androidcourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sanda.androidcourse.chapter03.FirstActivity;
import com.sanda.androidcourse.chapter05.CommonViewActivity;

public class MainActivity extends AppCompatActivity {

    Button chapter3Button;
    Button chapter4Button;
    Button chapter5Button;
    Button chapter6Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        chapter3Button = (Button) findViewById(R.id.chapter3_button);
        chapter4Button = (Button) findViewById(R.id.chapter4_button);
        chapter5Button = (Button) findViewById(R.id.chapter5_button);
        chapter6Button = (Button) findViewById(R.id.chapter6_button);

        chapter3Button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(intent);
        });

        chapter5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CommonViewActivity.class);
                startActivity(intent);
            }
        });
    }
}