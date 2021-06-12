package com.antsoftware.ejemplorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.antsoftware.ejemplorecyclerview.db.DBHelper;
import com.antsoftware.ejemplorecyclerview.recycler.adapters.UserAdapter;
import com.antsoftware.ejemplorecyclerview.recycler.models.UserModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private RecyclerView myRecycler;
    private UserAdapter userAdapter;
    private Button refreshButton;
    private Button cleanButton;
    private ArrayList<UserModel> myList = new ArrayList<>();

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
        myList.add(new UserModel("1","Bryan","20","A0SKSHND0"));
        myList.add(new UserModel("2", "Chris","21","A0SKSHND1"));
        myList.add(new UserModel("3", "Emma","21","A0SKSHND2"));
        myList.add(new UserModel("4", "Ivan","22","A0SKSHND3"));
        myList.add(new UserModel("5", "Astrid","21","A0SKSHND4"));
        myList.add(new UserModel("6", "Nenoc","21","A0SKSHND5"));
        myList.add(new UserModel("7", "Carlos","22","A0SKSHND6"));
        myList.add(new UserModel("8", "Stan","31","A0SKSHND7"));
        myList.add(new UserModel("9", "Isaac","22","A0SKSHND8"));
        myList.add(new UserModel("10", "Marce","21","A0SKSHND9"));

        setList();
    }

    private void setList(){
        userAdapter = new UserAdapter(myList);
        myRecycler.setAdapter(userAdapter);
    }

    private void refreshList(){
        Toast.makeText(this, "Refrescando...", Toast.LENGTH_LONG).show();
        myList.add(new UserModel("11", "Aranza", "21", "A0SKSHND10"));
        myList.add(new UserModel("12", "Diego", "21", "A0SKSHND11"));
        userAdapter = new UserAdapter(myList);
        myRecycler.setAdapter(userAdapter);
    }

    private void cleanList(){
        myList.clear();
        setList();
    }
}