package es.uam.eps.android.conecta4_semana3_incompleto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class Initial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
    }

    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        startActivity(new Intent(this, MainActivity.class));
        return true;
    }
}
