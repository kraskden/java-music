package me.fizzika.music.filter;

public class VolumeFilter implements Filter {
    private final double volume;

    public VolumeFilter(double volume) {
        this.volume = volume;
    }

    @Override
    public double transform(double sample, double time) {
        return volume * sample;
    }

}
