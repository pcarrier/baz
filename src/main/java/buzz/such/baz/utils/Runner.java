package buzz.such.baz.utils;

import buzz.such.cmd.Command;
import buzz.such.cmd.Context;

public class Runner {
    public static void main(String... args) throws Exception {
        getCommand(Args.head(args, "Command required")).run(new Context.LocalSystem(Args.tail(args)));
    }

    private static Command getCommand(String name) throws ReflectiveOperationException {
        return Class.forName("buzz.such.baz.cmd." + name).asSubclass(Command.class).newInstance();
    }
}
