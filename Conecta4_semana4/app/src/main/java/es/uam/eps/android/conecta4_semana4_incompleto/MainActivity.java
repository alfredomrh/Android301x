package es.uam.eps.android.conecta4_semana4_incompleto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final int ids[][] = {
            { R.id.c0, R.id.c1, R.id.c2, R.id.c3, R.id.c4, R.id.c5, R.id.c6 },
            { R.id.c7, R.id.c8, R.id.c9, R.id.c10, R.id.c11, R.id.c12, R.id.c13 },
            { R.id.c14, R.id.c15, R.id.c16, R.id.c17, R.id.c18, R.id.c19,
                    R.id.c20 },
            { R.id.c21, R.id.c22, R.id.c23, R.id.c24, R.id.c25, R.id.c26,
                    R.id.c27 },
            { R.id.c28, R.id.c29, R.id.c30, R.id.c31, R.id.c32, R.id.c33,
                    R.id.c34 },
            { R.id.c35, R.id.c36, R.id.c37, R.id.c38, R.id.c39, R.id.c40,
                    R.id.c41 } };

    private Game game;
    private TextView resultadoTextView;

    /*************************************************************************
    Completa este metodo.
    Despues de inflar la interfaz especificada en el fichero activity_main.xml,
    este metodo debe instanciar un objeto de tipo Game y asignar la referencia
    al miembro privado game.
    *************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       // Aqui debes incluir tu codigo
       game = new Game();
       
	   resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);
    }
    
    /*************************************************************************
    Completa este metodo.
    Dependiendo del estado de cada casilla del tablero, debes asignar al
    identificador id el dibujable adecuado:
    - R.drawable.c4_button
    - R.drawable.c4_human_pressed_button
    - R.drawable.c4_machine_pressed_button
    *************************************************************************/

    public void dibujarTablero() {

        int id = 0;

        for (int i = 0; i < Game.NFILAS; i++)
            for (int j = 0; j < Game.NCOLUMNAS; j++) {

                //recorre la matriz comprobando el estado de cada casilla y le asigna el boton correspondiente

                if(game.estaVacio(i,j)) id = R.drawable.c4_button;

                else if(game.estaJugador(i, j)) id = R.drawable.c4_human_pressed_button;

                else id = R.drawable.c4_machine_pressed_button;

                //recupera la referencia del boton y le asigna la imagen correspondiente
                ImageButton imageButton = (ImageButton) findViewById(ids[i][j]);
                imageButton.setImageResource(id);
            }
    }

    public void pulsado(View v) {
        int fila = 0, columna = 0, id = v.getId();

        if (game.finalJuego()) {
            Toast.makeText(this, R.string.fin_del_juego, Toast.LENGTH_SHORT)
                    .show(); 
            return;
        }

        fila = deIdentificadorAFila(id);
        columna = deIdentificadorAColumna(id);

        if (game.sePuedeColocarFicha(fila, columna) != true) {
            Toast.makeText(this, R.string.nosepuedecolocarficha,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        game.setJugador(fila, columna);

        dibujarTablero();

        if (game.comprobarCuatro(Game.JUGADOR)) {
            dibujarTablero();
            resultadoTextView.setText(R.string.gana_humano);
            return;
        }

        game.juegaMaquina();

        if (game.comprobarCuatro(Game.MAQUINA)) {
            dibujarTablero();
            resultadoTextView.setText(R.string.gana_maquina);
            return;
        }

        dibujarTablero();
    }

    private int deIdentificadorAFila(int id) {
        for (int i = 0; i < Game.NFILAS; i++)
            for (int j = 0; j < Game.NCOLUMNAS; j++)
                if (ids[i][j] == id)
                    return i;
        return -1;
    }

    private int deIdentificadorAColumna(int id) {
        for (int i = 0; i < Game.NFILAS; i++)
            for (int j = 0; j < Game.NCOLUMNAS; j++)
                if (ids[i][j] == id)
                    return j;
        return -1;
    }

    protected void onResume(){
        super.onResume();
        Music.play(this, R.raw.sonido1);
    }

    protected void onPause(){
        super.onPause();
        Music.stop(this);
    }
}