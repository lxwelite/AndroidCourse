package com.sanda.androidcourse.chapter03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sanda.androidcourse.R;

public class FirstActivity extends AppCompatActivity {

    Button firstButton;
    Button secondButton;
    Button thirdButton;
    Button fourthButton;
    Button fifthButton;
    Button sixthButton;
    Button seventhButton;
    TextView callbackTextView;
    Button eighthButton;
    Button ninthButton;

    ActivityResultLauncher launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.chapter3_activity_first);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstButton = findViewById(R.id.first_button);
        secondButton = findViewById(R.id.second_button);
        thirdButton = findViewById(R.id.third_button);
        fourthButton = findViewById(R.id.fourth_button);
        fifthButton = findViewById(R.id.fifth_button);
        sixthButton = findViewById(R.id.sixth_button);
        seventhButton = findViewById(R.id.seventh_button);
        callbackTextView = findViewById(R.id.back_textview);
        eighthButton = findViewById(R.id.eighth_button);
        ninthButton = findViewById(R.id.ninth_button);


        /*
          8-StartActivityForResult()方法跳转到SecondActivity
          使用ActivityResultLauncher
         */
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK) {
                    String returnData = o.getData().getStringExtra("data_return");
                    callbackTextView.setText(returnData);
                }
            }
        });

        /*
          1-FirstActivity页面跳转到SecondActivity
          使用Lambda表达式
         */
        firstButton.setOnClickListener(v -> startActivity(new Intent(FirstActivity.this, SecondActivity.class)));

        /*
          2-FirstActivity页面跳转到SecondActivity
         */
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        /*
          3-FirstActivity页面跳转到SecondActivity
          传递String参数到第二个页面
         */
        thirdButton.setOnClickListener(view -> {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("param1", "data1");
            intent.putExtra("param2", "data2");
            startActivity(intent);
        });

        /*
          4-FirstActivity页面跳转到SecondActivity
          传递bundle参数到第二个页面
         */
        fourthButton.setOnClickListener(view -> {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("param3", "data3");
            bundle.putString("param4", "data4");
            intent.putExtras(bundle);
            startActivity(intent);
        });

        /*
          5-FirstActivity页面隐式跳转到SecondActivity
          在 SecondActivity 的 AndroidManifest.xml 中定义的 Action 名称 com.layouts_chapter3.ACTION_START_SECOND
         */
        fifthButton.setOnClickListener(view -> {
            Intent intent = new Intent("com.layouts_chapter3.ACTION_START_SECOND");
            startActivity(intent);
        });

        /*
          6-FirstActivity页面隐式跳转打开一个网页WebActivity
         */
        sixthButton.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.baidu.com"));
            startActivity(intent);
        });

        /*
          7-FirstActivity页面隐式跳转打开电话页面
         */
        seventhButton.setOnClickListener(view -> {
            String phone = "10086";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phone));
            startActivity(intent);
        });

        /*
          8-FirstActivity页面跳转到SecondActivity
          使用ActivityResultLauncher
         */
        eighthButton.setOnClickListener(view -> {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivityForResult(intent,2);
        });



        /*
          9-FirstActivity页面跳转到SecondActivity
          使用ActivityResultLauncher
         */
        ninthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                launcher.launch(intent);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {
            String returnData = data.getStringExtra("data_return");
            callbackTextView.setText(returnData);
        }

    }
}