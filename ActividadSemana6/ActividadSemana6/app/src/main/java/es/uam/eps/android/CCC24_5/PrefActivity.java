package es.uam.eps.android.CCC24_5;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class PrefActivity extends Activity {
	private static final String SHOW_EXIT_DIALOG = "SHOW_EXIT_DIALOG";
	private static final boolean SHOW_EXIT_DIALOG_DEF = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prefs_void);
		
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.content, new PrefFragment());
		ft.commit();
	}

	/**
	 * 
	 * @param context
	 * @return
	 */
	static boolean getShowCloseDialogPreference(Context context) {
		/* CAMBIO 3 Preferencias */
//captura las preferencias por defecto del contexto
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
		//la devuelve
		return sp.getBoolean(PrefActivity.SHOW_EXIT_DIALOG, PrefActivity.SHOW_EXIT_DIALOG_DEF);
	}
	
	/**
	 *  Situamos la clase del fragmento de preferencias internamente a la actividad  
	 *  de preferencias para evitar tener demasiados ficheros.
	 *
	 */
	class PrefFragment extends PreferenceFragment {

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
					
			addPreferencesFromResource(R.xml.preferences);
		}

	}
}
