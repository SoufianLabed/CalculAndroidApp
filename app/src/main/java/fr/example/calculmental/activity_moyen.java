package fr.example.calculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class activity_moyen extends AppCompatActivity  {



    private TextView nombre;
    private TextView nombre2;
    private TextView moins;
    private int point = 0;
    private int rand1;
    private int rand2;
    private int error = 0;



    private int rand3;
    private Button start;
    private EditText reponse;
    private TextView ope;
    private float bonne = 0;
    private TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficile);


        this.nombre = (TextView) findViewById(R.id.nombre);
        this.nombre2 = (TextView) findViewById(R.id.nombre2);
        this.reponse = (EditText) findViewById(R.id.reponse);
        this.ope = (TextView) findViewById(R.id.ope);
        this.start = (Button) findViewById(R.id.start);

        this.timer = (TextView) findViewById(R.id.timer);
        this.moins = (TextView) findViewById(R.id.moins);


        nombre.setVisibility(View.INVISIBLE);
        ope.setVisibility(View.INVISIBLE);
        nombre2.setVisibility(View.INVISIBLE);
        reponse.setVisibility(View.INVISIBLE);
        moins.setVisibility(View.INVISIBLE);






        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CountDownTimer(15000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText("seconds remaining: " + millisUntilFinished / 1000);

                    }

                    public void onFinish() {

                        nombre.setVisibility(View.INVISIBLE);
                        ope.setVisibility(View.INVISIBLE);
                        nombre2.setVisibility(View.INVISIBLE);
                        reponse.setVisibility(View.INVISIBLE);
                        timer.setText("VOTRE SCORE EST "+point);
                        start.setText("retry");
                        start.setVisibility(View.VISIBLE);



                    }
                }.start();


                nombre.setVisibility(View.VISIBLE);
                ope.setVisibility(View.VISIBLE);
                nombre2.setVisibility(View.VISIBLE);
                reponse.setVisibility(View.VISIBLE);
                start.setVisibility(View.INVISIBLE);


                // Création de la prmemière opération

                rand3 = 0 + (int) (Math.random() * 3);  //[0-1]
                rand1 = 1 + (int) (Math.random() * 9);
                rand2 = 1 + (int) (Math.random() * 9);
                nombre.setText(Integer.toString(rand1));
                nombre2.setText(Integer.toString(rand2));

                if(rand3 == 0) {
                    ope.setText("+");
                }
                if(rand3 == 1){
                    ope.setText("*");
                }
                else if(rand3 == 2){
                    ope.setText("-");
                    if((rand1-rand2)<0){
                        moins.setVisibility(View.VISIBLE);
                    }
                }


            }
        });




        reponse.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {



                if (actionId == EditorInfo.IME_ACTION_DONE) {


                    // Récuperation de la réponse puis vérification.
                    if (!reponse.getText().toString().isEmpty()) {

                        float reponse2 = Float.parseFloat(reponse.getText().toString());

                        if (rand3 == 0) {
                            bonne = (rand1 + rand2);
                        }
                        if (rand3 == 1) {
                            bonne = (rand1 * rand2);
                        } else if (rand3 == 2) {
                            bonne = (rand1 - rand2);
                            if (bonne < 0) {
                                moins.setVisibility(View.INVISIBLE);
                                reponse2 = -(Float.parseFloat(reponse.getText().toString()));
                            }

                        }


                        if (bonne == reponse2) {
                            point++;
                        } else {
                            error = error + 1;
                        }

                        moins.setVisibility(View.INVISIBLE);

                        // création de la nouvelle opération

                        rand3 = 0 + (int) (Math.random() * 3);  //[0-1]
                        rand1 = 1 + (int) (Math.random() * 9);
                        rand2 = 1 + (int) (Math.random() * 9);
                        nombre.setText(Integer.toString(rand1));
                        nombre2.setText(Integer.toString(rand2));

                        if (rand3 == 0) {
                            ope.setText("+");
                        }
                        if (rand3 == 1) {
                            ope.setText("*");
                        }
                        if (rand3 == 2) {
                            ope.setText("-");
                            if ((rand1 - rand2) < 0) {
                                moins.setVisibility(View.VISIBLE);
                            }
                        }

                        reponse.setText("");

                    }

                }


                return true;


            }



        });


    }


}

