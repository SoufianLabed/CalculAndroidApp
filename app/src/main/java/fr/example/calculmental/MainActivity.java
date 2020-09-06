package fr.example.calculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button debutant;
    private Button difficile;
    private Button moyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.debutant = (Button)findViewById(R.id.Debutant);
        this.difficile = (Button)findViewById(R.id.Difficile);
        this.moyen = (Button)findViewById(R.id.Moyen);

        debutant.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent debutantActivity = new Intent(getApplicationContext(),DebutantActivity.class);
                startActivity(debutantActivity);
                finish();
            }
        });


        moyen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent moyenActivity = new Intent(getApplicationContext(),activity_moyen.class);
                startActivity(moyenActivity);
                finish();
            }
        });

        difficile.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent difficiletActivity = new Intent(getApplicationContext(),DifficileActivity.class);
                startActivity(difficiletActivity);
                finish();
            }
        });




    }
}