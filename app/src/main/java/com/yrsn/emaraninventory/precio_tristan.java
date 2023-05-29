package com.yrsn.emaraninventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class precio_tristan extends AppCompatActivity {
    private ListView listView;
    private List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precio_tristan);


        listView = findViewById(R.id.precio_tristan);
        names = new ArrayList<String>();

        names.add("CANELA MOLIDA FRASCO X 50 GRS");
        names.add("COMINO MOLIDO FRASCO X 50 GRS");
        names.add("PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS");
        names.add("TUCO SAZON SALSA FRASCO X 70 GRS");
        names.add("SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS");
        names.add("AJI COL.PANCA PICANTE FRASCO X 70 GRS");
        names.add("KION MOLIDO FRASCO X 50 GRS");
        names.add("SAL DE AJOS MOLIDO FRASCO X 50 GRS");
        names.add("PALILLO BATAN FRASCO X 70 GRS");
        names.add("OREGANO MOLIDO FRASCO X 25 GRS");
        names.add("AJI PAPRIKA PIMENTON FRASCO X 50 GRS");
        names.add("SAZ. EL VERDE FRASCO X 50 GRS");
        names.add("CURRY MOLIDO BATAN FRASCO X 50 GRS");
        names.add("PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS");
        names.add("SAZONADOR COMPL. GIGANTE X 2 SBS");
        names.add("COMINO BATAN GIGANTE X 2 SBS");
        names.add("PIMIENTA BATAN GIGANTE X 2 SBS");
        names.add("PALILLO MOLIDO BATAN GIG. X 2 SBS");
        names.add("TUCO SAZON SALSA GIGANTE X 2 SBS");
        names.add("AJO MOLIDO BATAN GIGANTE X 2 SBS");
        names.add("CANELA MOLIDA BATAN X 2 SBS");
        names.add("EL VERDE BATAN GIGANTE X 2");
        names.add("OREGANO MOLIDO X 2 SBS");
        names.add("KION MOLIDO X 2 SBS");
        names.add("AJI PANCA FRESCO BATAN  X 3 SBS");
        names.add("AJI AMARILLO FRESCO BATAN  X 3 SBS");
        names.add("AJO FRESCO BATAN  X 3 SBS");
        names.add("CULANTRO FRESCO BATAN  X 3 SBS");
        names.add("COMINO  X 250 GRS");
        names.add("AJO  X 250 GRS");
        names.add("PMIENTA X 250 GRS");
        names.add("OREGANO X  250 GRS");
        names.add("SAZONADOR X 250 GRS");
        names.add("SAL PARRILLERA RES FRASCO X 225 GRS");
        names.add("SAL PARRILLERA POLLO  FRASCO X 215 GRS");
        names.add("SAL PARRILLERA CERDO FRASCO X 220 GRS");
        names.add("CANELA MOLIDA BATAN X 8 SBS");



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("PRECIOTRISTAN");
            Toast.makeText(precio_tristan.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(precio_tristan.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(precio_tristan.this,names.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}