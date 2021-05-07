package com.bthndmn12.romannumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }public void convert(View view){
        String num = editText.getText().toString();
        textView.setText("Number: "+RomanToInteger(num));
    }public static int RomanToInteger(String s){
        int num;
        char i = 'I';
        char v = 'V';
        char x = 'X';
        char l = 'L';
        char c = 'C';
        char d = 'D';
        char m = 'M';

        int count_one = 0;
        int count_four = 0;
        int count_five = 0;
        int count_nine=0;
        int count_ten= 0;
        int count_forty = 0;
        int count_fifty= 0;
        int count_ninety = 0;
        int count_hundred= 0;
        int count_fourHundred = 0;
        int count_fiveHundred= 0;
        int count_nineHundred = 0;
        int count_thousand= 0;


        for(int j = 0;j<s.length();j++){
            if(s.charAt(j) == i){
                count_one++;
                if(j+1<s.length()){
                    if(s.charAt(j+1) == v){
                        count_one--;
                        count_four++;
                        j += 1;
                    }else if(s.charAt(j+1)== x){
                        count_one--;
                        count_nine++;
                        j += 1;
                    }
                }
            }else if(s.charAt(j) == v){
                count_five++;
            }else if(s.charAt(j) == x){
                count_ten++;
                if(j+1<s.length()){
                    if(s.charAt(j+1) == l){
                        count_ten--;
                        count_forty++;
                        j += 1;
                    }else if(s.charAt(j+1)== c){
                        count_ten--;
                        count_ninety++;
                        j += 1;
                    }
                }
            }else if(s.charAt(j) == l){
                count_fifty++;
            }else if(s.charAt(j) == c){
                count_hundred++;
                if(j+1<s.length()){
                    if(s.charAt(j+1) == d){
                        count_hundred--;
                        count_fourHundred++;
                        j += 1;
                    }else if(s.charAt(j+1)== m){
                        count_hundred--;
                        count_nineHundred++;
                        j += 1;
                    }
                }
            }else if(s.charAt(j) == d){
                count_fiveHundred++;
            }else if(s.charAt(j) == m){
                count_thousand++;
            }
        }
        num = count_one*1+count_four*4+count_five*5+count_nine*9
                +count_ten*10+count_forty*40+count_fifty*50
                +count_ninety*90+count_hundred*100
                +count_fourHundred*400+count_fiveHundred*500
                +count_nineHundred*900+count_thousand*1000;
        return num;
    }
}