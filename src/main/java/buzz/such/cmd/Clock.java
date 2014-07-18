package buzz.such.cmd;

import java.lang.System;
import java.util.concurrent.TimeUnit;

public interface Clock {
    long nanoTime();

    long milliTime();

    default long time(TimeUnit unit) {
        if (TimeUnit.NANOSECONDS.equals(unit))
            return nanoTime();
        else if (TimeUnit.MICROSECONDS.equals(unit))
            return nanoTime() / 1000;
        else
            return TimeUnit.MILLISECONDS.convert(milliTime(), unit);
    }

    static class LocalSystem implements Clock {
        static final Clock INSTANCE = new LocalSystem();

        @Override
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override
        public long milliTime() {
            return System.currentTimeMillis();
        }
    }
}
