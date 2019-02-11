package de.kibr.jsf.engine.counter;

import de.kibr.jsf.engine.Emitter;
import de.kibr.jsf.util.Span;

public class TriggerCounter extends BaseCounter {
    private final Span<Integer> count;
    private boolean triggered = false;

    public TriggerCounter(Span<Integer> count) {
        this.count = count;
    }

    @Override
    public int update(Emitter emitter) {
        if (triggered) {
            triggered = false;
            return count.getValue();
        }
        return 0;
    }

    public void trigger() {
        triggered = true;
    }
}
