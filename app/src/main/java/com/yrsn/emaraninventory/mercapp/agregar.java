package com.yrsn.emaraninventory.mercapp;

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
import com.yrsn.emaraninventory.MainActivity;
import com.yrsn.emaraninventory.R;

import java.util.HashMap;
import java.util.Map;

public class agregar extends AppCompatActivity {

    EditText txtTienda, txtProducto, txtInventario,txtPedido;
    Button btn_insert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtTienda = findViewById(R.id.tienda);
        txtProducto = findViewById(R.id.producto);
        txtInventario = findViewById(R.id.inventario);
        txtPedido = findViewById(R.id.pedido);

        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String tienda = txtTienda.getText().toString().trim();
        final String producto = txtProducto.getText().toString().trim();
        final String inventario = txtInventario.getText().toString().trim();
        final String pedido = txtPedido.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(tienda.isEmpty()){
            Toast.makeText(this, "Tienda", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(producto.isEmpty()){
            Toast.makeText(this, "Producto", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(inventario.isEmpty()){
            Toast.makeText(this, "Ingrese inventario", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pedido.isEmpty()){
            Toast.makeText(this, "Ingrese 0 si no hay pedido", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://emaransac.com/android/insertar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("Se guardo correctamente.")){
                                Toast.makeText(agregar.this, "Se guardo correctamente.", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(agregar.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    /*
                    params.put("nombre",nombre);
                    params.put("correo",correo);
                    params.put("direccion",direccion);
                     */

                    params.put("tienda",tienda);
                    params.put("producto",producto);
                    params.put("inventario",inventario);
                    params.put("pedido",pedido);
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