package com.example.actividaduno;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
//import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


//import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText origen;
    EditText destino;

    Spinner con;

    RadioButton temp;
    RadioButton vol;
    RadioButton longi;

    RadioButton area;
    RadioButton acel;
    RadioButton peso;

    Button convertir;
    Button limpiar;

    Integer posicion;
    String validarorigen, validardestino;

    Boolean btemp;
    Boolean blong;
    Boolean bvol;
    Boolean bacel;
    Boolean bpeso;
    Boolean barea;

    Double r;
    String var;
    Double cf;

    Float ym;
    Float my;

    Float lg;
    Float gl;

    Float mk;
    Float km;

    Float kl;
    Float lk;
    Float og;
    Float go;

    Float mh;
    Float hm;

    Double forigen;
    //Float fdestino;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);


    //protected void onCreate(Bundle savedInstanceState) {


        origen = findViewById(R.id.origen);
        destino = findViewById(R.id.destino);
        temp = findViewById(R.id.temperatura);
        vol = findViewById(R.id.volumen);
        longi = findViewById(R.id.longitud);
        area = findViewById(R.id.area);
        acel = findViewById(R.id.aceleracion);
        peso = findViewById(R.id.peso);
        con = findViewById(R.id.convertidor);
        convertir = findViewById(R.id.convertir);
        limpiar = findViewById(R.id.limpiar);


        temp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spinnertemp();
            }
        });

        longi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spinnermy();
            }
        });

        vol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spinnervol();
            }
        });

        acel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spinnerace();
            }
        });

        peso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spinnerpeso();
            }
        });

        area.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spinnerarea();
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String limpiar = (" ");
                origen.setText(limpiar);
                destino.setText(limpiar);
            }
        });

        convertir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(validacion()){
                    convertidor();
                }else{
                    Toast.makeText(MainActivity.this,"Campo vacio",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.main, menu);
        return super.onCreateOptionsMenu (menu);
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.item1:
                Intent iajuste = new Intent (getBaseContext (), ajustes.class);
                startActivity (iajuste);
                break;
            case R.id.item2:
                Intent iacerca = new Intent (getBaseContext (), acercade.class);
                startActivity (iacerca);
                break;
        }

        return super.onOptionsItemSelected (item);
    }


    public void convertidor(){
        forigen=Double.parseDouble(validarorigen);

        //temperatura
        if(btemp==true){
            if(posicion==1){
                r=(forigen * 1.80)+32;
                //destino.setText(validardestino);
            }else if(posicion==2){
                r= (forigen - 32)/1.80;
                //validardestino=Double.toString(fc);
            }

        }
        //longitud
        if(blong==true){
            if(posicion==1){
                r=forigen/0.9144;
            }else if(posicion==2){
                r=forigen*0.9144;
            }
        }
        //volumen
        if(bvol==true){
            if(posicion==1){
                r= forigen*0.264172;
            }else if(posicion==2){
                r=forigen*3.785411;
            }
        }
        //aceleracion
        if(bacel==true){
            if(posicion==1){
                r= forigen*0.62137;
            }else if(posicion==2){
                r= forigen*1.609;
            }
        }
        //peso
        if(bpeso==true){
            if(posicion==1){
                r=forigen*2.2046;
            }else if(posicion==2){
                r=forigen/2.20463;
            }else if(posicion==3){
                r=forigen/28.34953;
            }else if(posicion==4){
                r=forigen*28.2396;
            }
        }
        //area
        if(barea==true){
            if(posicion==1){
                r=forigen/10000;
            }else if(posicion==2){
                r=forigen*10000;
            }
        }

        if(decimales.getStringPref(getApplicationContext(), decimales.NUMERODECIMAL, decimales.prefKey.DECIMAL).equals("1")){
            int uno=1;
            //validardestino=Double.toString(obtieneDecimales(uno,r));
            var=obtieneDecimales(uno,r);
            validardestino=(var);
            destino.setText(validardestino);
        }

        if(decimales.getStringPref(getApplicationContext(), decimales.NUMERODECIMAL, decimales.prefKey.DECIMAL).equals("2")){
            int dos=2;
            //validardestino=Double.toString(obtieneDecimales(dos,r));
            var=obtieneDecimales(dos,r);
            validardestino=(var);
            destino.setText(validardestino);
        }
        if(decimales.getStringPref(getApplicationContext(), decimales.NUMERODECIMAL, decimales.prefKey.DECIMAL).equals("3")){
            int tres=3;
            var=obtieneDecimales(tres,r);
            validardestino=(var);
           // validardestino=Double.toString(obtieneDecimales(tres,r));
            destino.setText(validardestino);
        }
    }

    private String obtieneDecimales(int dec,double valor){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(dec);
        //return format.format(valor);
        return format.format(valor);

    }

            public void spinnertemp(){
//                Log.d("tag","funciona");
                btemp=true;

                bacel=false;
                barea=false;
                blong=false;
                bpeso=false;
                bvol=false;
                final List<String> cfa =new ArrayList<>();
                cfa.add("Seleccionar...");
                cfa.add("Centigrados > Farentheit");
                cfa.add("Farentheit > Centigrados");

                ArrayAdapter<String> sp1 =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,cfa);
                con.setAdapter (sp1);
                con.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText (getBaseContext(),cfa.get (i).toString (),Toast.LENGTH_SHORT).show();
                        posicion=i;
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            }

    public void spinnermy(){

        btemp=false;
        bacel=false;
        barea=false;
        blong=true;
        bpeso=false;
        bvol=false;
        final List<String> my =new ArrayList<>();
        my.add("Seleccionar...");
        my.add("Metros > Yardas");
        my.add("Yardas > Metros");

        ArrayAdapter<String> sp1 =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,my);
        con.setAdapter (sp1);
        con.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),my.get (i).toString (),Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this,"L: "+i,Toast.LENGTH_LONG).show();
                posicion=i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void spinnervol(){
        btemp=false;
        bacel=false;
        barea=false;
        blong=false;
        bpeso=false;
        bvol=true;
        final  List<String> lg = new ArrayList<>();
        lg.add("Seleccionar...");
        lg.add("Litros > Galeones (US)");
        lg.add("Galeones (US) > Litros");

        ArrayAdapter<String> sp1 =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,lg);
        con.setAdapter (sp1);
        con.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),lg.get (i).toString (),Toast.LENGTH_SHORT).show();
                posicion=i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void spinnerace(){
        btemp=false;
        bacel=true;
        barea=false;
        blong=false;
        bpeso=false;
        bvol=false;
        final  List<String> kh = new ArrayList<>();
        kh.add("Seleccionar...");
        kh.add("KM/H > Millas/H");
        kh.add("Millas/H > KM/H");
        ArrayAdapter<String> sp1 =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,kh);
        con.setAdapter (sp1);
        con.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),kh.get (i).toString (),Toast.LENGTH_SHORT).show();
                posicion=i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void spinnerpeso(){
        btemp=false;
        bacel=false;
        barea=false;
        blong=false;
        bpeso=true;
        bvol=false;
        final   List<String> log = new ArrayList<>();
        log.add("Seleccionar...");
        log.add("Kilos > Libras");
        log.add("Libras > Kilos");
        log.add("Gramos > Onzas");
        log.add("Onzas > Grasmo");
        ArrayAdapter<String> sp1 =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,log);
        con.setAdapter (sp1);
        con.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),log.get (i).toString (),Toast.LENGTH_SHORT).show();
                posicion=i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void spinnerarea(){
        btemp=false;
        bacel=false;
        barea=true;
        blong=false;
        bpeso=false;
        bvol=false;
        final List<String> mc = new ArrayList<>();
        mc.add("Seleccionar...");
        mc.add("Metros cuadrados > Hectareas");
        mc.add("Hectareas > Metros cuadrados");
        ArrayAdapter<String> sp1 =new ArrayAdapter<> (this,android.R.layout.simple_spinner_dropdown_item,mc);
        con.setAdapter (sp1);
        con.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText (getBaseContext(),mc.get (i).toString (),Toast.LENGTH_SHORT).show();
                posicion=i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public boolean validacion(){
        validarorigen = origen.getText().toString();
        //validardestino = destino.getText().toString();
        return !(TextUtils.isEmpty(validarorigen));
    }
}
