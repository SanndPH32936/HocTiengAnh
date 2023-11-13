package com.example.hoctienganh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Bai2 extends AppCompatActivity {
    DatabaseReference mData;
    TextView tvCheck ;
    Button android , ios ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        mData = FirebaseDatabase.getInstance().getReference();
        tvCheck = findViewById(R.id.tvCheck);
        android = findViewById(R.id.btnAndroid);
        ios = findViewById(R.id.btnIOS);

        mData.child("Hello").setValue("Nguyễn Đức San");

        mData.child("Hello").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tvCheck.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        android.setOnClickListener(v -> {
            mData.child("Hello").setValue("Android");
        });

        ios.setOnClickListener(v -> {
            mData.child("Hello").setValue("IOS");
        });
    }
}