package fr.example.calculmental;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.view.KeyEvent;
        import android.view.View;
        import android.view.Window;
        import android.view.inputmethod.EditorInfo;
        import android.view.inputmethod.InputMethodManager;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;


public class DebutantActivity extends AppCompatActivity implements View.OnClickListener {

    private Button case1;
    private Button case2;
    private Button case3;
    private Button case4;

    private TextView operande1;
    private TextView operande2;
    private TextView signe;
    private TextView nbpoint;

    private int randcase1;
    private int randcase2;
    private int randcase3;
    private int randcase4;
    private int randsigne;
    private int randoperande1;
    private int randoperande2;
    private int randplacement;

    private int reponse;
    private int correction;
    private int clicks = 0;

    private TextView timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debutant);
       

        this.case1 = (Button) findViewById(R.id.case1);
        this.case2 = (Button) findViewById(R.id.case2);
        this.case3 = (Button) findViewById(R.id.case3);
        this.case4 = (Button) findViewById(R.id.case4);
        this.operande1 = (TextView) findViewById(R.id.operande1);
        this.operande2 = (TextView) findViewById(R.id.operande2);
        this.signe = (TextView) findViewById(R.id.signe);
        this.nbpoint = (TextView) findViewById(R.id.nbpoint);
        this.timer= (TextView) findViewById(R.id.time);



        // Création de la première opération
        randoperande1 = 1 + (int) (Math.random() * 9);
        randoperande2 = 1 + (int) (Math.random() * 9);
        randsigne = 0 + (int) (Math.random() * 2);

        randcase1 = (int)(randoperande1 + randoperande2);
        randcase2 = (int)(randoperande1*randoperande2);
        randcase3 = (int) (randcase1) +(int) (Math.random() * 9) ;
        randcase4 =  1+ (int) (Math.random() * randcase1);

        // randplacement est utilisée pour le positionnement aléatoire des réponses
        randplacement = 1 + (int) (Math.random() * 4);




        operande1.setText(Integer.toString(randoperande1));
        operande2.setText(Integer.toString(randoperande2));

        //On positionne aléatoire les différente proposition de réponse.
        switch (randplacement) {
            case 1 :

                case1.setText(Integer.toString(randcase1));
                case2.setText(Integer.toString(randcase2));
                case3.setText(Integer.toString(randcase3));
                case4.setText(Integer.toString(randcase4));

                break;

            case 2:

                case1.setText(Integer.toString(randcase4));
                case2.setText(Integer.toString(randcase3));
                case3.setText(Integer.toString(randcase2));
                case4.setText(Integer.toString(randcase1));

                break;

            case 3:
                case1.setText(Integer.toString(randcase2));
                case2.setText(Integer.toString(randcase1));
                case3.setText(Integer.toString(randcase3));
                case4.setText(Integer.toString(randcase4));
                break;

            case 4:
                case1.setText(Integer.toString(randcase4));
                case2.setText(Integer.toString(randcase1));
                case3.setText(Integer.toString(randcase3));
                case4.setText(Integer.toString(randcase2));
                break;
        }



        if (randsigne == 0) {
            signe.setText("+");
        } else if (randsigne == 1) {
            signe.setText("*");
        }



        case1.setOnClickListener(this);
        case2.setOnClickListener(this);
        case3.setOnClickListener(this);
        case4.setOnClickListener(this);



        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Time : " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                operande1.setVisibility(View.INVISIBLE);
                signe.setVisibility(View.INVISIBLE);
                operande2.setVisibility(View.INVISIBLE);
                case1.setVisibility(View.INVISIBLE);
                case2.setVisibility(View.INVISIBLE);
                case3.setVisibility(View.INVISIBLE);
                case4.setVisibility(View.INVISIBLE);

                timer.setText("VOTRE SCORE EST "+clicks);
            }
        }.start();


    }


    @Override
    public void onClick (View v){

        switch (v.getId()) {
            case R.id.case1:
                reponse = Integer.parseInt(case1.getText().toString());
                break;

            case R.id.case2:
                reponse = Integer.parseInt(case2.getText().toString());
                break;

            case R.id.case3:
                reponse = Integer.parseInt(case3.getText().toString());
                break;

            case R.id.case4:
                reponse = Integer.parseInt(case4.getText().toString());
                break;
        }


        // randsigne est utilisé pour définir si l'opération se une addition ou une soustraction
        if (randsigne == 0) {
            correction = (int) (randoperande1 + randoperande2);
        } else if (randsigne == 1) {
            correction = (int) (randoperande1 * randoperande2);
        }


        if (correction == reponse) {
            clicks++;
            nbpoint.setText("Point : "+clicks);
        }



        // Création de la nouvelle opération
        randoperande1 = 1 + (int) (Math.random() * 9);
        randoperande2 = 1 + (int) (Math.random() * 9);

        randcase1 = (int) (randoperande1 + randoperande2);
        randcase2 =(int) (randoperande1 * randoperande2);
        randcase3 = 1 + (int) (Math.random() * 9);
        randcase4 = 1 + (int) (Math.random() * 9);
        randplacement = 1 + (int) (Math.random() * 4);



        randsigne = 0 + (int) (Math.random() * 2);  //[0-1]

        if (randsigne == 0) {
            signe.setText("+");
        } else if (randsigne == 1) {
            signe.setText("*");
        }


        switch (randplacement) {
            case 1 :

                case1.setText(Integer.toString(randcase1));
                case2.setText(Integer.toString(randcase2));
                case3.setText(Integer.toString(randcase3));
                case4.setText(Integer.toString(randcase4));

                break;

            case 2:

                case1.setText(Integer.toString(randcase4));
                case2.setText(Integer.toString(randcase3));
                case3.setText(Integer.toString(randcase2));
                case4.setText(Integer.toString(randcase1));

                break;

            case 3:
                case1.setText(Integer.toString(randcase2));
                case2.setText(Integer.toString(randcase1));
                case3.setText(Integer.toString(randcase3));
                case4.setText(Integer.toString(randcase4));
                break;

            case 4:
                case1.setText(Integer.toString(randcase4));
                case2.setText(Integer.toString(randcase1));
                case3.setText(Integer.toString(randcase3));
                case4.setText(Integer.toString(randcase2));
                break;
        }

        operande1.setText(Integer.toString(randoperande1));
        operande2.setText(Integer.toString(randoperande2));







    }



}