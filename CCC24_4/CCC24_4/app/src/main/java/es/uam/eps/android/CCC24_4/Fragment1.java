package es.uam.eps.android.CCC24_4;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
    private OnButtonSelectedListener listener;
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle 
                             savedInstanceState){
		View view = inflater.inflate(R.layout.fragment1, container, false);
		
		Button button1 = (Button)view.findViewById(R.id.fragment1Button1);
		Button button2 = (Button)view.findViewById(R.id.fragment1Button2);
		
		button1.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        // TODO Auto-generated method stub
		        listener.onButtonSelected("First button clicked");
				
		    }
		});
		
		button2.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
			// TODO Auto-generated method stub
			listener.onButtonSelected("Second button clicked");
				
		    }
		});
		
		return view;
    }
    
    public interface OnButtonSelectedListener {
    	  public void onButtonSelected (String str);
    }

    @Override
    public void onAttach (Activity activity){
    	  super.onAttach(activity);
    	  if (activity instanceof OnButtonSelectedListener)
    		    listener = (OnButtonSelectedListener) activity;
    	  else {
    		   throw new ClassCastException(activity.toString() +
    				" does not implement OnButtonSelectedListener");
    	  }
    }
    
    @Override
    public void onDetach(){
    	  super.onDetach();
    	  listener = null;
    }
}
