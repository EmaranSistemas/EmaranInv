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

public class sp_peruanos extends AppCompatActivity {

    private ListView listView;
    private List<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_peruanos);


        listView = findViewById(R.id.listView_s_peruanos);
        names = new ArrayList<String>();

        names.add("PLAZA VEA EJERCITO");
        names.add("PLAZA VEA MARINA ");

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            String hello = bundle.getString("SPERUANOS");
            Toast.makeText(sp_peruanos.this,hello,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(sp_peruanos.this,"It is empty",Toast.LENGTH_LONG).show();
        }




        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(sp_peruanos.this, precio_plazavea.class);
                intent.putExtra("PRECIOPLAZA",names.get(position));
                startActivity(intent);
                Toast.makeText(sp_peruanos.this,names.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}