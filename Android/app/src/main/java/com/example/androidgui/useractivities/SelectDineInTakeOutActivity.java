package com.example.androidgui.useractivities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.ordersystem.BuildOrderInfo;
import constant.ordersystem.OrderType;
import controller.customersystem.OrderPresenter;
import controller.viewinterface.SelectDineInTakeOutViewInterface;


/**
 * Select whether an order is dine in or take out
 */
public class SelectDineInTakeOutActivity extends AppCompatActivity implements SelectDineInTakeOutViewInterface {
    private NumberPicker selectDineInTakeOut;
    private TextView askDineInTakeOut;
    private String[] selectDineInTakeOutOptions;
    private Button selectDineInTakeOutBtn;
    private OrderPresenter orderPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dine_in_take_out);

        orderPresenter = new OrderPresenter(this);

        selectDineInTakeOut = findViewById(R.id.selectDineInTakeOut);
        askDineInTakeOut = findViewById(R.id.askDineInTakeOut);

        selectDineInTakeOutBtn = findViewById(R.id.selectDineInTakeOutBtn);

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
        orderPresenter.retrieveOrderType(selectDineInTakeOutOptions[selectDineInTakeOut.getValue()]);
    }
    public void updateOrderType(OrderType orderType){
        Intent intent = new Intent(SelectDineInTakeOutActivity.this, EnterLocationActivity.class);
        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        startActivity(intent);
    }
}