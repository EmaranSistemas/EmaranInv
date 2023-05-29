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

public class s_tottus extends AppCompatActivity {
    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stottus);

        listView = findViewById(R.id.listView_s_tottus);
        names = new ArrayList<String>();

        names.add("TOTTUS EJERCITO");
        names.add("TOTTUS PORONGOCHE");
        names.add("TOTTUS PARRA");



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("TOTTUS");
            Toast.makeText(s_tottus.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(s_tottus.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(names.get(position).equals("TOTTUS EJERCITO")){
                    Intent intent = new Intent(s_tottus.this, precio_tottus.class);
                    intent.putExtra("PRECIOTOTTUS",names.get(position));
                    startActivity(intent);
                }
                else if (names.get(position).equals("TOTTUS PORONGOCHE")) {
                    Intent intent = new Intent(s_tottus.this,precio_tottus.class);
                    intent.putExtra("PRECIOTOTTUS",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("TOTTUS PARRA")) {
                    Intent intent = new Intent(s_tottus.this, precio_tottus.class);
                    intent.putExtra("PRECIOTOTTUS",names.get(position));
                    startActivity(intent);

                }

            }
        });
    }
}