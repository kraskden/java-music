package me.fizzika.music.sound.builder;

import me.fizzika.music.sound.Sound;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Track is a sound compositor
 */
public class Track implements Sound {

    private double duration = 0;
    private final NavigableMap<Double, Sound> sounds = new TreeMap<>();

    public Track() {}

    public Track(Sound... sounds) {
        for (Sound s : sounds) {
            add(s);
        }
    }

    public Track(Collection<? extends Sound> sounds) {
        sounds.forEach(this::add);
    }

    public Track add(Sound s) {
        sounds.put(duration, s);
        duration += s.duration();
        return this;
    }

    @Override
    public double duration() {
        return duration;
    }

    @Override
    public double sample(double position) {
        double trackTime = position * duration;
        Map.Entry<Double, Sound> child = sounds.floorEntry(trackTime);
        if (child == null) {
            throw new IllegalArgumentException("Position must be between 0 and 1");
        }
        Sound sound = child.getValue();
        double soundTime = trackTime - child.getKey();
        double soundPosition = soundTime / sound.duration();
        return sound.sample(soundPosition);
    }

}
