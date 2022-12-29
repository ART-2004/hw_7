package com.example.lessons_7;

import static android.widget.Toast.*;
import static com.example.lessons_7.R.id.editText;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    String oidNumder;
    String operator = "";
    Boolean isNew = true;
    EditText editText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        Button button=findViewById(R.id.buminus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeText(MainActivity.this, "Нажата кнопка'-'!", LENGTH_SHORT).show();
    }
});
        Button button1=findViewById(R.id.bumultiplication);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeText(MainActivity.this, "Нажата кнопка'x'!", LENGTH_SHORT).show();
            }
        });
        Button button2=findViewById(R.id.buplus);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeText(MainActivity.this, "Нажата кнопка'+'", LENGTH_SHORT).show();
            }
        });
        Button button3=findViewById(R.id.budivision);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeText(MainActivity.this, "Нажата кнопка'÷'", LENGTH_SHORT).show();
            }
        });

    }


    public void clikNumder(View view) {
        if (isNew)
            editText.setText("");
        isNew = false;
        String numder = editText.getText().toString();
        switch (view.getId()) {
            case R.id.bu1:
                numder = numder + "1";
                break;
            case R.id.bu2:
                numder = numder + "2";
                break;
            case R.id.bu3:
                numder = numder + "3";
                break;
            case R.id.bu4:
                numder = numder + "4";
                break;
            case R.id.bu5:
                numder = numder + "5";
                break;
            case R.id.bu6:
                numder = numder + "6";
                break;
            case R.id.bu7:
                numder = numder + "7";
                break;
            case R.id.bu8:
                numder = numder + "8";
                break;
            case R.id.bu9:
                numder = numder + "9";
                break;
            case R.id.bu0:
                numder = numder + "0";
                break;

            case R.id.buplusminus:
                if (numberIsZero(numder)) {
                    numder="0";
                }else {
                    if (dotIsPlusMinus(numder)) {
                        numder = numder.substring(1);
                    } else {
                        numder = "-" + numder;
                    }
                }
                break;

            case R.id.buClik:
                if (dotIsPresent(numder)) {

                } else {
                    numder = numder + ".";
                }
                break;
        }
        editText.setText(numder);

    }

    private boolean numberIsZero(String numder) {
        if (numder.equals("0")||numder.equals("0")){
            return true;
        }else {
            return false;
        }
    }


    public void operations(View view) {
        isNew = true;
        oidNumder = editText.getText().toString();
        switch (view.getId()){
            case R.id.buplus: operator="+" ;break;
            case R.id.buminus: operator="-" ;break;
            case R.id.bumultiplication: operator="*" ;break;
            case R.id.budivision: operator="/" ;break;
        }
    }

    public void clikEquals(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        switch (operator){
            case "-":result= Double.parseDouble(oidNumder) - Double.parseDouble(newNumber)  ;break;
            case "+":result= Double.parseDouble(oidNumder) + Double.parseDouble(newNumber)  ;break;
            case "*":result= Double.parseDouble(oidNumder) * Double.parseDouble(newNumber)  ;break;
            case "/":result= Double.parseDouble(oidNumder) / Double.parseDouble(newNumber)  ;break;
        }
        editText.setText(result+"");
    }

    public void acClik(View view) {
        editText.setText("0");
        isNew = true;
    }
    public boolean dotIsPresent(String numder){
        if (numder.indexOf(".") ==-1){
            return false;
        }else {
            return true;
        }
    }
    public boolean dotIsPlusMinus(String numder){
        if (numder.charAt(0) == '-'){
            return true;
        }else {
            return false;
        }
    }

    public void ClikPercent(View view) {
        if (operator==""){
            String numder=editText.getText().toString();
            double temp = Double.parseDouble(numder)/100;
            numder = temp +"";
            editText.setText(numder);
        }else {
            Double result = 0.0;
            String newNumber = editText.getText().toString();
            switch (operator){
                case "+":result= Double.parseDouble(oidNumder) + Double.parseDouble(oidNumder) * Double.parseDouble(newNumber)/100
                ;break;

                case "-":result= Double.parseDouble(oidNumder) -  Double.parseDouble(oidNumder) * Double.parseDouble(newNumber)/100
                ;break;
                case "*":result= Double.parseDouble(oidNumder) * Double.parseDouble(newNumber)/100 ;break;
                case "/":result= Double.parseDouble(oidNumder) / Double.parseDouble(newNumber)*100 ;break;
            }
            editText.setText(result+"");
            operator="";
        }

    }
}