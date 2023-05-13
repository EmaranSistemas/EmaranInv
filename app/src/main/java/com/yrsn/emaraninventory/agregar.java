package com.yrsn.emaraninventory;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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


    // ***********lista desplegable para la seleccino de item***********
    String[] items = {"S.FRANCO EMMEL","S.FRANCO LAMBRAMANI","S.FRANCO K.TRISTAN","S.FRANCO K.MAYORISTA",
                      "S.PERUANOS PLAZAVEA_EJERCITO","S.PERUANOS PLAZAVEA_LAMARINA",
            "H.T TOTTUS_EJERCITO","H.T TOTTUS_PARRA","H.T TOTTUS_PORONGOCHE",
            "C.RETAIL METRO_AVIACIÓN","C.RETAIL METRO_EJERCITO","C.RETAIL METRO_LAMBRAMANI","C.RETAIL METRO_HUNTER",
            "R.INTERNACIONALES SUPER_PIEROLA","R.INTERNACIONALES SUPER_PORTAL"};

    String[] productos = {
            "------------------------",
            "|-------SF-EMMEL-------|",
            "-----------------------",
            "CANELA MOLIDA FRASCO X 50 GRS",
            "COMINO MOLIDO FRASCO X 50 GRS",
            "PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "TUCO SAZON SALSA FRASCO X 70 GRS",
            "SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "KION MOLIDO FRASCO X 50 GRS",
            "SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "PALILLO BATAN FRASCO X 70 GRS",
            "OREGANO MOLIDO FRASCO X 25 GRS",
            "AJI AMARILLO FRASCO X 70 GRS",
            "AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "SAZ. EL VERDE FRASCO X 50 GRS",
            "CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "SAZONADOR COMPL. GIGANTE X 2 SBS                 ",
            "COMINO BATAN GIGANTE X 2 SBS",
            "PIMIENTA BATAN GIGANTE X 2 SBS",
            "PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "TUCO SAZON SALSA GIGANTE X 2 SBS",
            "AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "CANELA MOLIDA BATAN X 2 SBS",
            "EL VERDE BATAN GIGANTE X 2",
            "OREGANO MOLIDO X 2 SBS",
            "KION MOLIDO X 2 SBS",
            "AJI PANCA FRESCO BATAN  X 3 SBS",
            "AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "AJO FRESCO BATAN  X 3 SBS",
            "CULANTRO FRESCO BATAN  X 3 SBS",
            "COMINO  X 250 GRS",
            "AJO  X 250 GRS",
            "PMIENTA X 250 GRS ",
            "OREGANO X  250 GRS",
            "SAZONADOR X 250 GRS ",
            "PALILLO X 250 GRS ",
            "SAL PARRILLERA RES FRASCO X 225 GRS ",
            "SAL PARRILLERA POLLO  FRASCO X 215 GRS ",
            "SAL PARRILLERA CERDO FRASCO X 220 GRS ",
            "--------------------------",
            "|----SF-LAMBRAMANI--------|",
            "--------------------------",
            "SAZONADOR COMPL. GIGANTE X 2 SBS      ",
            "COMINO BATAN GIGANTE X 2 SBS",
            "PIMIENTA BATAN GIGANTE X 2 SBS",
            "PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "TUCO SAZON SALSA GIGANTE X 2 SBS",
            "AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "CANELA MOLIDA BATAN X 2 SBS",
            "EL VERDE BATAN GIGANTE X 2",
            "OREGANO MOLIDO X 2 SBS",
            "KION MOLIDO X 2 SBS",
            "AJO MOLIDO BATAN GIGANTE X 8 SBS",
            "CANELA MOLIDA BATAN X 8 SBS",
            "AJI PANCA FRESCO BATAN  X 3 SBS",
            "AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "AJO FRESCO BATAN  X 3 SBS",
            "CULANTRO FRESCO BATAN  X 3 SBS",
            "CANELA MOLIDA FRASCO X 50 GRS",
            "COMINO MOLIDO FRASCO X 50 GRS",
            "PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "TUCO SAZON SALSA FRASCO X 70 GRS",
            "SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "KION MOLIDO FRASCO X 50 GRS",
            "SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "PALILLO BATAN FRASCO X 70 GRS",
            "OREGANO MOLIDO FRASCO X 25 GRS",
            "AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "SAZ. EL VERDE FRASCO X 50 GRS",
            "CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "COMINO X 250 GRS ",
            "AJO  X 250 GRS",
            "PMIENTA X 250 GRS ",
            "OREGANO X  250 GRS",
            "SAZONADOR X 250 GRS ",
            "PALILLO X 250 GRS ",
            "SAL PARRILLERA RES FRASCO X 225 GRS ",
            "SAL PARRILLERA POLLO  FRASCO X 215 GRS ",
            "SAL PARRILLERA CERDO FRASCO X 220 GRS ",
            "----------------------------",
            "|------SF-K.TRISTAM---------|",
            "----------------------------",
            "SAZONADOR COMPL. GIGANTE X 2 SBS                 ",
            "COMINO BATAN GIGANTE X 2 SBS",
            "PIMIENTA BATAN GIGANTE X 2 SBS",
            "PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "TUCO SAZON SALSA GIGANTE X 2 SBS",
            "AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "CANELA MOLIDA BATAN X 2 SBS",
            "EL VERDE BATAN GIGANTE X 2",
            "OREGANO MOLIDO X 2 SBS",
            "KION MOLIDO X 2 SBS",
            "CANELA MOLIDA BATAN X 8 SBS",
            "AJI PANCA FRESCO BATAN  X 3 SBS",
            "AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "AJO FRESCO BATAN  X 3 SBS",
            "CULANTRO FRESCO BATAN  X 3 SBS",
            "CANELA MOLIDA FRASCO X 50 GRS",
            "COMINO MOLIDO FRASCO X 50 GRS",
            "PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "TUCO SAZON SALSA FRASCO X 70 GRS",
            "SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "KION MOLIDO FRASCO X 50 GRS",
            "SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "PALILLO BATAN FRASCO X 70 GRS",
            "OREGANO MOLIDO FRASCO X 25 GRS",
            "AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "SAZ. EL VERDE FRASCO X 50 GRS",
            "CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "COMINO X 250 GRS ",
            "AJO  X 250 GRS",
            "PMIENTA X 250 GRS ",
            "OREGANO X  250 GRS",
            "SAZONADOR X 250 GRS ",
            "SAL PARRILLERA RES FRASCO X 225 GRS ",
            "SAL PARRILLERA POLLO  FRASCO X 215 GRS ",
            "SAL PARRILLERA CERDO FRASCO X 220 GRS ",
            "----------------------------",
            "|------SF-K.MAYORISTA------|",
            "----------------------------",
            "SAZ. COMPLETO  GIGANTE X 42 SBS",
            "PALILLO MOLIDO  GIGANTE X 42 SBS",
            "COMINO MOLIDO GIGANTE X 42 SBS",
            "PIMIENTA NEGRA MOLIDA GIGANTE X 42 SBS ",
            "TUCO SAZON SALSA GIGANTE X 42 SBS ",
            "AJO MOLIDO GIGANTE X 42 SBS ",
            "CANELA MOLIDA GIGANTE X 42 SBS",
            "EL VERDE GIGANTE X 42 SBS",
            "KION MOLIDO GIGANTE X 42 SBS ",
            "OREGANO SELECTO X 42 SBS",
            "SAZONADOR COMPL. GIGANTE X 2 SBS                 ",
            "COMINO BATAN GIGANTE X 2 SBS",
            "PIMIENTA BATAN GIGANTE X 2 SBS",
            "PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "TUCO SAZON SALSA GIGANTE X 2 SBS",
            "AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "CANELA MOLIDA BATAN X 2 SBS",
            "EL VERDE BATAN GIGANTE X 2",
            "OREGANO MOLIDO X 2 SBS",
            "KION MOLIDO X 2 SBS",
            "AJI PANCA FRESCO BATAN  X 3 SBS",
            "AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "AJO FRESCO BATAN  X 3 SBS",
            "CULANTRO FRESCO BATAN  X 3 SBS",
            "SAZONADOR COMPLETO SIN PICANTE X 250 GR           ",
            "COMINO MOLIDO X 250 GRS                           ",
            "PIMIENTA MOLIDA  X 250 GR                         ",
            "PALILLO MOLIDO X 250 GR                           ",
            "AJO MOLIDO X 250 GR                               ",
            "OREGANO MOLIDO X 250 GR                           ",
            "SAZONADOR COMPLETO  X 500 GR                      ",
            "COMINO MOLIDO X 500 GR                            ",
            "PIMIENTA MOLIDA X 500 GR                          ",
            "PALILLO MOLIDO X 500 GR                           ",
            "AJO MOLIDO X 500 GR                               ",
            "OREGANO MOLIDO X 500 GR                           ",
            "SAL PARRILLERA BATAN PARA RES FRASCO X 225 GR.",
            "SAL PARRILLERA BATAN PARA POLLO FRASCO X 215 GR.",
            "SAL PARRILLERA BATAN PARA CERDO FRASCO X 220 GR.",
            "---------------------------",
            "|-----SP-PLAZAVEA---------|",
            "--------------------------",
            "CANELA MOLIDA FRASCO X 50 GRS",
            "SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "SAZ. COMPLETO BATAN GIGANTE X 24 GRS",
            "COMINO MOLIDO BATAN GIGANTE X 13 GRS",
            "PIMIENTA NEGRA MOLIDA BATAN GIGANTE X 12 GRS",
            "TUCO SAZON SALSA BATAN GIGANTE X 20 GRS",
            "----------------------------",
            "|--------SP-TOTTUS---------|",
            "----------------------------",
            "CANELA MOLIDA FRASCO X 50 GRS",
            "PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "TUCO SAZON SALSA FRASCO X 70 GRS",
            "AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "KION MOLIDO FRASCO X 50 GRS",
            "CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "SAZ. COMPLETO BATAN GIGANTE X 24 GRS",
            "PALILLO MOLIDO BATAN GIGANTE X 22 GRS",
            "TUCO SAZON SALSA BATAN GIGANTE X 20 GRS",
            "SAL DE AJOS MOLIDO BATAN GIGANTE X 16 GRS",
            "---------------------------",
            "|-------CR-METRO----------|",
            "--------------------------",
            "CANELA MOLIDA FRASCO X 50 GRS",
            "COMINO MOLIDO FRASCO X 50 GRS",
            "PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "KION MOLIDO FRASCO X 50 GRS",
            "SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "PALILLO BATAN FRASCO X 70 GRS",
            "OREGANO MOLIDO FRASCO X 25 GRS",
            "AJI AMARILLO FRASCO X 70 GRS",
            "AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "SAZ. EL VERDE FRASCO X 50 GRS",
            "PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "SAZ. COMPLETO BATAN GIGANTE X 24 GRS",
            "PALILLO MOLIDO BATAN GIGANTE X 22 GRS",
            "COMINO MOLIDO BATAN GIGANTE X 13 GRS",
            "PIMIENTA NEGRA MOLIDA BATAN GIGANTE X 12 GRS",
            "TUCO SAZON SALSA BATAN GIGANTE X 20 GRS",
            "SAL DE AJOS MOLIDO BATAN GIGANTE X 16 GRS",
            "----------------------",
            "|-----RI-SUPER--------|",
            "----------------------",
            "CANELA MOLIDA FRASCO X 50 GRS",
            "COMINO MOLIDO FRASCO X 50 GRS",
            "PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "TUCO SAZON SALSA FRASCO X 70 GRS",
            "SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "KION MOLIDO FRASCO X 50 GRS",
            "SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "PALILLO BATAN FRASCO X 70 GRS",
            "OREGANO MOLIDO FRASCO X 25 GRS",
            "AJI AMARILLO FRASCO X 70 GRS",
            "AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "SAZ. EL VERDE FRASCO X 50 GRS",
            "CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "SAL PARRILLERA BATAN PARA RES FRASCO X 225 GR.",
            "SAL PARRILLERA BATAN PARA POLLO FRASCO X 215 GR.",
            "SAL PARRILLERA BATAN PARA CERDO FRASCO X 220 GR."
    };
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    AutoCompleteTextView productoCompleteTxt;
    ArrayAdapter<String> productoItems;

    //********************************************************************

    EditText txtNombre, txtCorreo, txtDireccion;
    Button btn_insert;

    /*
    TextView tienda = findViewById(R.id.nombre);
    TextView producto = findViewById(R.id.correo);
    */
    String p_product=" ";

    String t_tienda=" ";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);



        //para el boton desplegable de nuestro botton
        autoCompleteTxt = findViewById(R.id.autoComplete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //accion que se debe mandar al los campos editables
                String item = parent.getItemAtPosition(position).toString();

                txtNombre = findViewById(R.id.nombre);
                txtNombre.setText(item);

                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();

            }
        });


        //para el boton desplegable producto
        productoCompleteTxt = findViewById(R.id.productos_txt);
        productoItems = new ArrayAdapter<String>(this,R.layout.list_item,productos);
        productoCompleteTxt.setAdapter(productoItems);
        productoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //accion que se debe mandar al los campos editables
                String item = parent.getItemAtPosition(position).toString();

                txtCorreo = findViewById(R.id.correo);
                txtCorreo.setText(item);


                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });




        //producto.setText(t_tienda);
        //tienda.setText(p_product);




/*
        txtNombre = findViewById(R.id.nombre);
        String valor = p_product;
        txtNombre.setText(valor);

        */

        //txtCorreo = findViewById(R.id.correo);
        txtDireccion = findViewById(R.id.direccion);

        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String nombre = txtNombre.getText().toString().trim();
        final String correo = txtCorreo.getText().toString().trim();
        final String direccion = txtDireccion.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(nombre.isEmpty()){
            Toast.makeText(this, "ingrese nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(correo.isEmpty()){
            Toast.makeText(this, "Ingrese correo", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(direccion.isEmpty()){
            Toast.makeText(this, "Ingrese direccion", Toast.LENGTH_SHORT).show();
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
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
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
                    params.put("nombre",nombre);
                    params.put("correo",correo);
                    params.put("direccion",direccion);
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