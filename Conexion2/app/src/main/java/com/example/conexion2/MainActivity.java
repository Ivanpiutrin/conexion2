package com.example.conexion2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView txtnombres;
    TextView txtapellidos;
    TextView txthobbies;

    Button boton;
    DatabaseReference dbrf= FirebaseDatabase.getInstance().getReference();
    DatabaseReference campo1=dbrf.child("nombre");
    DatabaseReference campo2=dbrf.child("Apellido");
    DatabaseReference campo3=dbrf.child("Hobbi");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombres =(TextView) findViewById(R.id.txtnombre);
        txtapellidos =(TextView) findViewById(R.id.txtapellido);
        txthobbies =(TextView) findViewById(R.id.txthobbi);
        boton = (Button) findViewById(R.id.boton);



        campo1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String texto=snapshot.getValue().toString();
                txtnombres.setText(texto);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        campo2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String texto=snapshot.getValue().toString();
                txtapellidos.setText(texto);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        campo3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String texto=snapshot.getValue().toString();
                txthobbies.setText(texto);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                campo1.setValue("Elias");
            }
        });
    }
}