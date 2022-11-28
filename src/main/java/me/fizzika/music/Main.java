package me.fizzika.music;

import me.fizzika.music.filter.Filter;
import me.fizzika.music.filter.PeakReleaseFilter;
import me.fizzika.music.filter.VolumeFilter;
import me.fizzika.music.io.SoundWriter;
import me.fizzika.music.sound.Sound;
import me.fizzika.music.sound.builder.Track;
import me.fizzika.music.sound.impl.Note;
import me.fizzika.music.sound.impl.Silence;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Sound notes = notes(0.4).with(new VolumeFilter(0.3))
                .add(new Silence(1))
                .add(notes(0.5).with(new VolumeFilter(0.5)));

        SoundWriter writer = new SoundWriter(48000);
        writer.write(notes, "music/demo.pcm");
    }

    private static Sound notes(double noteDuration) {
        Filter notePressFilter = new PeakReleaseFilter(0.1, 0.9);
        return IntStream.range(-4, 4)
                .mapToObj(n -> new Note(noteDuration, n).with(notePressFilter))
                .reduce(new Track(), Track::add, Track::add);
    }

}
