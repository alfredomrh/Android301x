package es.uam.eps.android.CCC24_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.detail);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			String str = bundle.getString("message");
			TextView textView = (TextView) findViewById(R.id.fragment2TextView);
			textView.setText(str);
		}
	}
}
