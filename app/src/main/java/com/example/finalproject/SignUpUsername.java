package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpUsername extends AppCompatActivity {

    ImageView btnClose, btnrightarrow;
    EditText edit_text_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_username);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String fullName = intent.getStringExtra("fullName");

        btnrightarrow = findViewById(R.id.btnrightarrow);
        btnClose = findViewById(R.id.btnClose);
        edit_text_username = findViewById(R.id.text_username);

        // Xử lý sự kiện nút Close
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpUsername.this, LoginScreen.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện nút RightArrow
        btnrightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edit_text_username.getText().toString().trim();

                if (username.isEmpty()) {
                    // Hiển thị thông báo nếu username để trống
                    Toast.makeText(SignUpUsername.this, "Ô username không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    // Tạo Intent và truyền dữ liệu sang SignUp_Password
                    Intent intent = new Intent(SignUpUsername.this, SignUp_Password.class);
                    intent.putExtra("email", email);
                    intent.putExtra("fullName", fullName);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });

        // Điều chỉnh padding để phù hợp với system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
