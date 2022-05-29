package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btn_calculate;
    EditText editText_inch, editText_weight, editText_age, editText_feet;
    TextView textView_value, textView_info;
    RadioButton radioButton_male, radioButton_female;
    int val_age, val_weight;
    int val_feet, val_inch;
    boolean male = true;
    boolean female = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup_View_Variable();
        setup_View_SetOnclickListener();
    }

    private void setup_View_SetOnclickListener() {
        radioButton_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               male = true;
               female = false;
            }
        });
        radioButton_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male = false;
                female = true;
            }
        });
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean next = check_EditText();
                if(next == true) {
                    double BMI_val = BMI_Calculate();
                    age_Selection(BMI_val);
                }
            }
        });
    }
    private boolean check_EditText() {
        if(editText_age.getText().toString().matches("") == true)
        {
            Toast.makeText(this, "Please fill the age value", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(editText_feet.getText().toString().matches("") == true)
        {
            Toast.makeText(this, "Please fill the feet value", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(editText_inch.getText().toString().matches("") == true)
        {
            Toast.makeText(this, "Please fill the inch value", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(editText_weight.getText().toString().matches("") == true) {
            Toast.makeText(this, "Please fill the weight value", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {

            return true;
        }

    }
    private void age_Selection(double value) {
        val_age = Integer.parseInt(editText_age.getText().toString());
        if(val_age >= 18)
        {
            print_Result_Adult(value);
        }
        else
        {
            print_Result_Children(value);
        }
    }
    private void setup_View_Variable() {
        btn_calculate = (Button)findViewById(R.id.B_calculate);
        editText_age = (EditText) findViewById(R.id.ET_age);
        editText_weight = (EditText) findViewById(R.id.ET_weight);
        editText_inch = (EditText) findViewById(R.id.ET_inch);
        editText_feet = (EditText) findViewById(R.id.ET_feet);
        textView_value = (TextView) findViewById(R.id.T_value);
        textView_info = (TextView) findViewById(R.id.T_info);
        radioButton_male = (RadioButton) findViewById(R.id.RB_male);
        radioButton_female = (RadioButton) findViewById(R.id.RB_female);
        radioButton_male.toggle();
    }

    private double BMI_Calculate(){

        val_feet = Integer.parseInt(editText_feet.getText().toString());
        val_inch = Integer.parseInt(editText_inch.getText().toString());
        val_weight = Integer.parseInt(editText_weight.getText().toString());

        int totalInch = (val_feet * 12) + val_inch;

        double heightInMeter = totalInch * 0.0254;

        return val_weight / (heightInMeter * heightInMeter);

    }

    private void print_Result_Adult(double value){
        DecimalFormat BMI_Format = new DecimalFormat("0.00");
        String value_BMI = BMI_Format.format(value);
        textView_value.setText("BMI : " + value_BMI);

        if(value < 18.5)
        {
            textView_info.setText("Info : You are Underweight");
        }
        else if(value > 25)
        {
            textView_info.setText("Info : You are Overweight");
        }
        else if(value >= 18.5 && value <= 25){
            textView_info.setText("Info : You are a healthy weight");
        }
    }
    private void print_Result_Children(double value) {
        DecimalFormat BMI_Format = new DecimalFormat("0.00");
        String value_BMI = BMI_Format.format(value);
        textView_value.setText("BMI : " + value_BMI);
        if(male == true)
        {
            textView_info.setText("Info : As your are under 18, please consult with your doctor for the healthy range for boys");
        }
        else if(female == true)
        {
            textView_info.setText("Info : As your are under 18, please consult with your doctor for the healthy range for girls");
        }
    }
}