package me.fizzika.music.sound.builder;

import me.fizzika.music.filter.Filter;
import me.fizzika.music.sound.Sound;

public class SoundFilterDecorator implements Sound {

    private final Sound sound;
    private final Filter filter;

    public SoundFilterDecorator(Sound sound, Filter filter) {
        this.sound = sound;
        this.filter = filter;
    }

    @Override
    public double duration() {
        return sound.duration();
    }

    @Override
    public double sample(double position) {
        return filter.transform(sound.sample(position), position);
    }

}
