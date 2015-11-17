package es.uam.eps.android.CCC24_3;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

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
	protected void onStart() {
		super.onStart();

		Fragment1 fragment = (Fragment1) getFragmentManager().findFragmentById(
				R.id.fragment1);

		Button button1 = (Button) fragment.getView().findViewById(
				R.id.fragment1Button1);
		Button button2 = (Button) fragment.getView().findViewById(
				R.id.fragment1Button2);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str;

		if (v.getId() == R.id.fragment1Button1)
			str = "Fist button clicked";
		else
			str = "Second button clicked";

		Intent intent = new Intent("es.uam.eps.android.CCC24_3.DETAIL");
		intent.putExtra("message", str);
		startActivity(intent);
	}
}
