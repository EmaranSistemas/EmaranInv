package com.yrsn.emaraninventory.mercapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.yrsn.emaraninventory.MainActivity;
import com.yrsn.emaraninventory.R;

public class detalles extends AppCompatActivity {

    TextView tvid,tvname,tvemail,tvcontact,tvaddress;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txttienda);
        tvemail = findViewById(R.id.txtproducto);
        tvcontact = findViewById(R.id.txtinventario);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
/*
        tvid.setText("ID: " + MainActivity.employeeArrayList.get(position).getId());
        tvname.setText("tienda: " + MainActivity.employeeArrayList.get(position).gettienda());
        tvemail.setText("producto: " + MainActivity.employeeArrayList.get(position).getproducto());
        tvcontact.setText("inventario: " + MainActivity.employeeArrayList.get(position).getinventario());
*/
    }
}