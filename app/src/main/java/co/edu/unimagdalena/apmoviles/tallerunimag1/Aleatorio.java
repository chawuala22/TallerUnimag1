package co.edu.unimagdalena.apmoviles.tallerunimag1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Aleatorio extends AppCompatActivity {


    Button btnRandom;
    TextView tvrandom1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        getSupportActionBar().setTitle("Random");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnRandom= findViewById(R.id.random);
        tvrandom1 = findViewById(R.id.tvrandom);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int max = 50, min = -50;
                Random random = new Random();

                int num= random.nextInt((max-min)+1)+min;
                tvrandom1.setText("" + num);
            }
        });

    }
    @Override
    public void onBackPressed() {
    }


}