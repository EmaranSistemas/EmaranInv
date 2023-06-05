package com.yrsn.emaraninventory.mercapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class editar extends AppCompatActivity {

    EditText edId, edtienda, edproducto, edinventario;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edId = findViewById(R.id.id);
        edtienda = findViewById(R.id.tienda);
        edproducto = findViewById(R.id.producto);
        edinventario = findViewById(R.id.inventario);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        /*
        edId.setText(MainActivity.employeeArrayList.get(position).getId());
        edtienda.setText(MainActivity.employeeArrayList.get(position).gettienda());
        edproducto.setText(MainActivity.employeeArrayList.get(position).getproducto());
        edinventario.setText(MainActivity.employeeArrayList.get(position).getinventario());
*/
    }

    public void actualizar(View view) {
        final String id = edId.getText().toString();
        final String tienda = edtienda.getText().toString();
        final String producto = edinventario.getText().toString();
        final String inventario = edproducto.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Actualizando....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://emaransac.com/android/actualizar.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(editar.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("tienda",tienda);
                params.put("producto",producto);
                params.put("inventario",inventario);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(editar.this);
        requestQueue.add(request);
    }
}