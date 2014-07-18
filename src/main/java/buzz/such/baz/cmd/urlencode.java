package buzz.such.baz.cmd;

import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// TODO(pierre): repeats
public class urlencode implements Command {
    @Override
    public void run(Context ctx) throws Exception {
        ctx.out().println(URLEncoder.encode(String.join(" ", ctx.args()), "UTF-8"));
        ctx.close();
    }
}
