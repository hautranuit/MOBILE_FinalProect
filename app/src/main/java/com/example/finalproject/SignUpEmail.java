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

public class SignUpEmail extends AppCompatActivity {

    ImageView btnClose;
    EditText edittext_email;
    ImageView btnrightarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_email);

        edittext_email = findViewById(R.id.edittext_email);
        btnClose = findViewById(R.id.btnClose);
        btnrightarrow = findViewById(R.id.btnrightarrow);

        // Nhận tên đầy đủ từ Intent
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("fullName");

        // Xử lý nút đóng (btnClose)
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpEmail.this, LoginScreen.class);
                startActivity(intent);
            }
        });

        // Xử lý nút mũi tên (btnRightArrow)
        btnrightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edittext_email.getText().toString().trim();

                // Kiểm tra nếu ô email rỗng
                if (email.isEmpty()) {
                    Toast.makeText(SignUpEmail.this, "Ô email không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    // Tạo Intent và truyền cả tên đầy đủ và email tới SignUpUsername
                    Intent intent = new Intent(SignUpEmail.this, SignUpUsername.class);
                    intent.putExtra("fullName", fullName); // Truyền tên đầy đủ
                    intent.putExtra("email", email);       // Truyền email
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
