package buzz.such.baz.cmd;

import buzz.such.baz.utils.Args;
import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.io.IOException;
import java.util.Arrays;

public class secho implements Command {
    @Override
    public void run(Context ctx) throws IOException {
        final String[] args = ctx.args();
        ctx.out().println(String.join(Args.head(args, "Separator required"), Args.tail(args)));
        ctx.close();
    }
}
