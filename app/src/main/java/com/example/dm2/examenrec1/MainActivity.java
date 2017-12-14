package com.example.dm2.examenrec1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_act1, btn_act2, btn_act3,btn_act4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_act1 = (Button) findViewById(R.id.btn_actividad1);
        btn_act2 = (Button) findViewById(R.id.btn_actividad2);
        btn_act3 = (Button) findViewById(R.id.btn_actividad3);
        btn_act4 = (Button) findViewById(R.id.btn_actividad4);

        btn_act1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Actividad1.class);
                startActivity(intent);
            }
        });

        btn_act2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intent);
            }
        });

        btn_act3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),getString(R.string.actividadNoImplementada)
                        ,Toast.LENGTH_SHORT).show();
            }
        });

        btn_act4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
