package com.example.food;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza,burger,coke,pasta;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       pizza = findViewById(R.id.Pizza);
       burger = findViewById(R.id.Bur);
       coke = findViewById(R.id.Coke);
       pasta = findViewById(R.id.Pasta);
       b1 = findViewById(R.id.button);
       t1 = findViewById(R.id.view);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int total = 0;
               StringBuilder msg = new StringBuilder();
               msg.append("Your Order\n");
               if(pizza.isChecked()){
                   msg.append("Pizza - 100rs\n");
                   total = total + 100;
               }
               if(burger.isChecked()){
                   msg.append("Burger-80rs");
                   total = total + 80;
               }
               if(coke.isChecked()){
                   msg.append("Coke-20rs");
                   total = total + 20;
               }
               if(pasta.isChecked()){
                   msg.append("pasta-100rs");
                   total = total + 100;
               }
               msg.append("Total:" + total+"rs");
               t1.setText(msg.toString());
               Toast.makeText(MainActivity.this,"ORDER PLACED",Toast.LENGTH_LONG).show();


           }
       });
    }
}