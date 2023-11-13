package com.example.hoctienganh;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.checkerframework.checker.nullness.qual.NonNull;

public class DangKi extends AppCompatActivity {
    Button btnDangKy,btnDangNhap ;
    EditText edtEmail , edtPass ,edtEmailDN , edtPassDN;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        mAuth = FirebaseAuth.getInstance();
        AnhXa();
        btnDangKy.setOnClickListener(v -> {
            DangKiAcc();
        });
        btnDangNhap.setOnClickListener(v -> {
            DangNhapAcc();
        });
    }
    private void DangNhapAcc (){
        String email = edtEmailDN.getText().toString();
        String password = edtPassDN.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(DangKi.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(DangKi.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private  void DangKiAcc (){
        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(DangKi.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                       }else {
                           Toast.makeText(DangKi.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                       }
                    }
                });

    }

    private void AnhXa (){
        btnDangKy =  findViewById(R.id.btnDangKi);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        edtEmailDN = findViewById(R.id.edtEmailDn);
        edtPassDN = findViewById(R.id.edtPassDn);

    }
}