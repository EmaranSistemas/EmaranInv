package com.yrsn.emaraninventory.mercapp.smercados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yrsn.emaraninventory.mercapp.MyAdapter;
import com.yrsn.emaraninventory.R;
import com.yrsn.emaraninventory.mercapp.precios.precio_lambramani;
import com.yrsn.emaraninventory.mercapp.precios.precio_mayorista;
import com.yrsn.emaraninventory.mercapp.precios.precio_super;
import com.yrsn.emaraninventory.mercapp.precios.precio_tristan;

import java.util.ArrayList;
import java.util.List;

public class s_metro extends AppCompatActivity {
    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smetro);

        listView = findViewById(R.id.listView_s_metro);
        names = new ArrayList<String>();

        names.add("METRO AVIACION");
        names.add("METRO EJERCITO");
        names.add("METRO LAMBRAMANI");
        names.add("METRO HUNTER");


        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("METRO");
            Toast.makeText(s_metro.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(s_metro.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(names.get(position).equals("METRO AVIACION")){
                    Intent intent = new Intent(s_metro.this, precio_super.class);
                    intent.putExtra("PRECIOEMMEL",names.get(position));
                    startActivity(intent);
                }
                else if (names.get(position).equals("METRO EJERCITO")) {
                    Intent intent = new Intent(s_metro.this, precio_lambramani.class);
                    intent.putExtra("PRECIOLAMBRAMANI",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("METRO LAMBRAMANI")) {
                    Intent intent = new Intent(s_metro.this, precio_tristan.class);
                    intent.putExtra("PRECIOTRISTAN",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("METRO HUNTER")) {
                    Intent intent = new Intent(s_metro.this, precio_mayorista.class);
                    intent.putExtra("PRECIOMAYORISTA",names.get(position));
                    startActivity(intent);

                }

            }
        });

    }
}