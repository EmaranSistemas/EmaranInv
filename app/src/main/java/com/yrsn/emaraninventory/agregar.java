package com.yrsn.emaraninventory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class agregar extends AppCompatActivity {

    private EditText t_tienda,t_producto,t_inventario;
    private Button b_insertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        t_tienda = findViewById(R.id.tienda);
        t_producto = findViewById(R.id.producto);
        t_inventario = findViewById(R.id.inventario);

        b_insertar = findViewById(R.id.b_button);
        b_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar_datos();
            }
        });

    }

    private void insertar_datos(){
        final String tienda = t_tienda.getText().toString().trim();
        final String producto = t_producto.getText().toString().trim();
        final String inventario = t_inventario.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando");

        if(tienda.isEmpty()){
            Toast.makeText(this,"Ingrese tienda",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(producto.isEmpty()){
            Toast.makeText(this,"Ingrese producto",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(inventario.isEmpty()){
            Toast.makeText(this,"Ingrese inventario",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://emaransac.com/android/init.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Se guardo correctamente.")) {
                        Toast.makeText(agregar.this, "Se guardo correctamente.", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        Toast.makeText(agregar.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }){
                @Nullable
                @Override
                protected Map<String,String> getParams() throws AuthFailureError{

                    Map<String,String> params = new HashMap<>();

                    params.put("tienda",tienda);
                    params.put("producto",producto);
                    params.put("inventario",inventario);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(agregar.this);
            requestQueue.add(request);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}