package buzz.such.baz.utils;

import java.util.Arrays;

public class Args {
    public static String head(String[] args, String failureMsg) {
        if (args.length == 0)
            throw new IllegalArgumentException(failureMsg);
        return args[0];
    }

    public static String[] tail(String[] args) {
        return Arrays.copyOfRange(args, 1, args.length);
    }
}
