package me.fizzika.music.sound.impl;

public class Note extends SineWave {

    private static final double PITCH_STANDARD = 440.0;
    private static final double NOTE_BASE = Math.pow(2, 1.0 / 12);

    // https://pages.mtu.edu/~suits/NoteFreqCalcs.html
    public Note(double duration, int note) {
        super(duration, PITCH_STANDARD * Math.pow(NOTE_BASE, note));
    }

}
