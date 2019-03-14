package com.example.loancalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {
        double loanamount, rate, payment,interest,loss,returnvalue = 0.0;
        int years, x, count=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        //Intent receive = this.getIntent();
        loanamount = getIntent().getDoubleExtra("sent-amount",0.0);
        rate = getIntent().getDoubleExtra("sent-rate",0.0);
        payment = getIntent().getDoubleExtra("sent-payment",0.0);
        years = getIntent().getIntExtra("sent-years",0);

        TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

        tv1 = findViewById(R.id.textview1);
        tv2 = findViewById(R.id.textview2);
        tv1.setText("  Your loan amount $"+(String.format("%,.2f",loanamount)));
        x = years*12;
        tv2.setText("  Your number of payments "+(String.format("%d",x)));

        TableRow row;
        TableLayout mytable = findViewById(R.id.TableLayout);
        while (count <= x)
        {

         row = new TableRow(this);
         tv3 = new TextView(this);
         tv4 = new TextView(this);
         tv5 = new TextView(this);
         tv6 = new TextView(this);
         tv7 = new TextView(this);

         interest = loanamount * rate;
         loss = payment-interest;
         loanamount = loanamount - loss;
         tv3.setText(String.format("  %d  ",count));
         tv4.setText("$"+(String.format(" %,.2f  ",payment)));
         tv5.setText("$"+(String.format("%,.2f  ",interest)));
         tv6.setText("$"+(String.format("%,.2f  ",loss)));
         tv7.setText("$"+(String.format("%,.2f",loanamount)));
         row.addView(tv3);
         row.addView(tv4);
         row.addView(tv5);
         row.addView(tv6);
         row.addView(tv7);
         mytable.addView(row);
         count++;
         returnvalue+=interest;
        }






    }
}
