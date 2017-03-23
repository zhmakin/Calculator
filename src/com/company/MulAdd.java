package com.company;

import java.util.List;

/**
 * Created by Alex Green on 23.03.2017.
 */
public class MulAdd {
    public static int exec(List<Integer> args) {
        Integer result = args.get(0) + args.get(1);
        for (int i = 2; i < args.size(); i++) {
            result += args.get(i);
        }
        return result;
    }
}
