package es.uam.eps.android.CCC29;


import android.os.Bundle;
import android.preference.PreferenceFragment;

public class CCCPreferenceFragment extends PreferenceFragment{

    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
    }
}