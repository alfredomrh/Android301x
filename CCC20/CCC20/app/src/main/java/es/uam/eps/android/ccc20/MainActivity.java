package es.uam.eps.android.ccc20;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

//clase que implementa la actividad principal, hereda de activity e implementa los escuchadores

public class MainActivity extends Activity implements OnClickListener{
	Game game; //declara un elemento de la clase Game

	static final int SIZE = 7; //declara el tamaño de filas y columnas
	
	private final int ids [][] = { //declara una matriz con las referencias de los botones
		{0, 0, R.id.f1, R.id.f2, R.id.f3, 0, 0},
    	{0, 0, R.id.f4, R.id.f5, R.id.f6, 0, 0},
    	{R.id.f7, R.id.f8, R.id.f9, R.id.f10, R.id.f11, R.id.f12, R.id.f13},
    	{R.id.f14, R.id.f15, R.id.f16, R.id.f17, R.id.f18, R.id.f19, R.id.f20},
        {R.id.f21, R.id.f22, R.id.f23, R.id.f24, R.id.f25, R.id.f26, R.id.f27},
    	{0, 0, R.id.f28, R.id.f29, R.id.f30, 0, 0},
    	{0, 0, R.id.f31, R.id.f32, R.id.f33, 0, 0}};

    //metodo que crea la interfaz
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //infla la interfaz
        registerListeners();
        game = new Game();
        setFigureFromGrid();
    }

    //metodo que asigna un escuchador a cada boton
    private void registerListeners (){
    	RadioButton button; //declara un objeto de la clase radiobutton
    	
    	for (int i=0; i<SIZE; i++)
    		for (int j=0; j<SIZE; j++)
    			if (ids[i][j]!=0){ //recorre la matriz y donde no haya un cero
    				button = (RadioButton) findViewById(ids[i][j]); //recupera la referencia a la vista boton
    				button.setOnClickListener(this); //le asigna un escuchador
    			}
    }

    //metodo que se ejecuta al pulsar en un boton que activa el escuchador y recibe la vista como parametro
    public void onClick (View v){

    	int id = ((RadioButton) v).getId(); //recupera el id de la vista boton

       	for (int i=0; i<SIZE; i++)
    		for (int j=0; j<SIZE; j++)
    			if (ids[i][j] == id) { //recorre la matriz buscando el id del boton
    				game.play(i, j); //le pasa la posicion al metodo play para que juegue
    				break; //rompe el bucle de recorrido de la matriz
    			}
    	
       	setFigureFromGrid(); //actualiza los movimientos

       	if (game.isGameFinished()) //comprueba si el juego ha terminado
       		Toast.makeText(this, R.string.gameOverTitle, Toast.LENGTH_LONG).show();
    }

    //metodo que actualiza el estado de la interfaz despues de los movimientos
    private void setFigureFromGrid (){
    	RadioButton button;
    	
    	for (int i=0; i<SIZE; i++)
    		for (int j=0; j<SIZE; j++)
    			if (ids[i][j] != 0){
    				int value = game.getGrid(i, j); //devuelve el valor de la matriz
    				button = (RadioButton) findViewById(ids[i][j]); //recupera la referencia al boton de esa posicion
		
    				if (value == 1) //y marca el boton si esta ocupado o libre
    					button.setChecked(true);
    				else 
    					button.setChecked(false);
    			}
    }

    //metodo que se ejecuta justo antes de que la actividad pase a interactuar con el usuario
    protected void onResume(){
        super.onResume();
        Music.play(this, R.raw.funkandblues); //pone la musica
    }

    //metodo que se ejecuta antes de que la actividad pierda el foco
    protected void onPause(){
        super.onPause();
        Music.stop(this); //para la musica
    }
}