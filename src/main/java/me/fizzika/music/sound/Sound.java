package me.fizzika.music.sound;

import me.fizzika.music.filter.Filter;
import me.fizzika.music.sound.builder.SoundFilterDecorator;

public interface Sound {
    double duration();
    double sample(double position);

    default Sound with(Filter filter) {
        return new SoundFilterDecorator(this, filter);
    }

}
