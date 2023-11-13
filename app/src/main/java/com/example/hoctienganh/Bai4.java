package com.example.hoctienganh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Bai4 extends AppCompatActivity {
    DatabaseReference mData ;
    ListView lvXe ;
    ArrayList<String> mangPhuongTien;
    ArrayAdapter adapter = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        mData = FirebaseDatabase.getInstance().getReference();
        lvXe = findViewById(R.id.lvPhuongTien);
        mangPhuongTien = new ArrayList<>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mangPhuongTien);
        lvXe.setAdapter(adapter);
        PhuongTien pt = new PhuongTien("Xe khách",10);
    //    mData.child("PhuongTienTest").push().setValue(pt);

        mData.child("PhuongTienTest").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                PhuongTien phuongTien = snapshot.getValue(PhuongTien.class);
                mangPhuongTien.add(phuongTien.ten+"-"+phuongTien.banh+"Bánh");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}