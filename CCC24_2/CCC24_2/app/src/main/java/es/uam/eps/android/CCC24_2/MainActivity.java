package es.uam.eps.android.CCC24_2;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {
	Fragment1 fragment1;
	Fragment2 fragment2;
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button1 = (Button) findViewById(R.id.fragment1Button1);
		Button button2 = (Button) findViewById(R.id.fragment1Button2);

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

		Intent intent = new Intent(getApplicationContext(), Detail.class);
		intent.putExtra("message", str);
		startActivity(intent);
	}
}
