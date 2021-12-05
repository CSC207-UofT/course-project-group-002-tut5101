package com.example.androidgui.kitchen_activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.androidgui.R;
import presenter.kitchen_system.KitchenPresenter;

import java.util.ArrayList;

/**
 * Adapter for kitchen.
 */
public class KitchenAdapter extends ArrayAdapter {

    private final Context kContext;
    final int kResource;
    private KitchenPresenter kp;

    public KitchenAdapter(Context context, int resource, ArrayList<String[]> displayDishes, KitchenPresenter kp) {
        super(context, resource, displayDishes);
        kContext = context;
        kResource = resource;
        this.kp = kp;
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
            kp.completeDish(dishName);
            qt.setText(String.valueOf(Integer.parseInt(quantity) - 1));
        });

        return convertView;
    }

}
