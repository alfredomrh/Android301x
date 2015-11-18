package es.uam.eps.android.CCC24_5;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import es.uam.eps.android.CCC24_5.Fragment1.OnButtonSelectedListener;

public class MainActivity extends Activity implements OnButtonSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_master_detail);

		Display display = getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		float density = getResources().getDisplayMetrics().density;
		float dpWidth = outMetrics.widthPixels / density;

		FragmentManager fm = getFragmentManager();
		if (fm.findFragmentById(R.id.fragment1) == null) {
			Fragment1 fragment1 = new Fragment1();
			fm.beginTransaction().add(R.id.fragment1, fragment1).commit();
		}

		if (dpWidth > 600) {
			if (fm.findFragmentById(R.id.fragment2) == null) {
				Fragment2 fragment2 = new Fragment2();
				fm.beginTransaction().add(R.id.fragment2, fragment2).commit();
			}
		}

		/* Carga las preferencias por defecto solo la primera vez que se ejecuta la aplicacion*/
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
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

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
			case R.id.mi_preferences:
				startActivity(new Intent(this, PrefActivity.class));
				return true;
			case R.id.mi_salir:
				//CAMBIO 4 dialogo
				//Si en las preferencias esta configurado que se muestre un cuadro de dialogo al salir o si no finaliza directamente
				if (PrefActivity.getShowCloseDialogPreference(this)) {
					//se obtiene el nombre y la pregunta de los strings
					String title = getResources().getString(R.string.app_name);
					String message = getResources().getString(R.string.salir_de_la_app);
					//se crea un nuevo fragment de dialogo con la pregunta y despues se muestra como un fragment
					WarnDialog wd = new WarnDialog(title, message);
					wd.show(getFragmentManager(), "DIALOG");
					
					/* Pregunta dialogo */
					Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
				}
				else {
					finish();
				}
				return true;
		}

		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		//CAMBIO 2 Inflar menu

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;

	}
	
	
}
