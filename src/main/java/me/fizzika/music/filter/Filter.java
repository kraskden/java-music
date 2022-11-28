package me.fizzika.music.filter;

@FunctionalInterface
public interface Filter {
    double transform(double sample, double time);

    default Filter and(Filter other) {
        return (s, t) -> other.transform(this.transform(s, t), t);
    }

    static Filter chain(Filter... filters) {
        return (s, t) -> {
            for (Filter f : filters) {
                s = f.transform(s, t);
            }
            return s;
        };
    }

}
