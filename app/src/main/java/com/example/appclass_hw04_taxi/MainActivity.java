package com.example.appclass_hw04_taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editStartPrice;
    EditText editEveryMeter;
    EditText editAddsMoney;
    EditText editDistance;
    TextView textPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editStartPrice = findViewById(R.id.editStartPrice);
        editEveryMeter = findViewById(R.id.editEveryMeter);
        editAddsMoney = findViewById(R.id.editAddsMoney);
        editDistance = findViewById(R.id.editDistance);
        textPrice = findViewById(R.id.textPrice);
    }

    public void BtnCalculate(View view) {
        if(editStartPrice.getText().toString().equals("")){
            Toast.makeText(this, "請輸入起始費率", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editEveryMeter.getText().toString().equals("")){
            Toast.makeText(this, "請設定價錢", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editAddsMoney.getText().toString().equals("")){
            Toast.makeText(this, "請設定價錢", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editDistance.getText().toString().equals("")){
            Toast.makeText(this, "請輸入乘坐距離", Toast.LENGTH_SHORT).show();
            return;
        }
        int startPrice = Integer.parseInt(editStartPrice.getText().toString());
        int everyMeter = Integer.parseInt(editEveryMeter.getText().toString());
        int addsMoney = Integer.parseInt(editAddsMoney.getText().toString());
        int disTance = Integer.parseInt(editDistance.getText().toString());
        int Price = startPrice + (disTance / everyMeter) * addsMoney;
        if (disTance % everyMeter > 0) {
            Price = Price + addsMoney;
        }
        textPrice.setText("共"+Price+"元");
    }
}
