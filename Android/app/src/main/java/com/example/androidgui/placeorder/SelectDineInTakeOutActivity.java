package com.example.androidgui.placeorder;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.orderSystem.BuildOrderInfo;
import constant.orderSystem.OrderType;

/**
 * Select whether an order is dine in or take out
 */
public class SelectDineInTakeOutActivity extends AppCompatActivity {
    NumberPicker selectDineInTakeOut;
    TextView askDineInTakeOut;
    String[] selectDineInTakeOutOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dine_in_take_out);

        selectDineInTakeOut = findViewById(R.id.selectDineInTakeOut);
        askDineInTakeOut = findViewById(R.id.askDineInTakeOut);

        String askDineInTakeOutMessage = "Is this order Dine In or Delivery?";
        askDineInTakeOut.setText(askDineInTakeOutMessage);

        selectDineInTakeOutOptions = new String[]{OrderType.DINE_IN.name(), OrderType.TAKE_OUT.name()};
        selectDineInTakeOut.setMinValue(0);
        selectDineInTakeOut.setMaxValue(selectDineInTakeOutOptions.length);
        selectDineInTakeOut.setDisplayedValues(selectDineInTakeOutOptions);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void next(View v) {
        Intent intent = new Intent(SelectDineInTakeOutActivity.this, EnterLocationActivity.class);
        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), selectDineInTakeOutOptions[selectDineInTakeOut.getValue()]);
        startActivity(intent);
    }
}