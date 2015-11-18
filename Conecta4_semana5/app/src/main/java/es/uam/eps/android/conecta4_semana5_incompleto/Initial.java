package es.uam.eps.android.conecta4_semana5_incompleto;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class Initial extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial);
    }

    /*************************************************************************
    Completa este metodo.
    El metodo debe arrancar la actividad MainActivity cuando el evento event 
    	es de tipo ACTION_DOWN.
    En caso contrario, el metodo debe devolver true.
    *************************************************************************/
    public boolean onTouchEvent(MotionEvent event) {
    	// Aqui debes colocar tu codigo
        return true;
    }
}