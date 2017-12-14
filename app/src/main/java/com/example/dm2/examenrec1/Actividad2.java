package com.example.dm2.examenrec1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Actividad2 extends AppCompatActivity {

    private ListView lstListado;
    private ArrayList<Localidad> localidades;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        //Instanciamos la s localidades
        localidades= new ArrayList<Localidad>();
        Localidad l1 = new Localidad(1,"Añana",157,21.92f,ContextCompat.getDrawable(this, R.drawable.aniana_salinas_2),
                "http://www.cuadrilladeanana.es/anana/");

        Localidad l2 = new Localidad(2, "Mundaka", 1892, 4.01f,  ContextCompat.getDrawable(this, R.drawable.mundaka),
                "http://www.mundaka.org");

        Localidad l3 = new Localidad(3, "Gernika-Lumo", 16763, 8.60f,  ContextCompat.getDrawable(this, R.drawable.gernika2),
                "http://www.gernika-lumo.net");

        Localidad l4 = new Localidad(4, "Laguardia", 1520, 81.08f,  ContextCompat.getDrawable(this, R.drawable.laguardia),
                "http://www.laguardia-alava.net/");

        Localidad l5 = new Localidad(5, "Vitoria-Gasteiz", 243918, 276.08f,
                ContextCompat.getDrawable(this, R.drawable.vitoria_gasteiz),"http://www.vitoria-gasteiz.org/");

        localidades.add(l1);
        localidades.add(l2);
        localidades.add(l3);
        localidades.add(l4);
        localidades.add(l5);

        lstListado = (ListView) findViewById(R.id.lst_listado);
        AdaptadorLocalidades adaptador= new AdaptadorLocalidades(this, localidades);
        lstListado.setAdapter(adaptador);

        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Localidad l = (Localidad) lstListado.getAdapter().getItem(pos);
                String web = l.getWeb();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                startActivity(i);
            }
        });

    }


    class AdaptadorLocalidades extends ArrayAdapter<Localidad>{

        private ArrayList<Localidad> localidades;

        public AdaptadorLocalidades(Context context, @NonNull ArrayList<Localidad> loc) {
            super(context, R.layout.listitem_localidad,loc);
            localidades= (ArrayList<Localidad>) loc;
        }



        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_localidad,null);

            TextView txt_idLocalidad = (TextView) item.findViewById(R.id.txt_idLocalidad);
            TextView txt_poblacion = (TextView) item.findViewById(R.id.txt_poblacion);
            TextView txt_superficie = (TextView) item.findViewById(R.id.txt_superficie);
            TextView txt_web = (TextView) item.findViewById(R.id.txt_web);
            ImageView img = (ImageView) item.findViewById(R.id.img);

            // Log.e("EUUU",localidades.get(position).getIdLocalidad()); //FALLLAA

            txt_idLocalidad.setText(localidades.get(position).getIdLocalidad());
            txt_poblacion.setText(localidades.get(position).getHabitantes());
            txt_superficie.setText(localidades.get(position).getSuperficie());
            txt_web.setText(localidades.get(position).getWeb());
            img.setImageDrawable(localidades.get(position).getFoto());

            return item;
        }
    }
}
