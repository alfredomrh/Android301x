package es.uam.eps.android.CCC24_5;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Fragment2 extends Fragment {
	Button b;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	
        View view = inflater.inflate(R.layout.fragment2, container, false);
        
        b = (Button)view.findViewById(R.id.button1);
        
        b.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// CAMBIO 1: Aniadiendo un fragmento dentro de otro en ejecucion 

                FragmentManager fm = getFragmentManager(); //conseguimos la referencia del gestor de fragmentos
                if (fm.findFragmentById(R.id.fragment3) == null) { //comprobamos que el fragmentos deseado no esta ya en la pila

                    Fragment3 fragment3 = new Fragment3(); //instanciamos el objeto de tipo fragment deseado
                    fm.beginTransaction().addToBackStack(null).add(R.id.fragment3, fragment3).commit(); //añade el fragmento
                }
            }
        });

        return view;
    }

    public void showText(String text) {
        TextView view = (TextView) getView().findViewById(R.id.fragment2TextView);
        view.setText(text);
        // CAMBIO 5 Animacion
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.resaltar);
        view.startAnimation(animation);

    }
}
