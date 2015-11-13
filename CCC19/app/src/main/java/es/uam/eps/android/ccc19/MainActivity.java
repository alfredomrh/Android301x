package es.uam.eps.android.ccc19;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	private void log(String text) {
		Log.d("LifeCycleTest", text);
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		log("created");
	}

	public void onStart() {
		super.onStart();
		log("started");
	}

	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		log("onRestoreInstanceState() called");
	}

	protected void onResume() {
		super.onResume();
		log("resumed");
	}

	protected void onPause() {
		super.onPause();
		log("paused");
		/*try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}*/
	}

	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		log("onSaveInstanteState() called");
	}

	protected void onStop() {
		super.onStop();
		log("stopped");
	}

	protected void onDestroy() {
		super.onDestroy();
		log("destroyed");
	}

	protected void onRestart() {
		super.onRestart();
		log("restarted");
	}

	public void StartOtraActivity(View view) {

		try {
			Intent i = new Intent(Intent.ACTION_CALL);
			i.setData(Uri.parse("tel://111111111"));
			startActivity(i);
		} catch (ActivityNotFoundException activityException) {
			Log.e("dialing-example", "Call failed", activityException);
		}

	}

}