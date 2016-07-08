package com.example.shashank.mycalculator;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity extends AppCompatActivity{
    TextView result_tv,op_tv;
    String op;
    StringBuilder s;
    int temp,res;
    public String str="",str2="";
    Button one,two,three,four,five,six,seven,eight,nine,zero,floater,clear,divide,multiply,subtract,plus,sqroot,equal,plusminus;
    ImageButton backspace ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        res=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         result_tv = (TextView) findViewById(R.id.result_tv);
        op_tv = (TextView)findViewById(R.id.operator_View);
        clear = (Button)findViewById(R.id.cancel);
        divide = (Button)findViewById(R.id.divide);
        multiply = (Button)findViewById(R.id.multiply);
        subtract = (Button)findViewById(R.id.subtract);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        zero = (Button)findViewById(R.id.zero);
        plusminus = (Button)findViewById(R.id.plus_minus);
        plus = (Button)findViewById(R.id.add);
        sqroot = (Button)findViewById(R.id.sqr_root);
        equal = (Button)findViewById(R.id.equalto);
        backspace = (ImageButton)findViewById(R.id.backspace);
        floater = (Button)findViewById(R.id.floater);

try {
    clear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            result_tv.setTextColor(getResources().getColor(R.color.color_dark));
            reset();
        }
    });

    divide.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            op = "/";
            if(op_tv.getText().toString().isEmpty())
                op_tv.setText(op);
            temp = 1;
        }
    });
    multiply.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            op = "*";
            if(op_tv.getText().toString().isEmpty())
                op_tv.setText(op);
            temp = 1;

        }
    });
    subtract.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            op = "-";
            if(op_tv.getText().toString().isEmpty())
                op_tv.setText(op);
            temp = 1;


        }
    });
    plus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            op = "+";
            if(op_tv.getText().toString().isEmpty())
                op_tv.setText(op);
            temp = 1;
        }
    });
   plusminus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StringBuilder s = new StringBuilder("");

            if(temp==0)
            {
                if(!(str.contains("-"))) {
                    s.append(str);
                    s.insert(0, "-");
                    str = s.toString();
                    result_tv.setText(str);
                }
                else{
                    s.append(str);
                    s.delete(0, 1);
                    str = s.toString();
                    result_tv.setText(str);
                }
            }
            else if(temp==1){
                if(!(str.contains("-"))) {
                    s.append(str2);
                    s.insert(0, "-");
                    str2 = s.toString();
                    result_tv.setText(str2);
                }
                else{
                    s.append(str);
                    s.delete(0, 1);
                    str = s.toString();
                    result_tv.setText(str);
                }

            }

        }
    });
    sqroot.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           String s ;
            Double result = null;
          try {
              if(temp == 0)
              {

              if (Double.parseDouble(str)>=0 )
              {

                  result = (Double) (Math.sqrt(Double.parseDouble(str)));
              }
              else{
                  Toast.makeText(MainActivity.this,"OH!Thats IMAGINARY!",Toast.LENGTH_SHORT).show();
                  }


              }


          else {
                  if( Double.parseDouble(str2)>=0)
                  {
                  result = (Double) (Math.sqrt(Double.parseDouble(str2)));
                  }
                  else{
              Toast.makeText(MainActivity.this,"OH!Thats IMAGINARY!",Toast.LENGTH_SHORT).show();

                  }
              }
              result_tv.setTextColor(getResources().getColor(R.color.color_light_green));

              result_tv.setText(result.toString());
              str = result.toString();
              str2 = "";


          }catch (Exception a){Toast.makeText(MainActivity.this,a.toString(),Toast.LENGTH_SHORT);}
        }
    });

    equal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(str2!="")
                evaluate();
        }
    });

    backspace.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
                  /* double val = Double.parseDouble(str);
                   val/=(int)10;
                if(temp==0)
                str =  Double.toString(val);
                else str = Double.toString(val);
                 */
            result_tv.setTextColor(getResources().getColor(R.color.color_dark));

            if (temp == 0)
                if (str != null && str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                } else {
                }
            else {
                if (str2 != null && str2.length() > 0) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
            }

            result_tv.setText(str);
        }


    });
    seven.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1)
            {result_tv.setText("");
            res=0;
            reset();}
            appendto(7);


        }
    });
    eight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            }
            appendto(8);
        }
    });
    nine.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            } appendto(9);
        }
    });
    five.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            }
            appendto(5);
        }
    });
    four.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            }

                appendto(4);
        }
    });
    six.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            }
                appendto(6);
        }
    });
    one.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            }
                appendto(1);
        }
    });
    two.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            } appendto(2);
        }
    });
    three.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            } appendto(3);
        }
    });
    zero.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(res==1) {
                result_tv.setText("");
                res = 0;
                reset();
            }
                appendto(0);
        }
    });

        floater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setTextColor(getResources().getColor(R.color.color_dark));

                if(temp == 0) {
                    str = str + ".".toString();
                    //Toast.makeText(this,"HERE!!!!",Toast.LENGTH_LONG).show();
                    result_tv.setText(str);
                }

                else {
                    str2 = str2 + ".".toString();
                    result_tv.setText(str2);

                }
            }
        });


}catch (Exception a){
    reset();
    //Toast.makeText(this,a.toString(),Toast.LENGTH_SHORT).show();
}
}



    private void reset() {
        str="";
        str2="";
        result_tv.setText("");
        temp=0;
       // Toast.makeText(this,"reset",Toast.LENGTH_SHORT).show();


    }

private void appendto(Integer c){
   try{
       result_tv.setTextColor(getResources().getColor(R.color.color_dark));

    if(temp == 0) {
        str = str + c.toString();
        //Toast.makeText(this,"HERE!!!!",Toast.LENGTH_LONG).show();
        result_tv.setText(str);
    }

    else {
        str2 = str2 + c.toString();
                result_tv.setText(str2);

    }
    }catch (Exception a){
    reset();
       Toast.makeText(this,a.toString(),Toast.LENGTH_SHORT).show();

   }

   }

    public void evaluate() {
        try {
            res=1;
            temp = 0;
            result_tv.setTextColor(getResources().getColor(R.color.color_light_green));
            op_tv.setText("");

            switch (op) {
                case "+": {
                    Double result = (Double) (Double.parseDouble(str) + Double.parseDouble(str2));
                    result_tv.setText(result.toString());
                    str = result.toString();
                    str2 = "";
                }
                break;

                case "-": {
                    Double result = (Double) (Double.parseDouble(str) - Double.parseDouble(str2));
                    result_tv.setText(result.toString());
                    str = result.toString();
                    str2 = "";
                }
                break;
                case "*": {
                    Double result = (Double) (Double.parseDouble(str) * Double.parseDouble(str2));
                    result_tv.setText(result.toString());
                    str = result.toString();
                    str2 = "";
                }
                break;
                case "/": {
                    if (Double.parseDouble(str2) != 0) {
                        Double result = (Double) (Double.parseDouble(str) / Double.parseDouble(str2));
                        result_tv.setText(result.toString());
                        str = result.toString();
                        str2 = "";
                    } else {
                        Toast.makeText(this, "CANNOT DIVIDE BY ZERO!", Toast.LENGTH_LONG).show();
                        reset();
                    }
                }
                break;

            }


        } catch (Exception a) {

            reset();
            Toast.makeText(this,a.toString(),Toast.LENGTH_SHORT).show();

        }


    }}
