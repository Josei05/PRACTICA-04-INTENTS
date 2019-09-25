package com.example.emisora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnPedido;
    CheckBox CBox1,CBox2,CBox3,CBox4,CBox5,CBox6;
    ArrayList<String> menu = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CBox1 = (CheckBox) findViewById(R.id.CBox1);
        CBox2 = (CheckBox) findViewById(R.id.CBox2);
        CBox3 = (CheckBox) findViewById(R.id.CBox3);
        CBox4 = (CheckBox) findViewById(R.id.CBox4);
        CBox5 = (CheckBox) findViewById(R.id.CBox5);
        CBox6 = (CheckBox) findViewById(R.id.CBox6);

        btnPedido = (Button) findViewById(R.id.Btn_Pedido);
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.Btn_Pedido:
                        menu = new ArrayList();
                        if(CBox1.isChecked()){
                            menu.add("Aji de gallina");
                            menu.add("14.50");
                        }
                        if(CBox2.isChecked()){
                            menu.add("Arroz con pato");
                            menu.add("16.00");
                        }
                        if(CBox3.isChecked()){
                            menu.add("Asado de pollo");
                            menu.add("14.00");
                        }
                        if(CBox4.isChecked()){
                            menu.add("Adobo de chancho");
                            menu.add("13.50");
                        }
                        if(CBox5.isChecked()){
                            menu.add("Chicharron de chancho");
                            menu.add("12.00");
                        }
                        if(CBox6.isChecked()){
                            menu.add("Picante");
                            menu.add("13.00");
                        }
                }
                Gson gson = new Gson();
                String json = gson.toJson(menu);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,json);
                sendIntent.setType("text/plain");
                if(null != sendIntent.resolveActivity(getPackageManager())){
                    startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.send_to)));
                }
            }
        });
    }
}
