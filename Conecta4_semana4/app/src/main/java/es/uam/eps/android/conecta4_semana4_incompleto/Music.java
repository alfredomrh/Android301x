package es.uam.eps.android.conecta4_semana4_incompleto;

import android.content.Context;
import android.media.MediaPlayer;

public class Music { //clase para reproducir un audio o pararlo

    private static MediaPlayer player;

    public static void play (Context context, int id){ //reproduce el audio indicado mediante el id
        player = MediaPlayer.create(context, id);
        player.setLooping(true);
        player.start();
    }
    public static void stop (Context context){ //para el audio
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
}