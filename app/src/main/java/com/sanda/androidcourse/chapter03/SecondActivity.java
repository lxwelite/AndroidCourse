package com.sanda.androidcourse.chapter03;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sanda.androidcourse.R;

public class SecondActivity extends AppCompatActivity {

    TextView middleTextView;
    TextView bottomTextView;
    Button finishButton;
    Button finishBackDataButton;
    Button finishBackDataButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.chapter3_activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        middleTextView = findViewById(R.id.middle_textView);
        bottomTextView = findViewById(R.id.bottom_textView);
        finishButton = findViewById(R.id.finish_button);
        finishBackDataButton = findViewById(R.id.finish_back_data_button);
        finishBackDataButton2 = findViewById(R.id.finish_back_data_button2);

        Intent intent = getIntent();

        /*
          1-接收来自String的数据
         */
        String param1 = intent.getStringExtra("param1");
        String param2 = intent.getStringExtra("param2");
        if (!TextUtils.isEmpty(param1) && !TextUtils.isEmpty(param2)) {
            middleTextView.setText(new StringBuilder().append(param1).append(param2).toString());
        }
        /*
          2-接收来自Bundle的数据
         */
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String param3 = bundle.getString("param3");
            String param4 = bundle.getString("param4");
            if (!TextUtils.isEmpty(param3) && !TextUtils.isEmpty(param4)) {
                bottomTextView.setText(new StringBuilder().append("接收从bundle的值 = ").append(param3).append(param4).toString());
            }
        }

        /*
          3-finish关闭页面
         */
        finishButton.setOnClickListener(view -> finish());

        /*
          4-finish关闭页面并且返回数据 API10以下
         */
        finishBackDataButton.setOnClickListener(view -> {
            Intent intent1 = new Intent();
            intent1.putExtra("data_return", "API10 以下  这是返回的数据");
            setResult(RESULT_OK, intent1);
            finish();
        });

        /*
          5-finish关闭页面并且返回数据 Api10 及 以上
         */
        finishBackDataButton2.setOnClickListener(view -> {
            Intent intent1 = new Intent();
            intent1.putExtra("data_return", "API10 以上  这是返回的数据");
            setResult(RESULT_OK, intent1);
            finish();
        });
    }
}