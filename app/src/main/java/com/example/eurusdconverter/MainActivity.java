package com.example.eurusdconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertUsdToEur(View v){
        TextView tview = (TextView) findViewById(R.id.editTextUSD);
        TextView toShow = (TextView) findViewById(R.id.valorDado);
        double val = Double.parseDouble(tview.getText().toString());
        double muliply = val * 0.8;
        toShow.setText(Double.toString(muliply) + "€");

        Toast.makeText(this, "$" + tview.getText().toString() + " são " + Double.toString(muliply) +"€", Toast.LENGTH_LONG).show();
    }
}