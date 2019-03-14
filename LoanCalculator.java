package com.example.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;

public class LoanCalculator extends AppCompatActivity {

    EditText inloanamount, inapr,interm,outpayment,outpaid;
    Button calculate,reset,amortization;

    final int MY_REQUEST_CODE = 1;

    int years,months,worki;
    double loanamount,apr,workd,rate,loanpayment,returnvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);

        inloanamount = findViewById(R.id.iamount);
        inapr = findViewById(R.id.iapr);
        interm = findViewById(R.id.iterm);
        outpayment = findViewById(R.id.opayment);

        //buttons
        calculate = findViewById(R.id.calculate);
        reset = findViewById(R.id.reset);
        amortization = findViewById(R.id.atable);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            loanamount = Double.parseDouble(inloanamount.getText().toString());
            apr = Double.parseDouble((inapr.getText().toString()));
            years = Integer.parseInt(interm.getText().toString());
            months = years * 12;
            worki = 1;
            rate = apr/100;
            rate = rate/12;
            workd = (double)worki + rate;
            workd = Math.pow(workd,(double)months);
            workd = workd - (double)worki;
            workd = rate / workd;
            workd = rate + workd;
            loanpayment = loanamount * workd;

            outpayment.setEnabled(true);

            inloanamount.setText("$"+(String.format("%,.2f",loanamount)));
            inapr.setText(String.format("%,.2f",apr)+ "%" );
            outpayment.setText("$"+(String.format("%,.2f",loanpayment)));

            reset.setEnabled(true);
            amortization.setEnabled(true);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inloanamount.setText("");
                inapr.setText("");
                interm.setText("");
                outpayment.setText("");
                amortization.setEnabled(false);
                outpayment.setEnabled(false);
                reset.setEnabled(false);
                // come back to reset your table
            }
        });
        amortization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoanCalculator.this,TableActivity.class);
                intent.putExtra("sent-amount",loanamount);
                intent.putExtra("sent-rate",rate);
                intent.putExtra("sent-years",years);
                intent.putExtra("sent-payment",loanpayment);

                startActivityForResult(intent,MY_REQUEST_CODE);
            }
        });




    }
}
