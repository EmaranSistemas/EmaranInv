package com.yrsn.emaraninventory.mercapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yrsn.emaraninventory.R;
import java.util.List;

public class Adapter extends ArrayAdapter<tiendas> {

    Context context;
    List<tiendas> tiendasArray;

    public Adapter(@NonNull Context context, List<tiendas> tiendasArray) {
        super(context, R.layout.list_tiendas,tiendasArray);
        this.context =context;
        this.tiendasArray =tiendasArray;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tiendas,null,true);

        TextView tvID = view.findViewById(R.id.txt_store_id);
        TextView tvName = view.findViewById(R.id.txt_store_name);

        tvID.setText(tiendasArray.get(position).getId());
        tvName.setText(tiendasArray.get(position).getnombre());

        return view;
    }
}