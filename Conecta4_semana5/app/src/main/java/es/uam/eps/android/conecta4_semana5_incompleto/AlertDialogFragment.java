package es.uam.eps.android.conecta4_semana5_incompleto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {
	
    /*************************************************************************
    Completa este metodo.
    Debes inlcuir codigo que se ha de ejecutar cuando el jugador pulse el boton
    negativo del dialogo de alerta. El codigo debe llevar a cabo las siguientes
    tareas:
     - La actividad debe finalizar.
     - El dialogo se ha de eliminar, como en la opcion positiva.
    *************************************************************************/
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final MainActivity main = (MainActivity) getActivity();

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());
		alertDialogBuilder.setTitle(R.string.fin_del_juego);
		alertDialogBuilder.setMessage(R.string.mensaje_fin_del_juego);
		alertDialogBuilder.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						main.restartGame();
						main.dibujarTablero();
						dialog.dismiss();
					}
				});
		// Aqui debes colocar tu codigo

		alertDialogBuilder.setPositiveButton("No",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						main.finish();
						dialog.dismiss();
					}
				});
		
		return alertDialogBuilder.create();
	}
}