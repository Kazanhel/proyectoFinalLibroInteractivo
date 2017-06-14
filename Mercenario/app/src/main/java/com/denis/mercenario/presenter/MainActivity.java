package com.denis.mercenario.presenter;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.denis.mercenario.R;

public class MainActivity extends AppCompatActivity {

    private EditText campoNombreProta;
    private Button botonComenzar;
    private RadioButton radioFuerza;
    private RadioButton radioReflejos;
    private RadioButton radioCarisma;
    private RadioButton radioSabiduria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asignación de de las variables a los distintos campos
        campoNombreProta = (EditText)findViewById(R.id.nameEditText);
        botonComenzar = (Button)findViewById(R.id.startButton);
        radioFuerza = (RadioButton) findViewById(R.id.fuerzaRadioButton);
        radioReflejos = (RadioButton)findViewById(R.id.reflejosRadioButton);
        radioCarisma = (RadioButton)findViewById(R.id.carismaRadioButton);
        radioSabiduria = (RadioButton)findViewById(R.id.sabiduriaRadioButton);

        botonComenzar.setOnClickListener(new View.OnClickListener(){
             @Override public void onClick(View v) {
                 String nombreEscogido = campoNombreProta.getText().toString();
                 String habilidadEscogida = getHabilidad();
                 empezarHistoria(nombreEscogido, habilidadEscogida);
             }
        });

    }

    @Override
    protected void onResume() {
      super.onResume();
        campoNombreProta.setText("");
    }

    private void empezarHistoria(String nombreEscogido, String habilidadEscogida) {
        Intent intent = new Intent(this, HistoriaActivity.class);
        Resources resources = getResources();
        // asignamos el nombre y habilidad escogidos en el fichero string.xml
        String key = resources.getString(R.string.nombre_prota);
        intent.putExtra(key, nombreEscogido);
        String key2 = resources.getString(R.string.habilidad_escogida);
        intent.putExtra(key2, habilidadEscogida);
        startActivity(intent);
    }

    private String getHabilidad() {
        String habilidadEscogida = null;
        if (radioFuerza.isChecked()) {
            habilidadEscogida = "fuerza";
        }
        else if (radioReflejos.isChecked()) {
            habilidadEscogida = "reflejos";
        }
        else if (radioCarisma.isChecked()) {
            habilidadEscogida = "carisma";
        }
        else if (radioSabiduria.isChecked()) {
            habilidadEscogida = "sabiduria";
        }
        return habilidadEscogida;
    }

}










