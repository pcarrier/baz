package buzz.such.baz.cmd;

import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;

// TODO(pierre): file input, reverse
public class suc implements Command {
    @Override
    public void run(Context ctx) throws Exception {
        final HashMap<String, Long> lineCounts = new HashMap<>();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(ctx.in()))) {
            String line;
            while ((line = reader.readLine()) != null)
                lineCounts.put(line, lineCounts.getOrDefault(line, 0L) + 1L);
        }

        final PrintStream out = ctx.out();

        lineCounts.entrySet().stream().sorted((a, b) -> {
            final int valCmp = Long.compare(a.getValue(), b.getValue());
            return valCmp == 0 ? a.getKey().compareTo(b.getKey()) : valCmp;
        }).forEachOrdered((entry) ->
                out.printf("%7d %s\n", entry.getValue(), entry.getKey()));
        ctx.close();
    }
}
