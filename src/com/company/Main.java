package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int result;
        switch (args[0]) {
            case "-":
                result = Choose((new Scanner(System.in)).next().split(" "));
                break;
            default:
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                result = Choose(reader.readLine().split(" "));
                break;
        }

        switch (args[1]) {
            case "-":
                System.out.println("Результат: " + result);
                break;
            default:
                WriteFile(args[1], ((Integer) result).toString());
                break;
        }
    }

    private static int Choose(String[] param) {
        int result = 0;
        List<Integer> arguments = new ArrayList<>();
        for (int i = 1; i < param.length; i++) {
            arguments.add(Integer.parseInt(param[i]));
        }
        switch (param[0]) {
            case "ADD":
                result = Add.exec(arguments);
                break;
            case "MUL":
                result = Mul.exec(arguments);
                break;
            case "MDD":
                result = MulAdd.exec(arguments);
                break;
            default:
                System.out.println("Something went wrong!");
                break;
        }
        return result;
    }

    private static void WriteFile(String fileName, String text) {
        File file = new File(fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
