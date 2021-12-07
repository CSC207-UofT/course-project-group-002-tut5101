package com.example.android.order_activities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.NumberPicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.R;
import constant.order_system.BuildOrderInfo;
import constant.order_system.OrderType;
import presenter.order_system.DineInTakeOutPresenter;
import presenter.order_system.view_interfaces.SelectDineInTakeOutViewInterface;


/**
 * Select whether an order is dine in or take out
 */
public class SelectDineInTakeOutActivity extends AppCompatActivity implements SelectDineInTakeOutViewInterface {
    private NumberPicker selectDineInTakeOut;
    private String[] selectDineInTakeOutOptions;
    private DineInTakeOutPresenter dineInTakeOutPresenter;


    /**
     * Method that runs on creation of class
     * @param savedInstanceState saved state of the class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dine_in_take_out);

        dineInTakeOutPresenter = new DineInTakeOutPresenter();
        dineInTakeOutPresenter.setSelectDineInTakeOutViewInterface(this);

        selectDineInTakeOut = findViewById(R.id.selectDineInTakeOut);

        setupOptions();
    }

    /**
     * Set up order options available
     */
    private void setupOptions() {
        selectDineInTakeOutOptions = new String[]{OrderType.DINE_IN.name(), OrderType.DELIVERY.name()};
        selectDineInTakeOut.setMinValue(0);
        selectDineInTakeOut.setMaxValue(selectDineInTakeOutOptions.length - 1);
        selectDineInTakeOut.setDisplayedValues(selectDineInTakeOutOptions);
    }

    /**
     * Method that runs on click of button to pass the input to the presenter
     * @param v current view
     */
    public void next(View v) {
        dineInTakeOutPresenter.retrieveOrderType(selectDineInTakeOutOptions[selectDineInTakeOut.getValue()]);
    }

    /**
     * Presenter passes type of order back to activity, then activity runs next view to be displayed
     * @param orderType type of order
     */
    public void updateOrderType(OrderType orderType){
        Intent intent = new Intent(SelectDineInTakeOutActivity.this, EnterLocationActivity.class);
        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        startActivity(intent);
    }
}