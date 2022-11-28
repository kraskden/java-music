package me.fizzika.music;

import me.fizzika.music.io.SoundWriter;
import me.fizzika.music.sound.Sound;
import me.fizzika.music.sound.impl.SineWave;

public class Main {
    public static void main(String[] args) {
        Sound sineWave = new SineWave(1, 440.0);
        SoundWriter writer = new SoundWriter(48000);
        writer.write(sineWave, "test.pcm");
    }
}
