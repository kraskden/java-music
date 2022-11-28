package me.fizzika.music.filter;

public class PeakReleaseFilter implements Filter {

    private final double peakPercent;
    private final double releasePercent;

    public PeakReleaseFilter(double peakPercent, double releasePercent) {
        this.peakPercent = peakPercent;
        this.releasePercent = releasePercent;
    }

    @Override
    public double transform(double sample, double time) {
        if (time < peakPercent) {
            return (time / peakPercent) * sample;
        } else if (time > releasePercent) {
            return ((1 - time) / (1 - releasePercent)) * sample;
        } else {
            return sample;
        }
    }

}
