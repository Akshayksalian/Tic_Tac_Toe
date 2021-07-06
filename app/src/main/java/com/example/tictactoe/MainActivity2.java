package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    
    // Here o is representing X and 1 is representing O
    // 2 is representing null

    int activeplayer = 0;
    int [] emptystate = {2,2,2,2,2,2,2,2,2};
    int [][] winners = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    String winnerwas;

    @SuppressLint("SetTextI18n")
    public void playertap(View view){
        ImageView img = (ImageView) view;
        int tap = Integer.parseInt(img.getTag().toString());

        if(emptystate[tap]==2) {
            emptystate[tap] = activeplayer;
            img.setTranslationY(-1000f);                            // Image is kept away from the user that they cant see unless it shown by us.
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;                                   // This will turn empty state from 2 to 1 at tapped position.
                TextView status = findViewById(R.id.status);
                status.setText(" O - Turn");
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;                                   // This will turn empty state from 2 to 0 at tapped position.
                TextView status = findViewById(R.id.status);
                status.setText(" X - Turn");
            }
            img.animate().translationYBy(1000f).setDuration(300);   // Image is bought to proper position.
        }
        
        // Checking for any player has won or not
        
        for(int [] win : winners){
            if(emptystate[win[0]]==emptystate[win[1]] &&           // Here 0 and 1 is representing x and o in empty state array
                 emptystate[win[1]]==emptystate[win[2]] &&
                         (emptystate[win[0]]!=2)) {

                if (emptystate[win[0]] == 0) {
                    TextView status = findViewById(R.id.status);
                    status.setText("X has WON");
                    return;
                } else {
                    TextView status = findViewById(R.id.status);
                    status.setText("O has WON");
                    return;
                }
            }
        }
    }
    
    
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

}