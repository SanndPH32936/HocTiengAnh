package com.example.hoctienganh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase db ;
    private DatabaseReference ref;
    private EditText edtTest;
    private Button btnSend,btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference();

        edtTest = findViewById(R.id.edtTest);
        btnSend = findViewById(R.id.btnSend);
        btnRead = findViewById(R.id.btnRead);
        findViewById(R.id.btnBai2RealTime).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,Bai2.class));
        });
        findViewById(R.id.btnBai3RealTime).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,Bai3.class));
        });
        findViewById(R.id.btnBai4RealTime).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,Bai4.class));
        });
        findViewById(R.id.btnMoDangKi).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,DangKi.class));
        });
        findViewById(R.id.btnBai5RealTime).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,Bai5.class));
        });
        btnSend.setOnClickListener( v -> {
      //     ref.setValue(edtTest.getText().toString());
            Product product = new Product(1001,"Bàn phím",850000);
        //    ref.child("products").child(String.valueOf(product.getId())).setValue(product);
            ref.child("products").setValue(product);

            // Trường hợp map
            Map<String,Integer> myMap = new HashMap<String,Integer>();
            myMap .put("Xe máy",2);
            myMap .put("Ô tô",4);
            ref.child("PhuongTien").setValue(myMap);

            //Sử dụng push
            Product pr = new Product(1001,"Vô lăng",850000);
            ref.child("HocVien").push().setValue(pr);

            //Bắt sự kiện hoàn thành khi nhập value

            ref.child("NguyenDucSan").setValue("Lập trình android", new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    if (error == null){
                        Toast.makeText(MainActivity.this, "lưu thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Lưu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        });

        btnRead.setOnClickListener(v -> {

        });

    }



}