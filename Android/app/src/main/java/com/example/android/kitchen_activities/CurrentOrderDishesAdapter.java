package com.example.android.kitchen_activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.android.R;
import presenter.kitchen_system.CookDishPresenter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Adapter for kitchen to display the dishes.
 */
public class CurrentOrderDishesAdapter extends ArrayAdapter<String[]> {

    private final Context kContext;
    private final int kResource;
    private final CookDishPresenter kp;
    /**
     * Create an adapter.
     * @param context the activity it in
     * @param resource The xml file to display
     * @param displayDishes the arraylist where its content would be displayed
     * @param kp the kitchen presenter
     */
    public CurrentOrderDishesAdapter(Context context, int resource, ArrayList<String[]> displayDishes, CookDishPresenter kp) {
        super(context, resource, displayDishes);
        kContext = context;
        kResource = resource;
        this.kp = kp;
    }
    /**
     * Get a View that displays the data at the specified position in the data set.
     * @param position the specified position
     * @param convertView the view to be inflated from a xml file
     * @param parent the parent View that will apply the default layout
     */
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
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

        bt.setOnClickListener(view -> {
            kp.completeDish(dishName);
            kp.updateView(dishName);
        });

        return convertView;
    }
}
