package me.fizzika.music.sound;

import me.fizzika.music.filter.Filter;
import me.fizzika.music.sound.builder.SoundFilterDecorator;
import me.fizzika.music.sound.builder.Track;

public interface Sound {
    double duration();
    double sample(double position);

    default Sound with(Filter filter) {
        return new SoundFilterDecorator(this, filter);
    }

    default Sound add(Sound sound) {
        if (sound instanceof Track) {
            return ((Track) sound).add(this);
        } else {
            return new Track(this, sound);
        }
    }

}
