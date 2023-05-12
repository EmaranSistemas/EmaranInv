package com.yrsn.emaraninventory;

import android.content.Context;
import android.widget.ArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter<Usuario>{
    Context context;
    List<Usuario> arrayusuario;

    public Adapter(@NonNull Context context, List<Usuario> arrayusuario) {
        super(context, R.layout.list_usuarios,arrayusuario);
        this.context = context;
        this.arrayusuario = arrayusuario;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_usuarios,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(arrayusuario.get(position).getId());
        tvName.setText(arrayusuario.get(position).gettienda());

        return view;
    }
}
