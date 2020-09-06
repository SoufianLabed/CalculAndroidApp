package fr.example.calculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class Classement_activity extends AppCompatActivity {

    private Button retour;
    private DatabaseManager databaseManager;

    private TextView Listescore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        this.retour = (Button) findViewById(R.id.retour);
        this.databaseManager = new DatabaseManager(this);
        this.Listescore = (TextView) findViewById(R.id.vuescore);
        retour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent otherAc = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherAc);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Rank> rank = databaseManager.extractRankTop5();
        for ( Rank score : rank ) {
            Listescore.append( "\n\n" +score.getPseudo()+"      "+score.getPoint()+"    "+score.getNiveau() );

        }
        databaseManager.close();
    }
}