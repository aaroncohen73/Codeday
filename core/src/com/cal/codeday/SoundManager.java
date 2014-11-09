package com.cal.codeday;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

/**
 * Created by acohen on 11/8/14.
 */
public class SoundManager {

    private HashMap<String, Sound> soundFX = new HashMap<String, Sound>();

    public void addSound(String soundName){
        soundFX.put(soundName, Gdx.audio.newSound(Gdx.files.internal("sound/" + soundName)));
    }

    public void play(String soundName, float volume){
        soundFX.get(soundName).play(volume);
    }

}
