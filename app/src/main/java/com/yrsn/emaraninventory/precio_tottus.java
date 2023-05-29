package com.yrsn.emaraninventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class precio_tottus extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precio_tottus);

        listView = findViewById(R.id.precio_tottus);
        names = new ArrayList<String>();


        names.add("CANELA MOLIDA FRASCO X 50 GRS");
        names.add("PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS");
        names.add("TUCO SAZON SALSA FRASCO X 70 GRS");
        names.add("AJI COL.PANCA PICANTE FRASCO X 70 GRS");
        names.add("KION MOLIDO FRASCO X 50 GRS");
        names.add("CURRY MOLIDO BATAN FRASCO X 50 GRS");
        names.add("PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS");
        names.add("SAZ. COMPLETO BATAN GIGANTE X 24 GRS");
        names.add("PALILLO MOLIDO BATAN GIGANTE X 22 GRS");
        names.add("TUCO SAZON SALSA BATAN GIGANTE X 20 GRS");
        names.add("SAL DE AJOS MOLIDO BATAN GIGANTE X 16 GRS");



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("PRECIOTOTTUS");
            Toast.makeText(precio_tottus.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(precio_tottus.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(precio_tottus.this,names.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}