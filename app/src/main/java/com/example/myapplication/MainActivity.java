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
   private String kind="";
   private String text="";
   private Double result=0.0,num1=0.0, num2=0.0;
  private   Boolean flag = false;
   private Boolean is= false;
  private   Integer pow=0;
    private   Integer sign=0;

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

        btnOne.setOnClickListener(v -> {
            text = text + "1";
            Number(1.0);
        } );
        btntwo.setOnClickListener(v -> {
            text = text + "2";
            Number(2.0);
        });
        btnthree.setOnClickListener(v -> {
            text = text + "3";
            Number(3.0);
                });
        btnfour.setOnClickListener(v -> {
            text = text + "4";
            Number(4.0);
                });
        btnfive.setOnClickListener(v -> {
            text = text + "5";
                Number(5.0);
                });

        btnsix.setOnClickListener(v -> {
            text = text + "6";
            Number(6.0);
                });
        btnseven.setOnClickListener(v -> {
            text = text + "7";
            Number(7.0);
        });
        btneight.setOnClickListener(v -> {
            text = text + "8";
            Number(8.0);

        });
        btnnine.setOnClickListener(v -> {
            text = text + "9";
            Number(9.0);
        });
        btnzero.setOnClickListener(v -> {
            text = text + "0";
            Number0(v);
        });
        btnpoint.setOnClickListener(this::Numberdot);
        btnequal.setOnClickListener(this::buEqual);
        btnclear.setOnClickListener(this::btnclear);
        btnsign.setOnClickListener(this::signChange);
        btnpercent.setOnClickListener(this::bupercent);
        btnmultiply.setOnClickListener(this::Multiply);
        btndivision.setOnClickListener(this::Division);
        btnPlus.setOnClickListener(this::plusEvent);
        btnminus.setOnClickListener(this::minusEvent);
    }
    public void Number(Double x) {
        if (!this.is) {
            if (this.flag == false)
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

        }
        txtResult.setText(text);
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
       else if(kind =="" &&num2==0.0)
           result=num1;
      num1=result;
      num2=0.0;
       flag=false;
       pow=0;
       sign=0;
       is=false;
       kind="";
       txtResult.setText(result.toString());

    }


    public void Numberdot(View view) {
        text = txtResult.getText().toString()+".";
        txtResult.setText(text);
        is = true;
    }

    public void Number0(View view) {
        text = txtResult.getText().toString() +"0";
        if(!is) {
            if (!flag)
                num1 = num1 * 10 + 0.0;
            else
                num2 = num2 * 10 + 0.0;
        }
        else pow++;
        txtResult.setText(text);
    }

    public void Maths(String k)
    {
        text = txtResult.getText().toString() + k.toString();
        txtResult.setText(text.toString());
        flag = true;
        pow=0;
        sign=0;
        kind=k.toString();

    }

    public void btnclear(View view) {
        txtResult.setText("0");
        num1 = 0.0;
        num2 = 0.0;
        text = "";
        flag = false;
        pow=0;
        sign=0;
        result=0.0;
    }
    public void plusEvent(View view) {
        Maths("+");
    }
    public void minusEvent(View view) {
        Maths("-");
    }
    public void bupercent(View view) {
       if(!flag)
           num1=num1/100;
       else num2=num2/100;
       text =txtResult.getText().toString()+"%";
       txtResult.setText(text);
    }
        public void Multiply(View view) {
        Maths("x");
    }
    public void  Division(View view) {
        Maths("÷");
    }
    public void signChange(View view) {
        sign++;
        if (flag == false)
            num1 = num1 * -1;
         else num2 = num2 *-1;
         if (sign%2!=0)
             text =txtResult.getText().toString()+"-";
         else text =txtResult.getText().toString().replace("-", "");
         txtResult.setText(text);

    }
    }