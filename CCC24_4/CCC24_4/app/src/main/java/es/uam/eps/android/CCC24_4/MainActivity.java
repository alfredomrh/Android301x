package es.uam.eps.android.CCC24_4;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import es.uam.eps.android.CCC24_4.Fragment1.OnButtonSelectedListener;

public class MainActivity extends Activity implements OnButtonSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.fragment1) == null) {
            Fragment1 fragment1 = new Fragment1();
            fm.beginTransaction().add(R.id.fragment1, fragment1).commit();
        }
    }

    @Override
    public void onButtonSelected(String str) {
		Intent intent = new Intent(getApplicationContext(), Detail.class);
		intent.putExtra("message", str);
		startActivity(intent);
    }
}
