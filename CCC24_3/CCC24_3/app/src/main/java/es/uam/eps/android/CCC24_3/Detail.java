package es.uam.eps.android.CCC24_3;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends Activity {
    public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		
		FragmentManager fm = getFragmentManager();
		if (fm.findFragmentById(R.id.fragment2) == null) {
		    Fragment2 fragment2 = new Fragment2();
		    fm.beginTransaction().add(R.id.fragment2, fragment2).commit();
		}	
    }
    
    @Override
    protected void onStart (){
    	  super.onStart();
    	
    	  Bundle bundle = getIntent().getExtras(); 
		if (bundle != null){
		    String str = bundle.getString("message");
		    TextView textView = (TextView) findViewById(R.id.fragment2TextView);
		    textView.setText(str);
		}
    }
}
