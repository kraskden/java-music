# Java-Music

The program generate raw PCM sound (64 bit, big endian)

This project was created under the huge impression of ["Making Music with Haskell From Scratch"](https://www.youtube.com/watch?v=FYTZkE5BZ-0) video.

As opposed to the @tsoding video with pure-functional approach, this project has been made (mostly) in OOP way.

##  Generate PCM sound

```java
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
```
## Play

`./play.sh PATH_TO_PCM`