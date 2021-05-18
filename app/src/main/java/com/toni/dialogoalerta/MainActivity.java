package com.toni.dialogoalerta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarAlerta(View view){
        AlertDialog.Builder alertaConstructor = new AlertDialog.Builder(MainActivity.this);
        alertaConstructor.setTitle(R.string.alerta_title);
        alertaConstructor.setMessage(R.string.alerta_mensaje);
        alertaConstructor.setPositiveButton(R.string.alerta_boton_aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.alerta_boton_aceptar, Toast.LENGTH_SHORT).show();
            }
        });
        alertaConstructor.setNegativeButton(R.string.alerta_boton_cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.alerta_boton_cancelar, Toast.LENGTH_SHORT).show();
            }
        });
        alertaConstructor.show();
    }

    public void seleccionarFecha(View view){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.seleccionaFecha));
    }

    public void getFechaSeleccionada(int year, int month, int day){
        String mes_string = Integer.toString(month + 1);
        String dia_string = Integer.toString(day);
        String anio_string = Integer.toString(year);
        String fecha_string = getResources().getString(R.string.fecha_formato) + dia_string + " / " + mes_string + " / " + anio_string;
        Toast.makeText(this, fecha_string, Toast.LENGTH_LONG).show();
    }

    public void seleccionarHora(View view){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.hora));
    }

    public void getHoraSeleccionada(int hora, int minutos){
        String hora_string = Integer.toString(hora);
        String minutos_string = Integer.toString(minutos);
        String hora_mensaje = hora_string + " : " + minutos_string;
        Toast.makeText(this, hora_mensaje, Toast.LENGTH_LONG).show();
    }

}