package es.uam.eps.android.CCC24_5;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;

import es.uam.eps.android.CCC24_5.Fragment1.OnButtonSelectedListener;

public class MainActivity extends Activity implements OnButtonSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_master_detail);
		
	  Display display = getWindowManager().getDefaultDisplay();
	  DisplayMetrics outMetrics = new DisplayMetrics ();
	  display.getMetrics(outMetrics);
	  float density  = getResources().getDisplayMetrics().density;
	  float dpWidth  = outMetrics.widthPixels / density;
		
	  FragmentManager fm = getFragmentManager();
		if (fm.findFragmentById(R.id.fragment1) == null) {
		    Fragment1 fragment1 = new Fragment1();
		    fm.beginTransaction().add(R.id.fragment1, fragment1).commit();
		}
		
	  if (dpWidth > 600){
		    if (fm.findFragmentById(R.id.fragment2) == null) {
			 Fragment2 fragment2 = new Fragment2();
			 fm.beginTransaction().add(R.id.fragment2, fragment2).commit();
		    }
	  }
    }

    @Override
    public void onButtonSelected(String str) {
		Fragment2 fragment = (Fragment2) getFragmentManager().findFragmentById(
				R.id.fragment2);
		if (fragment != null) {
		    fragment.showText(str);
		} else {
		    Intent intent = new Intent(getApplicationContext(), Detail.class);
		    intent.putExtra("message", str);
		    startActivity(intent);
		}
    }
}
