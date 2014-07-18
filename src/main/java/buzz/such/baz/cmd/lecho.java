package buzz.such.baz.cmd;

import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.io.IOException;
import java.io.PrintStream;

public class lecho implements Command {
    @Override
    public void run(Context ctx) throws IOException {
        final PrintStream out = ctx.out();
        for (String arg : ctx.args())
            out.println(arg);
        ctx.close();
    }
}
