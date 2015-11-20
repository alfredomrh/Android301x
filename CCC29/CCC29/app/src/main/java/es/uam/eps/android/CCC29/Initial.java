package es.uam.eps.android.CCC29;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Initial extends Activity {
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial);
        
       	
	    Animation animation = AnimationUtils.loadAnimation(this, R.anim.initial);
	    ImageView imageView = (ImageView) findViewById(R.id.initial);
	    imageView.startAnimation(animation);
    }
    
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            startActivity(new Intent("es.uam.eps.android.CCC29.MAINACTIVITY"));
        }
        return true;
    }     
}