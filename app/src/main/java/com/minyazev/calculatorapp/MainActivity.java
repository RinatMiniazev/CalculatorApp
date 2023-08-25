package com.minyazev.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etNum1, etNum2, etOperation;
    private TextView tvResultText;


    private Button btnCalculateResult;
    private Toast toastError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.op1);
        etNum2 = findViewById(R.id.op2);
        etOperation = findViewById(R.id.operation);
        tvResultText = findViewById(R.id.result);
        btnCalculateResult = findViewById(R.id.btn);
        btnCalculateResult.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        float num1, num2, result = 0;
        String operation;
        boolean correctOperation = true;
        try {
            num1 = Float.parseFloat(etNum1.getText().toString());
            num2 = Float.parseFloat(etNum2.getText().toString());
            operation = etOperation.getText().toString();
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    correctOperation = false;
                    break;
            }
        } catch (Exception e){

            toastError = Toast.makeText(this,R.string.some_error, Toast.LENGTH_SHORT);
            toastError.show();
            return;
        }
        if(correctOperation){
            tvResultText.setText(num1+" " +operation+" "+num2+"="+result);
        }
        else{
            tvResultText.setText(R.string.unknown_operation);
        }
    }
}