package com.example.yogagu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    static MyDatabase db;
    private FirebaseListAdapter firebaseListAdapter;
    private DatabaseReference database;
    private String GUIDE_GROUP = "guide";
    private ArrayList<FirebaseGuide> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }
    private void initRecyclerView(){

        recyclerView = (RecyclerView)findViewById(R.id.RV);
        database = FirebaseDatabase.getInstance().getReference(GUIDE_GROUP);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        list = new ArrayList<>();
        firebaseListAdapter = new FirebaseListAdapter(this,list);
        recyclerView.setAdapter(firebaseListAdapter);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    FirebaseGuide guide = dataSnapshot.getValue(FirebaseGuide.class);
                    list.add(guide);
                }
                firebaseListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data,DataSnapshot snapshot) {
//        for (DataSnapshot dataSnapshot: snapshot.getChildren()){
//            FirebaseGuide guide = dataSnapshot.getValue(FirebaseGuide.class);
//            list.add(guide);
//        }
//        firebaseListAdapter.notifyDataSetChanged();
//        super.onActivityResult(requestCode, resultCode, data);
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        firebaseListAdapter.setUserList(mGuideList);
//    }
//
//
//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.category:

                break;
            case R.id.createguide:
                Intent intent = new Intent(this, AddGuideActivity.class);
                startActivity(intent);
                break;
            case R.id.myguide:
                intent = new Intent(this, MyGuideActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
