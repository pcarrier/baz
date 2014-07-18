package buzz.such.baz.cmd;

import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.io.IOException;
import java.io.PrintStream;

public class echo implements Command {
    @Override
    public void run(Context ctx) throws IOException {
        ctx.out().println(String.join(" ", ctx.args()));
        ctx.close();
    }
}
