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

public class precio_super extends AppCompatActivity {
    private ListView listView;
    private List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precio_super);

        listView = findViewById(R.id.precio_super);
        names = new ArrayList<String>();

        names.add("TOTTUS EJERCITO");
        names.add("TOTTUS PORONGOCHE");
        names.add("TOTTUS PARRA");



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("TOTTUS");
            Toast.makeText(precio_super.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(precio_super.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(precio_super.this,names.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}