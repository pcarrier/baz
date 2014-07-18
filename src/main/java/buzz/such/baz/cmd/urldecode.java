package buzz.such.baz.cmd;

import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.net.URLDecoder;
import java.net.URLEncoder;

// TODO(pierre): repeats
public class urldecode implements Command {
    @Override
    public void run(Context ctx) throws Exception {
        ctx.out().println(URLDecoder.decode(String.join(" ", ctx.args()), "UTF-8"));
        ctx.close();
    }
}
