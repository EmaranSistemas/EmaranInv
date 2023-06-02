package com.yrsn.emaraninventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class sc_franco extends AppCompatActivity {
    private ListView listView;
    private List<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_franco);

        listView = findViewById(R.id.listView_sc_franco);
        names = new ArrayList<String>();

        names.add("EMMEL");
        names.add("LAMBRAMANI");
        names.add("KOSTO TRISTAN");
        names.add("KOSTO MAYORISTA");


        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("FRANCO");
            Toast.makeText(sc_franco.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(sc_franco.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               if(names.get(position).equals("EMMEL")){
                   Intent intent = new Intent(sc_franco.this,precio_emmel.class);
                   intent.putExtra("PRECIOEMMEL",names.get(position));
                   startActivity(intent);
               }
               else if (names.get(position).equals("LAMBRAMANI")) {
                   Intent intent = new Intent(sc_franco.this,precio_lambramani.class);
                   intent.putExtra("PRECIOLAMBRAMANI",names.get(position));
                   startActivity(intent);

               }
               else if (names.get(position).equals("KOSTO TRISTAN")) {
                   Intent intent = new Intent(sc_franco.this, precio_tristan.class);
                   intent.putExtra("PRECIOTRISTAN",names.get(position));
                   startActivity(intent);

               }
               else if (names.get(position).equals("KOSTO MAYORISTA")) {
                   Intent intent = new Intent(sc_franco.this,precio_mayorista.class);
                   intent.putExtra("PRECIOMAYORISTA",names.get(position));
                   startActivity(intent);

               }

           }
       });


    }
}