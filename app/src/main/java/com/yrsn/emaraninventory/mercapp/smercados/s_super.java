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
import com.yrsn.emaraninventory.mercapp.precios.precio_super;

import java.util.ArrayList;
import java.util.List;

public class s_super extends AppCompatActivity {
    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssuper);


        listView = findViewById(R.id.listView_s_super);
        names = new ArrayList<String>();

        names.add("SUPER PIEROLA");
        names.add("SUPER PORTAL");


        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("SUPER");
            Toast.makeText(s_super.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(s_super.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(names.get(position).equals("SUPER PIEROLA")){
                    Intent intent = new Intent(s_super.this, precio_super.class);
                    intent.putExtra("PRECIOEMMEL",names.get(position));
                    startActivity(intent);
                }
                else if (names.get(position).equals("SUPER PORTAL")) {
                    Intent intent = new Intent(s_super.this,precio_super.class);
                    intent.putExtra("PRECIOLAMBRAMANI",names.get(position));
                    startActivity(intent);

                }

            }
        });
    }
}