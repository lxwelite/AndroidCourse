package com.sanda.androidcourse.chapter04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sanda.androidcourse.R;

public class CommonViewActivity extends AppCompatActivity {

    Button jumpToListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.chapter4_activity_common_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this, "toast提示用户", Toast.LENGTH_LONG).show();

        jumpToListBtn = (Button) findViewById(R.id.jumpToList);

        jumpToListBtn.setOnClickListener(view -> {
            Intent intent = new Intent(CommonViewActivity.this, RecycleViewActivity.class);
            startActivity(intent);
        });
    }
}