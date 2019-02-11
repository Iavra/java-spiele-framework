package de.kibr.jsf.engine.counter;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.util.Span;

public class IntervalCounter extends BaseCounter {
    private final Span<Integer> count;
    private final Span<Integer> interval;
    private int timer;

    public IntervalCounter(Span<Integer> count, Span<Integer> interval) {
        this.count = count;
        this.interval = interval;
        initTimer();
    }

    private void initTimer() {
        timer = interval.getValue();
    }

    @Override
    public int update(Emitter emitter) {
        if (--timer <= 0) {
            initTimer();
            return count.getValue();
        }
        return 0;
    }
}
