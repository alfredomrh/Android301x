package es.uam.eps.android.CCC24_3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle 
                             savedInstanceState){
		View view = inflater.inflate(R.layout.fragment1, container, false);
		return view;
    }
}