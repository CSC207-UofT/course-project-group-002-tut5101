package com.example.androidgui.orderactivities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import com.example.androidgui.useractivities.EnterLocationActivity;
import constant.ordersystem.BuildOrderInfo;
import constant.ordersystem.OrderType;
import controller.customersystem.DineInTakeOutPresenter;
import controller.customersystem.SelectDineInTakeOutViewInterface;


/**
 * Select whether an order is dine in or take out
 */
public class SelectDineInTakeOutActivity extends AppCompatActivity implements SelectDineInTakeOutViewInterface {
    private NumberPicker selectDineInTakeOut;
    private TextView askDineInTakeOut;
    private String[] selectDineInTakeOutOptions;
    private DineInTakeOutPresenter dineInTakeOutPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dine_in_take_out);

        dineInTakeOutPresenter = new DineInTakeOutPresenter();
        dineInTakeOutPresenter.setSelectDineInTakeOutViewInterface(this);

        selectDineInTakeOut = findViewById(R.id.selectDineInTakeOut);
        askDineInTakeOut = findViewById(R.id.askDineInTakeOut);

        setupMessage();

        setupOptions();

    }

    private void setupMessage() {
        String askDineInTakeOutMessage = "Is this order Dine In or Delivery?";
        askDineInTakeOut.setText(askDineInTakeOutMessage);
    }

    private void setupOptions() {
        selectDineInTakeOutOptions = new String[]{OrderType.DINE_IN.name(), OrderType.DELIVERY.name()};
        selectDineInTakeOut.setMinValue(0);
        selectDineInTakeOut.setMaxValue(selectDineInTakeOutOptions.length - 1);
        selectDineInTakeOut.setDisplayedValues(selectDineInTakeOutOptions);
    }

    public void next(View v) {
        dineInTakeOutPresenter.retrieveOrderType(selectDineInTakeOutOptions[selectDineInTakeOut.getValue()]);
    }

    public void updateOrderType(OrderType orderType){
        Intent intent = new Intent(SelectDineInTakeOutActivity.this, EnterLocationActivity.class);
        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        startActivity(intent);
    }
}