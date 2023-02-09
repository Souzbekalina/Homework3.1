package com.alina.homework31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private  Button button;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn_clickme);
        editText1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        editText3=findViewById(R.id.edit3);
        goToEmail();

    }

      private  void   goToEmail(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SENDTO , Uri.fromParts("hello" , editText1.getText().toString(), null));
                intent.putExtra(Intent.EXTRA_EMAIL,  editText1.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, editText2.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, editText3.getText().toString());
                startActivity(Intent.createChooser(intent, "Email via..."));

            }
        });

    }



}