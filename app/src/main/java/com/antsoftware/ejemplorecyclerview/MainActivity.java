package com.antsoftware.ejemplorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.antsoftware.ejemplorecyclerview.db.DBHelper;
import com.antsoftware.ejemplorecyclerview.db.models.StudentsModel;
import com.antsoftware.ejemplorecyclerview.recycler.adapters.UserAdapter;
import com.antsoftware.ejemplorecyclerview.recycler.models.UserModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private RecyclerView myRecycler;
    private UserAdapter userAdapter;
    private Button refreshButton;
    private Button cleanButton;
    private ArrayList<StudentsModel> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        db = new DBHelper(this);

        myRecycler = (RecyclerView) findViewById(R.id.myRecycler);
        myRecycler.setHasFixedSize(true);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));
        initializeList();
        setList();

        refreshButton = (Button) findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshList();
            }
        });
        cleanButton = (Button) findViewById(R.id.cleanButton);
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanList();
            }
        });


    }
    private void initializeList(){
        myList = db.fetchStudents();
        setList();
    }

    private void setList(){
        userAdapter = new UserAdapter(myList);
        myRecycler.setAdapter(userAdapter);
    }

    private void refreshList(){
        Toast.makeText(this, "Refrescando...", Toast.LENGTH_LONG).show();
        myList.add(new StudentsModel(11, "Aranza", 21));
        myList.add(new StudentsModel(12, "Diego", 21));
        userAdapter = new UserAdapter(myList);
        myRecycler.setAdapter(userAdapter);
    }

    private void cleanList(){
        myList.clear();
        setList();
    }
}