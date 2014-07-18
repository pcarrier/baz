package buzz.such.baz.cmd;

import buzz.such.baz.utils.Args;
import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.util.Random;

public class hex2ip implements Command {
    @Override
    public void run(Context ctx) throws Exception {
        Args.head("Required hexadecimal IPv4")
        final Random rnd = new Random();
        ctx.out().printf(MAC_FORMAT, 0x52,
                rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        ctx.close();
    }
}
