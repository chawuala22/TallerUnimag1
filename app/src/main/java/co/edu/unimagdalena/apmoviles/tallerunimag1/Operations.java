package co.edu.unimagdalena.apmoviles.tallerunimag1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Operations extends AppCompatActivity implements View.OnClickListener {

    EditText num1,num2;
    Button btnsumar,btnrestar,btndivi,btnmulti,btnmcm, btncmd,btnmayor;
    ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_operations);
            instanciar();
            buttons();

        getSupportActionBar().setTitle("Taller #1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Glide.with(this).load("https://www.unimagdalena.edu.co/Content/Imagenes/escudo_unimag_sm.png").into(imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.random :
                startActivity(new Intent(this, Aleatorio.class ));
                break;

            case R.id.distance :
                startActivity(new Intent(this,Distance.class ));
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    private void buttons() {
        btnrestar.setOnClickListener(this);
        btnsumar.setOnClickListener(this);
        btnmulti.setOnClickListener(this);
        btndivi.setOnClickListener(this);
        btnmcm.setOnClickListener(this);
        btncmd.setOnClickListener(this);
        btnmayor.setOnClickListener(this);
    }
    private void instanciar() {
        num1 = findViewById(R.id.numero1);
        num2 = findViewById(R.id.numero2);
        btnsumar = findViewById(R.id.btnsumar);
        btnrestar = findViewById(R.id.btnrestar);
        btndivi= findViewById(R.id.btndiv);
        btnmulti=findViewById(R.id.btnmulti);
        btnmcm=findViewById(R.id.btnmcm);
        btncmd=findViewById(R.id.btnmcd);
        btnmayor = findViewById(R.id.btnmayor);
       imageView1 = findViewById(R.id.imageView);
    }
    @Override
    public void onClick(View view) {


        String number1 = num1.getText().toString();
        String number2 = num2.getText().toString();

        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(this, "Hace falta numeros para realizar alguna operación", Toast.LENGTH_LONG).show();
        } else {
            double numero1 = Double.parseDouble(num1.getText().toString());
            double numero2 = Double.parseDouble(num2.getText().toString());
            double mayor = 0, mcm = 0;

            switch (view.getId()) {
                case R.id.btnsumar:
                    Toast.makeText(this, numero1 + " + " + numero2 + " : " + (numero1 + numero2), Toast.LENGTH_LONG).show();
                    break;

                case R.id.btnrestar:
                    Toast.makeText(this, numero1 + " - " + numero2 + " : " + (numero1 - numero2), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnmulti:
                    Toast.makeText(this, numero1 + " * " + numero2 + " : " + (numero1 * numero2), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btndiv:
                    if (numero2 != 0) {
                        Toast.makeText(this, numero1 + " / " + numero2 + " : " + (numero1 / numero2), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "Dividendo debe ser diferente de 0", Toast.LENGTH_LONG).show();
                        num2.setText("");
                    }
                    break;
                case R.id.btnmcd:
                    while (numero1 != numero2) {
                        if (numero1 > numero2) {
                            numero1 = numero1 - numero2;
                        } else {
                            numero2 = numero2 - numero1;
                        }
                    }
                    Toast.makeText(this, "El Minimo Común Divisor es :" + numero1, Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnmcm:
                    if (numero1 % numero2 == 0 || numero2 % numero1 == 0) {
                        if (numero1 > numero2) {
                            mcm = numero1;
                            Toast.makeText(this, "El Minimo Común Multiplo es :" + mcm, Toast.LENGTH_LONG).show();
                        } else {
                            mcm = numero2;
                            Toast.makeText(this, "El Minimo Común Multiplo es :" + mcm, Toast.LENGTH_LONG).show();
                        }

                    } else {
                        mcm = numero1 * numero2;
                        if (mcm % 2 == 0) {
                            if ((mcm / 2) % numero1 == 0 && (mcm / 2) % numero2 == 0) {
                                mcm = mcm / 2;
                                Toast.makeText(this, "El Minimo Común Multiplo es :" + mcm, Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, "El Minimo Común Multiplo es :" + mcm, Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(this, "El Minimo Común Multiplo es :" + mcm, Toast.LENGTH_LONG).show();
                        }

                    }
                    break;

                case R.id.btnmayor:
                    if (numero1 > numero2) {
                        mayor = numero1;
                        Toast.makeText(this, "El numero mayor es: " + mayor, Toast.LENGTH_LONG).show();

                    } else {
                        if (numero2 > numero1) {
                            mayor = numero2;
                            Toast.makeText(this, "El numero mayor es: " + mayor, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "Lo numeros son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
            }
        }
    }
    @Override
    public void onBackPressed() {
    }
}