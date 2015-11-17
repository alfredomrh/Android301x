package es.uam.eps.android.conecta4_semana4_incompleto;

import android.app.Activity;
import android.content.Intent;
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

        int action = event.getAction(); //captura el tipo de evento

        if (action == MotionEvent.ACTION_DOWN)

                startActivity(new Intent(this, MainActivity.class));

        return true;
    }
}
