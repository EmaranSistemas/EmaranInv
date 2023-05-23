package com.yrsn.emaraninventory;

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
    String[] items = {"1  S.FRANCO EMMEL","2  S.FRANCO LAMBRAMANI","3  S.FRANCO K.TRISTAN","4  S.FRANCO K.MAYORISTA",
            "5  S.PERUANOS PLAZAVEA_EJERCITO","6  S.PERUANOS PLAZAVEA_LAMARINA",
            "7  H.T TOTTUS_EJERCITO","8  H.T TOTTUS_PARRA","9  H.T TOTTUS_PORONGOCHE",
            "10 C.RETAIL METRO_AVIACIÓN","11 C.RETAIL METRO_EJERCITO","12 C.RETAIL METRO_LAMBRAMANI","13 C.RETAIL METRO_HUNTER",
            "14 R.INTERNACIONALES SUPER_PIEROLA","15 R.INTERNACIONALES SUPER_PORTAL"};


    String[] final_array = {
            "1   ",
            "2   ",
            "3   ",
            "4   ",
            "5   ",
            "6   ",
            "7   ",
            "8   ",
            "9   ",
            "10  ",
            "11  ",
            "12  ",
            "13  ",
            "14  ",
            "15  ",
            "16  ",
            "17  ",
            "18  ",
            "19  ",
            "20  ",
            "21  ",
            "22  ",
            "23  ",
            "24  ",
            "25  ",
            "26  ",
            "27  ",
            "28  ",
            "29  ",
            "30  ",
            "31  ",
            "32  ",
            "33  ",
            "34  ",
            "35  ",
            "36  ",
            "37  ",
            "38  ",
            "39  ",
            "40  "
    };



    String[] SF_LAMBRAMANI={
            "1  SAZONADOR COMPL. GIGANTE X 2 SBS      ",
            "2  COMINO BATAN GIGANTE X 2 SBS",
            "3  PIMIENTA BATAN GIGANTE X 2 SBS",
            "4  PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "5  TUCO SAZON SALSA GIGANTE X 2 SBS",
            "6  AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "7  CANELA MOLIDA BATAN X 2 SBS",
            "8  EL VERDE BATAN GIGANTE X 2",
            "9  OREGANO MOLIDO X 2 SBS",
            "10 KION MOLIDO X 2 SBS",
            "11 AJO MOLIDO BATAN GIGANTE X 8 SBS",
            "12 CANELA MOLIDA BATAN X 8 SBS",
            "13 AJI PANCA FRESCO BATAN  X 3 SBS",
            "14 AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "15 AJO FRESCO BATAN  X 3 SBS",
            "16 CULANTRO FRESCO BATAN  X 3 SBS",
            "17 CANELA MOLIDA FRASCO X 50 GRS",
            "18 COMINO MOLIDO FRASCO X 50 GRS",
            "19 PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "20 TUCO SAZON SALSA FRASCO X 70 GRS",
            "21 SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "22 AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "23 KION MOLIDO FRASCO X 50 GRS",
            "24 SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "25 PALILLO BATAN FRASCO X 70 GRS",
            "26 OREGANO MOLIDO FRASCO X 25 GRS",
            "27 AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "28 SAZ. EL VERDE FRASCO X 50 GRS",
            "29 CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "30 PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "31 COMINO X 250 GRS ",
            "32 AJO  X 250 GRS",
            "33 PMIENTA X 250 GRS ",
            "34 OREGANO X  250 GRS",
            "35 SAZONADOR X 250 GRS ",
            "36 PALILLO X 250 GRS ",
            "37 SAL PARRILLERA RES FRASCO X 225 GRS ",
            "38 SAL PARRILLERA POLLO  FRASCO X 215 GRS ",
            "39 SAL PARRILLERA CERDO FRASCO X 220 GRS ",
            "40  "
    };

    String[] SF_K_TRISTAN={
            "1  SAZONADOR COMPL. GIGANTE X 2 SBS                 ",
            "2  COMINO BATAN GIGANTE X 2 SBS",
            "3  PIMIENTA BATAN GIGANTE X 2 SBS",
            "4  PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "5  TUCO SAZON SALSA GIGANTE X 2 SBS",
            "6  AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "7  CANELA MOLIDA BATAN X 2 SBS",
            "8  EL VERDE BATAN GIGANTE X 2",
            "9  OREGANO MOLIDO X 2 SBS",
            "10 KION MOLIDO X 2 SBS",
            "11 CANELA MOLIDA BATAN X 8 SBS",
            "12 AJI PANCA FRESCO BATAN  X 3 SBS",
            "13 AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "14 AJO FRESCO BATAN  X 3 SBS",
            "15 CULANTRO FRESCO BATAN  X 3 SBS",
            "16 CANELA MOLIDA FRASCO X 50 GRS",
            "17 COMINO MOLIDO FRASCO X 50 GRS",
            "18 PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "19 TUCO SAZON SALSA FRASCO X 70 GRS",
            "20 SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "21 AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "22 KION MOLIDO FRASCO X 50 GRS",
            "23 SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "24 PALILLO BATAN FRASCO X 70 GRS",
            "25 OREGANO MOLIDO FRASCO X 25 GRS",
            "26 AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "27 SAZ. EL VERDE FRASCO X 50 GRS",
            "28 CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "29 PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "30 COMINO X 250 GRS ",
            "31 AJO  X 250 GRS",
            "32 PMIENTA X 250 GRS ",
            "33 OREGANO X  250 GRS",
            "34 SAZONADOR X 250 GRS ",
            "35 SAL PARRILLERA RES FRASCO X 225 GRS ",
            "36 SAL PARRILLERA POLLO  FRASCO X 215 GRS ",
            "37 SAL PARRILLERA CERDO FRASCO X 220 GRS ",
            "38  ",
            "39  ",
            "40  "
    };

    String[] SF_K_MAYORISTA= {
            "1  SAZ. COMPLETO  GIGANTE X 42 SBS",
            "2  PALILLO MOLIDO  GIGANTE X 42 SBS",
            "3  COMINO MOLIDO GIGANTE X 42 SBS",
            "4  PIMIENTA NEGRA MOLIDA GIGANTE X 42 SBS ",
            "5  TUCO SAZON SALSA GIGANTE X 42 SBS ",
            "6  AJO MOLIDO GIGANTE X 42 SBS ",
            "7  CANELA MOLIDA GIGANTE X 42 SBS",
            "8  EL VERDE GIGANTE X 42 SBS",
            "9  KION MOLIDO GIGANTE X 42 SBS ",
            "10 OREGANO SELECTO X 42 SBS",
            "11 SAZONADOR COMPL. GIGANTE X 2 SBS                 ",
            "12 COMINO BATAN GIGANTE X 2 SBS",
            "13 PIMIENTA BATAN GIGANTE X 2 SBS",
            "14 PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "15 TUCO SAZON SALSA GIGANTE X 2 SBS",
            "16 AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "17 CANELA MOLIDA BATAN X 2 SBS",
            "18 EL VERDE BATAN GIGANTE X 2",
            "19 OREGANO MOLIDO X 2 SBS",
            "20 KION MOLIDO X 2 SBS",
            "21 AJI PANCA FRESCO BATAN  X 3 SBS",
            "22 AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "23 AJO FRESCO BATAN  X 3 SBS",
            "24 CULANTRO FRESCO BATAN  X 3 SBS",
            "25 SAZONADOR COMPLETO SIN PICANTE X 250 GR           ",
            "26 COMINO MOLIDO X 250 GRS                           ",
            "27 PIMIENTA MOLIDA  X 250 GR                         ",
            "28 PALILLO MOLIDO X 250 GR                           ",
            "29 AJO MOLIDO X 250 GR                               ",
            "30 OREGANO MOLIDO X 250 GR                           ",
            "31 SAZONADOR COMPLETO  X 500 GR                      ",
            "32 COMINO MOLIDO X 500 GR                            ",
            "33 PIMIENTA MOLIDA X 500 GR                          ",
            "34 PALILLO MOLIDO X 500 GR                           ",
            "35 AJO MOLIDO X 500 GR                               ",
            "36 OREGANO MOLIDO X 500 GR                           ",
            "37 SAL PARRILLERA BATAN PARA RES FRASCO X 225 GR.",
            "38 SAL PARRILLERA BATAN PARA POLLO FRASCO X 215 GR.",
            "39 SAL PARRILLERA BATAN PARA CERDO FRASCO X 220 GR.",
            "40  "
    };

    String[] SP_PLAZAEA={
            "1 CANELA MOLIDA FRASCO X 50 GRS",
            "2 SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "3 SAZ. COMPLETO BATAN GIGANTE X 24 GRS",
            "4 COMINO MOLIDO BATAN GIGANTE X 13 GRS",
            "5 PIMIENTA NEGRA MOLIDA BATAN GIGANTE X 12 GRS",
            "6 TUCO SAZON SALSA BATAN GIGANTE X 20 GRS",
            "7   ",
            "8   ",
            "9   ",
            "10  ",
            "11  ",
            "12  ",
            "13  ",
            "14  ",
            "15  ",
            "16  ",
            "17  ",
            "18  ",
            "19  ",
            "20  ",
            "21  ",
            "22  ",
            "23  ",
            "24  ",
            "25  ",
            "26  ",
            "27  ",
            "28  ",
            "29  ",
            "30  ",
            "31  ",
            "32  ",
            "33  ",
            "34  ",
            "35  ",
            "36  ",
            "37  ",
            "38  ",
            "39  ",
            "40  "
    };

    String[] SP_TOTTUS={
            "1  CANELA MOLIDA FRASCO X 50 GRS",
            "2  PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "3  TUCO SAZON SALSA FRASCO X 70 GRS",
            "4  AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "5  KION MOLIDO FRASCO X 50 GRS",
            "6  CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "7  PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "8  SAZ. COMPLETO BATAN GIGANTE X 24 GRS",
            "9  PALILLO MOLIDO BATAN GIGANTE X 22 GRS",
            "10 TUCO SAZON SALSA BATAN GIGANTE X 20 GRS",
            "11 SAL DE AJOS MOLIDO BATAN GIGANTE X 16 GRS",
            "12  ",
            "13  ",
            "14  ",
            "15  ",
            "16  ",
            "17  ",
            "18  ",
            "19  ",
            "20  ",
            "21  ",
            "22  ",
            "23  ",
            "24  ",
            "25  ",
            "26  ",
            "27  ",
            "28  ",
            "29  ",
            "30  ",
            "31  ",
            "32  ",
            "33  ",
            "34  ",
            "35  ",
            "36  ",
            "37  ",
            "38  ",
            "39  ",
            "40  "
    };

    String[] CR_METRO= {
            "1  CANELA MOLIDA FRASCO X 50 GRS",
            "2  COMINO MOLIDO FRASCO X 50 GRS",
            "3  PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "4  SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "5  KION MOLIDO FRASCO X 50 GRS",
            "6  SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "7  PALILLO BATAN FRASCO X 70 GRS",
            "8  OREGANO MOLIDO FRASCO X 25 GRS",
            "9  AJI AMARILLO FRASCO X 70 GRS",
            "10 AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "11 CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "12 SAZ. EL VERDE FRASCO X 50 GRS",
            "13 PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "14 SAZ. COMPLETO BATAN GIGANTE X 24 GRS",
            "16 PALILLO MOLIDO BATAN GIGANTE X 22 GRS",
            "17 COMINO MOLIDO BATAN GIGANTE X 13 GRS",
            "18 PIMIENTA NEGRA MOLIDA BATAN GIGANTE X 12 GRS",
            "19 TUCO SAZON SALSA BATAN GIGANTE X 20 GRS",
            "20 SAL DE AJOS MOLIDO BATAN GIGANTE X 16 GRS",
            "21  ",
            "22  ",
            "23  ",
            "24  ",
            "25  ",
            "26  ",
            "27  ",
            "28  ",
            "29  ",
            "30  ",
            "31  ",
            "32  ",
            "33  ",
            "34  ",
            "35  ",
            "36  ",
            "37  ",
            "38  ",
            "39  ",
            "40  "
    };

    String[] RI_SUPER = {
            "1  CANELA MOLIDA FRASCO X 50 GRS",
            "2  COMINO MOLIDO FRASCO X 50 GRS",
            "3  PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "4  TUCO SAZON SALSA FRASCO X 70 GRS",
            "5  SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "6  AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "7  KION MOLIDO FRASCO X 50 GRS",
            "8  SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "9  PALILLO BATAN FRASCO X 70 GRS",
            "10 OREGANO MOLIDO FRASCO X 25 GRS",
            "11 AJI AMARILLO FRASCO X 70 GRS",
            "12 AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "13 SAZ. EL VERDE FRASCO X 50 GRS",
            "14 CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "15 PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "16 SAL PARRILLERA BATAN PARA RES FRASCO X 225 GR.",
            "17 SAL PARRILLERA BATAN PARA POLLO FRASCO X 215 GR.",
            "18 SAL PARRILLERA BATAN PARA CERDO FRASCO X 220 GR.",
            "19  ",
            "20  ",
            "21  ",
            "22  ",
            "23  ",
            "24  ",
            "25  ",
            "26  ",
            "27  ",
            "28  ",
            "29  ",
            "30  ",
            "31  ",
            "32  ",
            "33  ",
            "34  ",
            "35  ",
            "36  ",
            "37  ",
            "38  ",
            "39  ",
            "40  "
    };

    String[] SF_EMMEL = {
            "1  CANELA MOLIDA FRASCO X 50 GRS",
            "2  COMINO MOLIDO FRASCO X 50 GRS",
            "3  PIMIENTA NEGRA MOLIDA FRASCO X 50 GRS",
            "4  TUCO SAZON SALSA FRASCO X 70 GRS",
            "5  SAZ.COMPL C/AJI SIN PICANTE FRASCO X 70 GRS",
            "6  AJI COL.PANCA PICANTE FRASCO X 70 GRS",
            "7  KION MOLIDO FRASCO X 50 GRS",
            "8  SAL DE AJOS MOLIDO FRASCO X 50 GRS",
            "9  PALILLO BATAN FRASCO X 70 GRS",
            "10 OREGANO MOLIDO FRASCO X 25 GRS",
            "11 AJI AMARILLO FRASCO X 70 GRS",
            "12 AJI PAPRIKA PIMENTON FRASCO X 50 GRS",
            "13 SAZ. EL VERDE FRASCO X 50 GRS",
            "14 CURRY MOLIDO BATAN FRASCO X 50 GRS",
            "15 PIMIENTA BLANCA MOLIDA BATAN FRASCO X 50 GRS",
            "16 SAZONADOR COMPL. GIGANTE X 2 SBS                 ",
            "17 COMINO BATAN GIGANTE X 2 SBS",
            "18 PIMIENTA BATAN GIGANTE X 2 SBS",
            "19 PALILLO MOLIDO BATAN GIG. X 2 SBS                        ",
            "20 TUCO SAZON SALSA GIGANTE X 2 SBS",
            "21 AJO MOLIDO BATAN GIGANTE X 2 SBS",
            "22 CANELA MOLIDA BATAN X 2 SBS",
            "23 EL VERDE BATAN GIGANTE X 2",
            "24 OREGANO MOLIDO X 2 SBS",
            "25 KION MOLIDO X 2 SBS",
            "26 AJI PANCA FRESCO BATAN  X 3 SBS",
            "27 AJI AMARILLO FRESCO BATAN  X 3 SBS",
            "28 AJO FRESCO BATAN  X 3 SBS",
            "29 CULANTRO FRESCO BATAN  X 3 SBS",
            "30 COMINO  X 250 GRS",
            "31 AJO  X 250 GRS",
            "32 PMIENTA X 250 GRS ",
            "33 OREGANO X  250 GRS",
            "34 SAZONADOR X 250 GRS ",
            "35 PALILLO X 250 GRS ",
            "36 SAL PARRILLERA RES FRASCO X 225 GRS ",
            "37 SAL PARRILLERA POLLO  FRASCO X 215 GRS ",
            "38 SAL PARRILLERA CERDO FRASCO X 220 GRS ",
            "39  ",
            "40  "
    };


    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    AutoCompleteTextView productoCompleteTxt;
    ArrayAdapter<String> productoItems;

    //********************************************************************

    EditText txtTienda, txtProducto, txtInventario,txtPedido;
    Button btn_insert;

    /*
    TextView tienda = findViewById(R.id.nombre);
    TextView producto = findViewById(R.id.producto);
    */
    String p_product=" ";

    String t_tienda=" ";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        boolean goo;

        //para el boton desplegable de nuestro botton
        autoCompleteTxt = findViewById(R.id.autoComplete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //accion que se debe mandar al los campos editables
                String item = parent.getItemAtPosition(position).toString();

                txtTienda = findViewById(R.id.tienda);
                String items_ = item.replaceFirst("^\\d+\\s*", "");
                txtTienda.setText(items_);








                if (item.equals("1  S.FRANCO EMMEL")) {
                    System.arraycopy(SF_EMMEL,0,final_array,0, SF_EMMEL.length);

                } else if (item.equals("2  S.FRANCO LAMBRAMANI")) {
                    System.arraycopy(SF_LAMBRAMANI,0,final_array,0, SF_LAMBRAMANI.length);

                }
                else if (item.equals("3  S.FRANCO K.TRISTAN")) {
                    System.arraycopy(SF_K_TRISTAN,0,final_array,0, SF_K_TRISTAN.length);
                }

                else if (item.equals("4  S.FRANCO K.MAYORISTA")) {
                    System.arraycopy(SF_K_MAYORISTA,0,final_array,0, SF_K_MAYORISTA.length);
                }

                else if (item.equals("5  S.PERUANOS PLAZAVEA_EJERCITO")) {
                    System.arraycopy(SP_PLAZAEA,0,final_array,0, SP_PLAZAEA.length);
                }

                else if (item.equals("6  S.PERUANOS PLAZAVEA_LAMARINA")) {
                    System.arraycopy(SP_PLAZAEA,0,final_array,0, SP_PLAZAEA.length);
                }

                else if (item.equals("7  H.T TOTTUS_EJERCITO")) {
                    System.arraycopy(SP_TOTTUS,0,final_array,0, SP_TOTTUS.length);
                }

                else if (item.equals("8  H.T TOTTUS_PARRA")) {
                    System.arraycopy(SP_TOTTUS,0,final_array,0, SP_TOTTUS.length);
                }

                else if (item.equals("9  H.T TOTTUS_PORONGOCHE")) {
                    System.arraycopy(SP_TOTTUS,0,final_array,0, SP_TOTTUS.length);
                }

                else if (item.equals("10 C.RETAIL METRO_AVIACIÓN")) {
                    System.arraycopy(CR_METRO,0,final_array,0, CR_METRO.length);
                }

                else if (item.equals("11 C.RETAIL METRO_EJERCITO")) {
                    System.arraycopy(CR_METRO,0,final_array,0, CR_METRO.length);
                }
                else if (item.equals("12 C.RETAIL METRO_LAMBRAMANI")) {
                    System.arraycopy(CR_METRO,0,final_array,0, CR_METRO.length);
                }

                else if (item.equals("13 C.RETAIL METRO_HUNTER")) {
                    System.arraycopy(CR_METRO,0,final_array,0, CR_METRO.length);
                }

                else if (item.equals("14 R.INTERNACIONALES SUPER_PIEROLA")) {
                    System.arraycopy(RI_SUPER,0,final_array,0, RI_SUPER.length);
                }
                else if (item.equals("15 R.INTERNACIONALES SUPER_PORTAL")) {
                    System.arraycopy(RI_SUPER,0,final_array,0, RI_SUPER.length);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Seleccione una tienda",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(),"Tienda: "+item,Toast.LENGTH_SHORT).show();

            }
        });


        //para el boton desplegable producto
        productoCompleteTxt = findViewById(R.id.productos_txt);

        productoItems = new ArrayAdapter<String>(this,R.layout.list_item,final_array);


        productoCompleteTxt.setAdapter(productoItems);
        productoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //accion que se debe mandar al los campos editables
                String item = parent.getItemAtPosition(position).toString();

                txtProducto = findViewById(R.id.producto);
                String items_ = item.replaceFirst("^\\d+\\s*", "");
                txtProducto.setText(items_);


                Toast.makeText(getApplicationContext(),"Producto: "+item,Toast.LENGTH_SHORT).show();
            }
        });




        //producto.setText(t_tienda);
        //tienda.setText(p_product);




/*
        txtTienda = findViewById(R.id.nombre);
        String valor = p_product;
        txtTienda.setText(valor);

        */

        //txtProducto = findViewById(R.id.producto);
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
            Toast.makeText(this, "Ingrese un número en inventario", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pedido.isEmpty()){
            Toast.makeText(this, "Ingrese 0 si no hay Pedido", Toast.LENGTH_SHORT).show();
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