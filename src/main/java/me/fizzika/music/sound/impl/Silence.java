package me.fizzika.music.sound.impl;

import me.fizzika.music.sound.AbstractSound;

public class Silence extends AbstractSound {

    protected Silence(double duration) {
        super(duration);
    }

    @Override
    public double sample(double position) {
        return 0;
    }

}
