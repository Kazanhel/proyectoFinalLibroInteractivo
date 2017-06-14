package com.denis.mercenario.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.denis.mercenario.R;
import com.denis.mercenario.model.Pagina;
import com.denis.mercenario.model.Historia;

import java.util.Stack;

public class HistoriaActivity extends AppCompatActivity {

    public static final String TAG = HistoriaActivity.class.getSimpleName();

    private String nombre;
    private String habilidad;
    private Historia historia;
    private TextView historiaTextView;
    private Button decision1Button;
    private Button decision2Button;
    private Button decision3Button;
    private Stack<Integer> pageStack = new Stack<Integer>();
    private String habilidadFuerza;
    private String habilidadReflejos;
    private String habilidadCarisma;
    private String habilidadSabiduria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        historiaTextView = (TextView)findViewById(R.id.storyTextView);
        decision1Button = (Button)findViewById(R.id.choice1Button);
        decision2Button = (Button)findViewById(R.id.choice2Button);
        decision3Button = (Button)findViewById(R.id.choice3Button);

        habilidadFuerza = "fuerza";
        habilidadReflejos = "reflejos";
        habilidadCarisma = "carisma";
        habilidadSabiduria = "sabiduria";

        Intent intent = getIntent();
        nombre = intent.getStringExtra(getString(R.string.nombre_prota));
        if (nombre == null || nombre.isEmpty()){
            nombre = "John";
        }

        // asignamos el intent de la habilidad escogida por el usuario y luego se la pasamos al título
        habilidad = intent.getStringExtra(getString(R.string.habilidad_escogida));
        setTitle("Habilidad: " + habilidad);

        System.out.println("la habilidad escogida: "+ habilidad);

        Log.d(TAG, nombre);

        historia = new Historia();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);
        // Hacemos que pagina sea final para poder referenciarla en la función onClick
        final Pagina pagina = historia.getPagina(pageNumber);
        String jugarDeNuevoTexto = "JUGAR DE NUEVO";

        String pageText = getString(pagina.getTextoId());
        pageText = String.format(pageText, nombre);
        historiaTextView.setText(pageText);

        //System.out.println("page number " + pageNumber);

        // Si estamos en la página final solo mostramos un botón
        if (pagina.isPaginaFinal()) {
            decision1Button.setVisibility(View.INVISIBLE);
            decision2Button.setVisibility(View.INVISIBLE);
            decision3Button.setText(jugarDeNuevoTexto);
            decision3Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    // Terminamos la actividad actual y nos lleva a la actividad principal (introducir nombre)
                   finish();
                }
            });
        }
        else if(pagina.hasOpcionEspecialPagina(habilidad)){
            System.out.println("la habilidad escogida: "+ habilidad);
            System.out.println("la habilidad Condicion: "+ pagina.getDecision1().getHabilidadCondicion());
            cargarTodosBotones(pagina);
        }
        else{
            cargarBotonesDosTres(pagina);
        }
    }

    private void cargarTodosBotones(final Pagina pagina) {
        decision1Button.setVisibility(View.VISIBLE);
        decision1Button.setText(pagina.getDecision1().getTextoDecisionId());
        decision1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtenemos la página que corresponde a la decisión1
                int nextPage = pagina.getDecision1().getSiguientePagina();
                loadPage(nextPage);
            }
        });

        decision2Button.setVisibility(View.VISIBLE);
        decision2Button.setText(pagina.getDecision2().getTextoDecisionId());
        decision2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = pagina.getDecision2().getSiguientePagina();
                loadPage(nextPage);
            }
        });

        decision3Button.setVisibility(View.VISIBLE);
        decision3Button.setText(pagina.getDecision3().getTextoDecisionId());
        decision3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = pagina.getDecision3().getSiguientePagina();
                loadPage(nextPage);
            }
        });
    }

    private void cargarBotonesDosTres(final Pagina pagina) {
        decision1Button.setVisibility(View.INVISIBLE);

        decision2Button.setVisibility(View.VISIBLE);
        decision2Button.setText(pagina.getDecision2().getTextoDecisionId());
        decision2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = pagina.getDecision2().getSiguientePagina();
                loadPage(nextPage);
            }
        });

        decision3Button.setVisibility(View.VISIBLE);
        decision3Button.setText(pagina.getDecision3().getTextoDecisionId());
        decision3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = pagina.getDecision3().getSiguientePagina();
                loadPage(nextPage);
            }
        });
    }

    //Método necesario para poder ir hacia atrás por las páginas
    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty()) {
            super.onBackPressed();
        }
        else {
            loadPage(pageStack.pop());
        }
    }
}
