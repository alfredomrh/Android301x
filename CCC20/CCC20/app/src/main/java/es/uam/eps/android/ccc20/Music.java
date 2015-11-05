package es.uam.eps.android.ccc20;

import android.content.Context;
import android.media.MediaPlayer;

//clase que implementa dos metodos estaticos para reproducir musica en nuestra app

public class Music {

    private static MediaPlayer player; //instancia un objeto estatico de la clase mediaplayer

    //metodo que reproduce un fichero de audio cuyo id recibe como parametro junto al contexto
    public static void play (Context context, int id){
		player = MediaPlayer.create(context, id); //crea el reproductor
		player.setLooping(true); //lo reproduce mientras true
		player.start(); //comienza a reproducir
    }

    //metodo estatico que para la musica
    public static void stop (Context context){
		if(player != null){ //si existe el reproductor
           player.stop(); //lo para
           player.release(); //libera recursos
           player = null;	//y lo inicializa a null
		}	
    }
}

