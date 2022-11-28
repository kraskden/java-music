package me.fizzika.music.sound.impl;

import me.fizzika.music.sound.AbstractSound;

public class SineWave extends AbstractSound {

    private final double hz;

    public SineWave(double duration, double hz) {
        super(duration);
        this.hz = hz;
    }

    @Override
    public double sample(double position) {
        return Math.sin(hz * position * 2 * Math.PI);
    }

}
