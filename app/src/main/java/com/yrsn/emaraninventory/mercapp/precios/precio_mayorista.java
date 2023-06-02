package com.yrsn.emaraninventory.mercapp.precios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yrsn.emaraninventory.mercapp.MyAdapter;
import com.yrsn.emaraninventory.R;

import java.util.ArrayList;
import java.util.List;

public class precio_mayorista extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precio_mayorista);

        listView = findViewById(R.id.precio_mayorista);
        names = new ArrayList<String>();

        names.add("SAZ. COMPLETO  GIGANTE X 42 SBS");
        names.add("PALILLO MOLIDO  GIGANTE X 42 SBS");
        names.add("COMINO MOLIDO GIGANTE X 42 SBS");
        names.add("PIMIENTA NEGRA MOLIDA GIGANTE X 42 SBS");
        names.add("TUCO SAZON SALSA GIGANTE X 42 SBS");
        names.add("AJO MOLIDO GIGANTE X 42 SBS");
        names.add("CANELA MOLIDA GIGANTE X 42 SBS");
        names.add("EL VERDE GIGANTE X 42 SBS");
        names.add("KION MOLIDO GIGANTE X 42 SBS");
        names.add("OREGANO SELECTO X 42 SBS");
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
        names.add("SAZONADOR COMPLETO SIN PICANTE X 250 GR");
        names.add("COMINO MOLIDO X 250 GRS");
        names.add("PIMIENTA MOLIDA  X 250 GR");
        names.add("PALILLO MOLIDO X 250 GR");
        names.add("AJO MOLIDO X 250 GR");
        names.add("OREGANO MOLIDO X 250 GR");
        names.add("SAZONADOR COMPLETO  X 500 GR");
        names.add("COMINO MOLIDO X 500 GR");
        names.add("PIMIENTA MOLIDA X 500 GR");
        names.add("PALILLO MOLIDO X 500 GR");
        names.add("AJO MOLIDO X 500 GR");
        names.add("OREGANO MOLIDO X 500 GR");
        names.add("SAL PARRILLERA BATAN PARA RES FRASCO X 225 GR.");
        names.add("SAL PARRILLERA BATAN PARA POLLO FRASCO X 215 GR.");
        names.add("SAL PARRILLERA BATAN PARA CERDO FRASCO X 220 GR.");



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("PRECIOMAYORISTA");
            Toast.makeText(precio_mayorista.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(precio_mayorista.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(precio_mayorista.this,names.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}