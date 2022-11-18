package com.example.assignment1casey;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculator obj = new Calculator();
    int mode = 0;

    TextView inputTV, historyTV;
    MaterialButton buttonC;
    MaterialButton buttonHistory;
    MaterialButton buttonDivide, buttonMultiply, buttonAdd, buttonSubtract, buttonEquals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTV = findViewById(R.id.input_tv);
        historyTV = findViewById(R.id.history_tv);
        historyTV.setMovementMethod(new ScrollingMovementMethod());
        buttonHistory = findViewById(R.id.button_history);
        buttonC = findViewById(R.id.button_c);

        assignId(buttonDivide,R.id.button_divide);
        assignId(buttonAdd,R.id.button_plus);
        assignId(buttonSubtract,R.id.button_minus);
        assignId(buttonMultiply,R.id.button_multiply);
        assignId(buttonEquals,R.id.button_equals);
        assignId(button0,R.id.button_0);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
//
        buttonHistory.setOnClickListener(view -> {

            if(mode==0){
                mode=1;
                historyTV.setVisibility(View.VISIBLE);
                buttonHistory.setText("STANDARD - NO HISTORY");
                historyTV.setText("");
            }
            else {
                mode=0;
                historyTV.setVisibility(View.INVISIBLE);
                buttonHistory.setText("ADVANCED - WITH HISTORY");
                obj.calculatorHistory.clear();
                obj.hisArrayIndex=0;
                obj.joined="";
                obj.hisJoinedString="";
            }
        });

        buttonC.setOnClickListener(view -> {
            inputTV.setText("0");
            obj.inputString.clear();
            obj.index=0;
            obj.joined = "";
        });
    }
//assignid
    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        MaterialButton button =(MaterialButton) v;
        String buttonText = button.getText().toString();

        if(buttonText.equals("=")){
            int result = obj.calculate();
            String resultString = String.valueOf(result);
            inputTV.setText(obj.joined+" = " +obj.solution);

            if(mode==1){
                obj.storeHistory();
                historyTV.setText(obj.calculatorHistory.toString()
                        .replace("[","")
                        .replace("]","")
                        .replace(",",""));
            }
        }
        else{
            // Getting text of the button pressed
            String data = ((MaterialButton) v).getText().toString();
            obj.push(data);
            inputTV.setText(obj.joined);

        }

    }



}