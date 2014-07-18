package buzz.such.baz.cmd;

import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.util.Random;

// TODO(pierre): lowercase vs uppercase
public class randmac implements Command {
    public static final String MAC_FORMAT = "%02x:%02x:%02x:%02x:%02x:%02x\n";

    @Override
    public void run(Context ctx) throws Exception {
        final Random rnd = new Random();
        ctx.out().printf(MAC_FORMAT, 0x52,
                rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        ctx.close();
    }
}
