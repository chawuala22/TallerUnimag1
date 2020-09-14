package co.edu.unimagdalena.apmoviles.tallerunimag1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Distance extends AppCompatActivity implements View.OnClickListener {

    Button btnpmedio, btnpendiente, btncuadrante;
    EditText etx1, etx2, ety1, ety2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        getSupportActionBar().setTitle("Distancia");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        instanciar();
        buttons();

    }
    @Override
    public void onClick(View view) {

        String x1 = etx1.getText().toString();
        String x2 = etx2.getText().toString();
        String y1 = ety1.getText().toString();
        String y2 = ety2.getText().toString();

        if (x1.isEmpty() || x2.isEmpty() || y1.isEmpty() || y2.isEmpty() ) {
            Toast.makeText(this, "Hace falta numeros para realizar alguna operación", Toast.LENGTH_LONG).show();
        } else {

            double numx1 = Double.parseDouble(etx1.getText().toString());
            double numx2 = Double.parseDouble(etx2.getText().toString());
            double numy1 = Double.parseDouble(ety1.getText().toString());
            double numy2 = Double.parseDouble(ety2.getText().toString());
            double m=0 , xm=0, ym=0;

            switch (view.getId()) {
              case R.id.btnpmedio:
                  xm= ((numx1+numx2)/2);
                  ym= ((numy1+numy2)/2);
                  Toast.makeText(this,"El punto medio es: "+ "("+ xm + " , "+ ym + ")",Toast.LENGTH_LONG).show();
                  break;

              case R.id.btnpendiente:

                  //Solo falta esto xd//

                  break;

              case R.id.btncuadra:

                  xm= ((numx1+numx2)/2);
                  ym= ((numy1+numy2)/2);
                  if(xm<0 && ym>0 ){
                      Toast.makeText(this,"Se encuentra en el cuadrante 2",Toast.LENGTH_LONG).show();
                  }
                  if(xm<0 && ym<0 ){
                      Toast.makeText(this,"Se encuentra en el cuadrante 3",Toast.LENGTH_LONG).show();
                  }
                  if(xm>0 && ym<0 ){
                      Toast.makeText(this,"Se encuentra en el cuadrante 4",Toast.LENGTH_LONG).show();
                  }
                  if(xm>0 && ym>0 ){
                      Toast.makeText(this,"Se encuentra en el cuadrante 1",Toast.LENGTH_LONG).show();
                  }
                  break;

          }

        }

    }
    private void instanciar() {
        btnpmedio=findViewById(R.id.btnpmedio);
        btnpendiente=findViewById(R.id.btnpendiente);
        btncuadrante=findViewById(R.id.btncuadra);
        etx1=findViewById(R.id.etx1);
        etx2=findViewById(R.id.etx2);
        ety1=findViewById(R.id.ety1);
        ety2=findViewById(R.id.ety2);
    }
    private void buttons() {
        btnpmedio.setOnClickListener(this);
        btnpendiente.setOnClickListener(this);
        btncuadrante.setOnClickListener(this);
    }
    @Override
    public void onBackPressed() {
    }
}