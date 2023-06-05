package com.yrsn.emaraninventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yrsn.emaraninventory.mercapp.Adapter;
import com.yrsn.emaraninventory.mercapp.AdapterProd;
import com.yrsn.emaraninventory.mercapp.Usuarios;
import com.yrsn.emaraninventory.mercapp.agregar;
import com.yrsn.emaraninventory.mercapp.detalles;
import com.yrsn.emaraninventory.mercapp.editar;
import com.yrsn.emaraninventory.mercapp.productos;
import com.yrsn.emaraninventory.mercapp.tiendas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ListView listView2;
    Adapter adapter;
    AdapterProd adapterProd;

    public static ArrayList<tiendas> tiendasArrayList = new ArrayList<>();
    public static ArrayList<productos> productArrayList = new ArrayList<>();
    String url = "https://emaransac.com/android/mostrar_tiendas.php";
    String url2 = "https://emaransac.com/android/productos_emmel.php";
    tiendas I_tiendas;
    productos I_productos;
    Usuarios usuarios;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.myListView);
        adapter = new Adapter(this,tiendasArrayList);
        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                //Toast.makeText(MainActivity.this,tiendasArrayList.get(position).getnombre(), Toast.LENGTH_SHORT).show();

                if(tiendasArrayList.get(position).getnombre().equals("FRANCO SUPERMERCADOS")){

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    //ProgressDialog progressDialog = new ProgressDialog(view.getContext());
                    CharSequence[] dialogItem = {"EMMEL","LAMBRAMANI","KOSTO TRISTAN","KOSTO MAYORISTA"};
                    builder.setTitle(tiendasArrayList.get(position).getnombre());
                    builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            retrieveProduct(url2);
                            switch (i){
                                case 0:
                                    //listView = findViewById(R.id.myListView);
                                    adapterProd = new AdapterProd(MainActivity.this, productArrayList);
                                    listView.setAdapter(adapterProd);
                                    break;
                                case 1:
                                    Toast.makeText(MainActivity.this,"segunda", Toast.LENGTH_SHORT).show();
                                    break;
                                case 2:
                                    Toast.makeText(MainActivity.this,"tercera", Toast.LENGTH_SHORT).show();
                                    break;
                                case 3:
                                    Toast.makeText(MainActivity.this,"cuarta", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
                    builder.create().show();
                }


            }
        });
        retrieveData();

    }



    public void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        tiendasArrayList.clear();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("datos");
                            if(exito.equals("1")){
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String id = object.getString("id");
                                    String nombre = object.getString("nombre");

                                    I_tiendas = new tiendas(id,nombre);
                                    tiendasArrayList.add(I_tiendas);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    public void retrieveProduct(String url){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                tiendasArrayList.clear();
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String exito = jsonObject.getString("exito");
                    JSONArray jsonArray = jsonObject.getJSONArray("datos");
                    if(exito.equals("1")){
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String nombre = object.getString("nombre");
                            I_productos= new productos(id, nombre);
                            productArrayList.add(I_productos);
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    public void agregar(View view) {
        startActivity(new Intent(getApplicationContext(), agregar.class));
        Intent intent=new Intent(MainActivity.this,agregar.class);
        startActivity(intent);
    }

    public void main(View view) {
        startActivity(new Intent(getApplicationContext(), agregar.class));
        Intent intent=new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
    }
}