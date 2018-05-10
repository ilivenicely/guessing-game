package com.example.robertmccormick.robertmccormick_memorymatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;



import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int MAX_NUMBER=100;
    public static final Random RANDOM = new Random();
    private TextView msgTv;
    private EditText numberEnteredEdit;
    private Button validate;
    private int numberToFind, numberTries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = findViewById(R.id.msg);
        numberEnteredEdit = findViewById(R.id.NumberEnteredEt);
        validate=(Button) findViewById(R.id.validate);
        validate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int n = Integer.parseInt(numberEnteredEdit.getText().toString());
        numberTries++;
        if (n== numberToFind) {
            Toast.makeText(this,"Congratulations! Youfound the number" +
                    numberToFind + "in" + numberTries + "tries", Toast.LENGTH_SHORT ).show();
            newGame();
        } else if (n> numberToFind){
            msgTv.setText(R.string.too_high);
        } else if (n>numberToFind){
            msgTv.setText(R.string.too_low);
        }
    }

    private void newGame() {
        numberToFind =   RANDOM.nextInt(MAX_NUMBER) + 1;
        msgTv.setText(R.string.start_msg);
        numberEnteredEdit.setText("");
        numberTries=0;

    }
}
