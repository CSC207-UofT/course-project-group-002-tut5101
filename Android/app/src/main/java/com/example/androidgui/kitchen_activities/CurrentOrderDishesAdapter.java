package com.example.androidgui.kitchen_activities;

import android.annotation.SuppressLint;
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
import java.util.Objects;

/**
 * Adapter for kitchen.
 */
public class CurrentOrderDishesAdapter extends ArrayAdapter<String[]> {

    private final Context kContext;
    final int kResource;
    private final KitchenPresenter kp;


    public CurrentOrderDishesAdapter(Context context, int resource, ArrayList<String[]> displayDishes, KitchenPresenter kp) {
        super(context, resource, displayDishes);
        kContext = context;
        kResource = resource;
        this.kp = kp;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dishName = ((String[]) Objects.requireNonNull(getItem(position)))[0];
        String quantity = ((String[]) Objects.requireNonNull(getItem(position)))[1];

        LayoutInflater inflater = LayoutInflater.from(kContext);
        convertView = inflater.inflate(kResource, parent, false);

        TextView dn = convertView.findViewById(R.id.kitchenDishName);
        TextView qt = convertView.findViewById(R.id.kitchenQuantity);
        Button bt = convertView.findViewById(R.id.kitchenButton);

        dn.setText(dishName);
        qt.setText(quantity);
        bt.setText(R.string.cooked);

        bt.setOnClickListener(view -> kp.completeDish(dishName));

        return convertView;
    }
}
