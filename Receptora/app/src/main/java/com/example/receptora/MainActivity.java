package com.example.receptora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null){
            if("text/plain".equals(type)){
                manipularTexto(intent);
            }
        }
    }

    public void manipularTexto(Intent intent){
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(sharedText != null){

            TextView[] txts  = new TextView[6];
            txts[0]= (TextView)findViewById(R.id.txt_1);
            txts[1]= (TextView)findViewById(R.id.txt_2);
            txts[2]= (TextView)findViewById(R.id.txt_3);
            txts[3]= (TextView)findViewById(R.id.txt_4);
            txts[4]= (TextView)findViewById(R.id.txt_5);
            txts[5]= (TextView)findViewById(R.id.txt_6);

            TextView[] txtps  = new TextView[6];
            txtps[0]= (TextView)findViewById(R.id.txt_p1);
            txtps[1]= (TextView)findViewById(R.id.txt_p2);
            txtps[2]= (TextView)findViewById(R.id.txt_p3);
            txtps[3]= (TextView)findViewById(R.id.txt_p4);
            txtps[4]= (TextView)findViewById(R.id.txt_p5);
            txtps[5]= (TextView)findViewById(R.id.txt_p6);

            TextView txtTotal;

            Gson gson = new Gson();
            ArrayList<String> obj = gson.fromJson(sharedText, ArrayList.class);

            double total = 0;
            int a=0,b=0;
            for(int x=0;x < obj.size();x++) {
                if(x%2==0){
                    txts[a].setText(obj.get(x));
                    a++;
                }else{
                    txtps[b].setText(obj.get(x));
                    b++;
                    total = Double.parseDouble(obj.get(x)) + total;
                }
            }
            txtTotal = (TextView) findViewById(R.id.Txt_Total);
            txtTotal.setText("Total a Pagar : "+String.valueOf(total));
        }
    }
}
