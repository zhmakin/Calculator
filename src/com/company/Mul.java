package com.company;

import java.util.List;

/**
 * Created by Alex Green on 23.03.2017.
 */
public class Mul {
    public static int exec(List<Integer> args) {
        Integer result = new Integer(1);
        for (int p : args) {
            result *= p;
        }
        return result;
    }
}
