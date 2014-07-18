package buzz.such.cmd;

import lombok.RequiredArgsConstructor;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;

public interface Context extends Closeable {
    String[] args();

    Map<String, String> env();

    String env(String name);

    Clock clock();

    InputStream in();

    PrintStream out();

    PrintStream err();

    PrintStream log();

    void fail();

    default void fail(Throwable t) {
        t.printStackTrace(err());
        fail();
    }

    @RequiredArgsConstructor
    static class LocalSystem implements Context {
        private final String[] args;

        @Override
        public String[] args() {
            return args;
        }

        @Override
        public Map<String, String> env() {
            return System.getenv();
        }

        @Override
        public String env(String name) {
            return System.getenv(name);
        }

        @Override
        public Clock clock() {
            return Clock.LocalSystem.INSTANCE;
        }

        @Override
        public InputStream in() {
            return System.in;
        }

        @Override
        public PrintStream out() {
            return System.out;
        }

        @Override
        public PrintStream err() {
            return System.err;
        }

        @Override
        public PrintStream log() {
            return System.err;
        }

        @Override
        public void fail() {
            System.exit(1);
        }

        @Override
        public void close() throws IOException {
            System.exit(0);
        }
    }
}
