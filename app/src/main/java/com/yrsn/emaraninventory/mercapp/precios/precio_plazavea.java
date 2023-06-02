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

public class precio_plazavea extends AppCompatActivity {
    private ListView listView;
    private List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precio_plazavea);


        listView = findViewById(R.id.precio_plazavea);
        names = new ArrayList<String>();


        names.add("CANELA MOLIDA FRASCO X 50 GRS");
        names.add("SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS");
        names.add("SAZ. COMPLETO BATAN GIGANTE X 24 GRS");
        names.add("COMINO MOLIDO BATAN GIGANTE X 13 GRS");
        names.add("PIMIENTA NEGRA MOLIDA BATAN GIGANTE X 12 GRS");
        names.add("TUCO SAZON SALSA BATAN GIGANTE X 20 GRS");



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("PRECIOPLAZA");
            Toast.makeText(precio_plazavea.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(precio_plazavea.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(precio_plazavea.this,names.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}