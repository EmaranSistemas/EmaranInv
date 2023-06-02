package com.yrsn.emaraninventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Button btn;
    private ListView listView;
    private List<String> names;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = findViewById(R.id.listView);
        names = new ArrayList<String>();

        names.add("FRANCO SUPERMERCADOS");
        names.add("SUPERMERCADOS PERUANOS");
        names.add("HIPERMERCADOS TOTTUS");
        names.add("CENCOSUD RETAIL");
        names.add("REPRESENTACIONES INTERNACIONALES - EL SUPER");

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        //listView.setAdapter(adapter);

        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                if(names.get(position).equals("FRANCO SUPERMERCADOS")){
                    Intent intent = new Intent(MainActivity.this,sc_franco.class);
                    intent.putExtra("FRANCO",names.get(position));
                    startActivity(intent);
                }
                else if (names.get(position).equals("SUPERMERCADOS PERUANOS")) {
                    Intent intent = new Intent(MainActivity.this,sp_peruanos.class);
                    intent.putExtra("SPERUANOS",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("HIPERMERCADOS TOTTUS")) {
                    Intent intent = new Intent(MainActivity.this,s_tottus.class);
                    intent.putExtra("TOTTUS",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("CENCOSUD RETAIL")) {
                    Intent intent = new Intent(MainActivity.this,s_metro.class);
                    intent.putExtra("METRO",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("REPRESENTACIONES INTERNACIONALES - EL SUPER")) {
                    Intent intent = new Intent(MainActivity.this,s_super.class);
                    intent.putExtra("SUPER",names.get(position));
                    startActivity(intent);

                }else {
                    Toast.makeText(MainActivity.this,"No existe el mercado",Toast.LENGTH_LONG).show();
                }


            }
        });



    }
}

/*

        btn= findViewById(R.id.buttonMain);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Second_activity.class);
                startActivity(intent);
            }
 */