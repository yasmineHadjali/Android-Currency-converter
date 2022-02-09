package com.example.convertisseur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity implements OnClickListener {
    //on declare les variables
    private EditText dinars,euro;
    private Button convertir,Remise_a_zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associer chaque variable a son champs

        dinars=(EditText)findViewById(R.id.dinars);
        euro=(EditText)findViewById(R.id.euro);
        convertir=(Button)findViewById(R.id.convertir) ;
        Remise_a_zero=(Button)findViewById(R.id.raz);


        //methode pour la remise a zero

        Remise_a_zero.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                euro.setText("");
                dinars.setText("");

            }
        });

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dinars.getText().toString().isEmpty() && euro.getText().toString().isEmpty()){
                    Toast afficher=Toast.makeText(getApplicationContext(),"Veuiller remplir un champs",Toast.LENGTH_SHORT);
                    afficher.show();
                }
                else if(euro.getText().toString().isEmpty())
                {
                    double da =Double.parseDouble(dinars.getText().toString());
                    double res1=(0.0062*da);
                    euro.setText(String.valueOf(res1));

                }

                else if(dinars.getText().toString().isEmpty()){

                    double eu=Double.parseDouble(euro.getText().toString());
                    double res2=(162.53*eu);
                    dinars.setText(String.valueOf(res2));
                }
                else
                {
                    Toast afficher=Toast.makeText(getApplicationContext(),"Conversion impossible : Veuiller remplir un seul champs",Toast.LENGTH_SHORT);
                    afficher.show();
                }




            }
        });









    }


    @Override
    public void onClick(View view) {

    }
}