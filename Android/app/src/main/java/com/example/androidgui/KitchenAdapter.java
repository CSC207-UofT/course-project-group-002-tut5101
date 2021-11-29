package com.example.androidgui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class KitchenAdapter extends ArrayAdapter {

    private Context kContext;
    int kResource;

    public KitchenAdapter(Context context, int resource, ArrayList<String[]> displayDishes) {
        super(context, resource, displayDishes);
        kContext = context;
        kResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dishName = ((String[]) getItem(position))[0];
        String quantity = ((String[]) getItem(position))[1];

        LayoutInflater inflater = LayoutInflater.from(kContext);
        convertView = inflater.inflate(kResource, parent, false);

        TextView dn = convertView.findViewById(R.id.kitchenDishName);
        TextView qt = convertView.findViewById(R.id.kitchenQuantity);
        Button bt = convertView.findViewById(R.id.kitchenButton);

        dn.setText(dishName);
        qt.setText(quantity);
        bt.setText("Cooked");

        bt.setOnClickListener(view -> {
            KitchenActivity.kc.completeDish(dishName);
            int a = Integer.parseInt(quantity);
            qt.setText(String.valueOf(a - 1));
        });


        return convertView;
    }
}
