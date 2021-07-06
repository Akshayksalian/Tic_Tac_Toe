package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void newPage(View view){
        Toast.makeText(MainActivity.this, "Lets Play!!", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);

    }
}