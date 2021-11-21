package com.example.yogagu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MyGuideActivity extends AppCompatActivity implements View.OnClickListener {
    private GuideListAdapter wordsListAdapter;
    static MyDatabase db;
    private DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_guide);
        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewMyGuides);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        db = MyDatabase.getDbInstance(getApplicationContext());
        List<Guide> wordsList = db.myDao().getAll();
        wordsListAdapter = new GuideListAdapter(wordsList);
        recyclerView.setAdapter(wordsListAdapter);
    }
    private void loadGuideList(){
        MyDatabase db = MyDatabase.getDbInstance(this.getApplicationContext());
        List<Guide> wordsList = db.myDao().getAll();
        wordsListAdapter.setUserList(wordsList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadGuideList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadGuideList();
    }
    public void onClick(View view) {
        database = FirebaseDatabase.getInstance().getReference("guide");
        database.removeValue();
        db = MyDatabase.getDbInstance(getApplicationContext());
        MyDao myDao = db.myDao();
        Guide guide = new Guide();
        myDao.nukeTable();
        loadGuideList();
    }
}