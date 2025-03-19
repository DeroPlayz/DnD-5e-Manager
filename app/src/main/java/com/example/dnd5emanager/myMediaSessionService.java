package com.example.dnd5emanager;

import android.media.session.MediaSession;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.session.MediaSessionService;
import androidx.media3.exoplayer.ExoPlayer;
import android.os.Binder;

import android.content.Intent;

public class myMediaSessionService extends MediaSessionService {
    private MediaSession mediaSession;
    private ExoPlayer player;

    public void onCreate() {
        super.onCreate();
        player= new ExoPlayer.Builder(this).build();
        MediaItem mediaItem = MediaItem.fromUri("android.resource://" + getPackageName()+"/"+R.raw.background);
        player.setMediaItem(mediaItem);
        player.setRepeatMode(Player.REPEAT_MODE_ALL);
        player.prepare();
        player.play();

        }

    @Nullable
    @Override
    public androidx.media3.session.MediaSession onGetSession(androidx.media3.session.MediaSession.ControllerInfo controllerInfo) {
        return null;
    }


    public MediaSession onGetSession() {
    return mediaSession;
}

@Override
public void onDestroy() {
        if (player.isPlaying())
        {
            player.stop();
        }
        player.release();
        mediaSession.release();
        super.onDestroy();
    }
    @Override
    public android.os.Binder onBind(Intent intent){
        super.onBind(intent);
        return null;
    }
}

