package com.example.hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import src.Controlador;
import src.Hilo;

public class MainActivity extends AppCompatActivity {

	TextView txtText;
	Hilo hilo, hilo_2;
	Controlador controlador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtText = findViewById( R.id.txtText );

		controlador = new Controlador( txtText );
		hilo = new Hilo( 10, 100, controlador );
		hilo_2 = new Hilo( 15, 120, controlador );
		hilo_2.start();
		hilo.start();
	}
}
