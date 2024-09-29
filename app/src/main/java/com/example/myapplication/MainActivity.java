package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
   private Button btnOne, btnPlus,btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnzero,btnpoint,btnequal,btnclear,btnsign,btnpercent,btnmultiply,btndivision,btnminus;
    private TextView txtResult;
   private String kind;
   private String text;
   private Double result,num1, num2;
  private   Boolean flag = false;
   private Boolean is= false;
    private Integer sign=0;
  private   Integer pow=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    protected void onStart() {
        super.onStart();
        connectComponents();
    }

    public void connectComponents() {
        btnOne = findViewById(R.id.btnone);
        btntwo = findViewById(R.id.btntwo);
        btnthree = findViewById(R.id.btnthree);
        btnfour = findViewById(R.id.btnfour);
        btnfive = findViewById(R.id.btnfive);
        btnsix = findViewById(R.id.btnsix);
        btnseven = findViewById(R.id.btnseven);
        btneight = findViewById(R.id.btnnine);
        btnnine = findViewById(R.id.btneight);
        btnzero = findViewById(R.id.btnzero);
        btnpoint = findViewById(R.id.btndot);
        btnequal = findViewById(R.id.btnequal);
        btnclear = findViewById(R.id.btnac);
        btnsign = findViewById(R.id.btnsign);
        btnpercent = findViewById(R.id.btnmod);
        btnmultiply = findViewById(R.id.btnmul);
        btndivision = findViewById(R.id.btndiv);
        btnPlus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        txtResult = findViewById(R.id.etnumber);

        btnOne.setOnClickListener(this :: Number1);
        btntwo.setOnClickListener(this::Number2);
        btnthree.setOnClickListener(this::Number3);
        btnfour.setOnClickListener(this::Number4);
        btnfive.setOnClickListener(this::Number5);
        btnsix.setOnClickListener(this::Number6);
        btnseven.setOnClickListener(this::Number7);
        btneight.setOnClickListener(this::Number8);
        btnnine.setOnClickListener(this::Number9);
        btnzero.setOnClickListener(this::Number0);
        btnpoint.setOnClickListener(this::Numberdot);
        btnequal.setOnClickListener(this::buEqual);
        btnclear.setOnClickListener(this::btnclear);
        btnsign.setOnClickListener(this::signChange);
        btnpercent.setOnClickListener(this::bupercent);
        btnmultiply.setOnClickListener(this::Multiply);
        btndivision.setOnClickListener(this::Division);

    }
    public void Number(Double x) {
        text = txtResult.getText().toString();
        if (!is) {
            if (flag == false)
                num1 = num1 * 10 + x;
            else
                num2 = num2 * 10 + x;
        } else {
            if (flag == false) {
                num1 = num1 + x / (Math.pow(10, pow));
                pow++;
            } else {
                num2 = num2 + x / (Math.pow(10, pow));
                pow++;
            }
            txtResult.setText(text + "x");
        }
    }

    public void buEqual(View view) {
        if (kind == "+")
            result = num1 + num2;
        else if(kind == "-")
            result = num1 - num2;
       else if(kind == "x")
            result = num1 * num2;
       else if(kind == "÷")
            result = num1 / num2;
       num1 = result;
       num2= 0.0;
       txtResult.setText(result.toString());

    }

    public void Numberdot(View view) {
        text = txtResult.getText().toString();
        txtResult.setText(text+".");
    }

    public void Number0(View view) {
        text = txtResult.getText().toString();
        if(!is) {
            if (!flag)
                num1 = num1 * 10 + 0.0;
            else
                num2 = num2 * 10 + 0.0;
        }
        else pow++;
        txtResult.setText(text + "0");

    }

    public void Number1(View view) {
        Number(1.0);
        }


    public void Number2(View view) {
        Number(2.0);
    }

    public void Number3(View view) {
        Number(3.0);
    }
    public void Number4(View view) {
        Number(4.0);
    }
    public void Number5(View view) {
        Number(5.0);
    }
    public void Number6(View view) {
        Number(6.0);
    }
    public void Number7(View view) {
        Number(7.0);
    }
    public void Number8(View view) {
        Number(8.0);
    }
    public void Number9(View view) {
        Number(9.0);
    }
    public void Maths(String k)
    {
        text = txtResult.getText().toString();
        txtResult.setText(text + k.toString());
        flag = true;
        pow=0;
        kind=k.toString();
        sign=0;
    }
    public void plusEvent(View view) {
      Maths("+");
    }
    public void minusEvent(View view) {
       Maths("-");
    }
    public void bupercent(View view) {
       Maths("%");
    }
    public void btnclear(View view) {
        txtResult.setText("0");
        num1 = 0.0;
        num2 = 0.0;
         sign = 0;
        flag = false;
        pow=0;
    }
        public void Multiply(View view) {
        Maths("x");
    }
    public void  Division(View view) {
        Maths("÷");
    }
    public void signChange(View view) {
        text = txtResult.getText().toString();
        if (sign%2==0) {
            if (flag == false)
                num1 = num1 * -1;
            else num2 = num2 * -1;
            txtResult.setText("-" + text);
        }
        else txtResult.setText(text);
        sign ++;
    }








}