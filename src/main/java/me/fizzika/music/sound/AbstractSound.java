package me.fizzika.music.sound;

public abstract class AbstractSound implements Sound {
    protected final double duration;

    protected AbstractSound(double duration) {
        this.duration = duration;
    }

    @Override
    public double duration() {
        return duration;
    }

}
