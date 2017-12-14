package com.example.dm2.examenrec1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Actividad1 extends AppCompatActivity {

    private Spinner spinner;
    private TextView txt_num1, txt_num2, txt_candidatos;
    private EditText txt_nombre, txt_resultado;
    private Button evaluar,salir;
    private CheckBox chk_php, chk_java, chk_html, chk_css;
    private RadioGroup radios;


    private int num1, num2, resultado, intentos = 3, candidatos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        txt_candidatos = (TextView) findViewById(R.id.txt_candidatos);
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        chk_css = (CheckBox) findViewById(R.id.chk_css);
        chk_html = (CheckBox) findViewById(R.id.chk_html);
        chk_java = (CheckBox) findViewById(R.id.chk_java);
        chk_php = (CheckBox) findViewById(R.id.chk_php);
        radios = (RadioGroup) findViewById(R.id.radio_group);

        //cargar el spinner
        spinner = (Spinner) findViewById(R.id.spinner_provincias);
        final String[] PROVINCIAS = {"Alava", "Bizkaia", "Gipuzkoa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,PROVINCIAS);
        spinner.setAdapter(adapter);


        //evaluar y salir
        evaluar = (Button) findViewById(R.id.btn_evaluar);
        salir = (Button) findViewById(R.id.btn_salir);

        evaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_nombre.getText().toString().equals("") ) {
                    Toast.makeText(getApplicationContext(), "Faltan datos obligatorio", Toast.LENGTH_SHORT).show();
                    Log.i("Onclick","CAMPOS VACIOS");
                } else {
                    String conocimientos = "";
                    conocimientos += chk_css.isChecked() ? "css, " : "";
                    conocimientos += chk_java.isChecked() ? "java, " : "";
                    conocimientos += chk_php.isChecked() ? "php, " : "";
                    conocimientos += chk_html.isChecked() ? "html" : "";

                    String sexo = "";
                    int idRadioSelec = radios.getCheckedRadioButtonId();
                    if (idRadioSelec == R.id.radio_fem) {
                        sexo = "Femenino";
                    } else {
                        sexo = "Masculino";
                    }

                    Intent i = new Intent(Actividad1.this, Actividad1b.class);
                    i.putExtra("nombre", txt_nombre.getText().toString());
                    i.putExtra("provincia", spinner.getSelectedItem().toString());
                    i.putExtra("conocimientos", conocimientos);
                    i.putExtra("sexo", sexo);
                    startActivityForResult(i, 137);
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) {

        if (requestCode == 137 && resultCode == RESULT_OK) {
            txt_candidatos.setText("Candidatos: " + ++candidatos);
            if (candidatos >= 4) {
                salir.setVisibility(View.VISIBLE);
                salir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
            }
        }
    }
}
