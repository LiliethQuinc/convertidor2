package com.example.actividaduno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ajustes extends AppCompatActivity {

    Integer posicion;

    Spinner spinnerid;
    Spinner spinnerpo;
    Spinner spinnerco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        final Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);


        spinnerid=findViewById(R.id.sidioma);
        spinnerco=findViewById(R.id.scolores);
        spinnerpo=findViewById(R.id.sposicion);

        final List<String> li= new ArrayList<>();
        li.add("Seleccionar");
        li.add("Español");
        li.add("Ingles");
        li.add("Frances");
        li.add("Aleman");

        ArrayAdapter<String> sli =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,li);
        spinnerid.setAdapter (sli);
        spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),li.get (i).toString (),Toast.LENGTH_SHORT).show();
                //posicion=i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //

        final List<String> po= new ArrayList<>();
        po.add("Seleccionar decimales");
        po.add("1");
        po.add("2");
        po.add("3");

        ArrayAdapter<String> spo =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,po);
        spinnerpo.setAdapter (spo);
        spinnerpo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),po.get (i).toString (),Toast.LENGTH_SHORT).show();
                posicion=i;

                if(posicion==1){
                    decimales.setStringPref(getApplicationContext(),decimales.NUMERODECIMAL,decimales.prefKey.DECIMAL,Integer.toString(posicion));
                }
                if(posicion==2){
                    decimales.setStringPref(getApplicationContext(),decimales.NUMERODECIMAL,decimales.prefKey.DECIMAL,Integer.toString(posicion));
                }
                if(posicion==3){
                    decimales.setStringPref(getApplicationContext(),decimales.NUMERODECIMAL,decimales.prefKey.DECIMAL,Integer.toString(posicion));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //  public void colores(){
        final List<String> co= new ArrayList<>();
        co.add("Seleccionar");
        co.add("Azul");
        co.add("Amarillo");
        co.add("Morado");

        ArrayAdapter<String> sco =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,co);
        spinnerco.setAdapter (sco);
        spinnerco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),co.get (i).toString (),Toast.LENGTH_SHORT).show();
                posicion=i;

                if(posicion==1){
                    toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#013ADF")));
                }
                if(posicion==2){
                    toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFF00")));
                }
                if(posicion==3){
                    toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#AC58FA")));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        // }
    }






}
