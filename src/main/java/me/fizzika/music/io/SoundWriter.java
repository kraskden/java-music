package me.fizzika.music.io;

import me.fizzika.music.sound.Sound;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SoundWriter {

    private final double samplesPerSecond;

    public SoundWriter(long samplesPerSecond) {
        this.samplesPerSecond = samplesPerSecond;
    }

    public void write(Sound sound, String path) {
        try (var os = new DataOutputStream(new FileOutputStream(path))) {
            double duration = sound.duration();
            long totalSamples = (long) Math.floor(duration * samplesPerSecond);
            for (long sample = 0; sample < totalSamples; ++sample) {
                os.writeDouble(sound.sample(1.0 * sample / totalSamples));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
