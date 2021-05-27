package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private static ArrayList<String> code;
    private static ArrayList<Variable> variables;

    public static void main(String[] args) throws IOException {
        code = new ArrayList<>();
        variables = new ArrayList<>();
        File file = new File(args[0]);

        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            st = st.replaceAll("\t", "");
            while (st.substring(0, 1).equals(" "))
                st = st.substring(1);
            code.add(st);
        }

        interpreter();
    }

    private static void printAll() {
        for (String line : code) {
            System.out.println(line);
        }
    }

    private static void interpreter() {
        String line;
        for (int i = 0; i < code.size(); i++) {
            line = code.get(i);
            translateLine(splitLine(line));
        }
    }

    private static void translateLine(String[] line) {
        switch (line[0].length()) {
            case 1:
                if(line[1].contains("\"") || line[1].contains("'")) System.out.println(trimString(line[1]));
                else if(variables.contains(Variable.fromId(line[1].length())))
                    System.out.println(variables.get(variables.indexOf(Variable.fromId(line[1].length()))).val);
                else {
                    System.out.println("variable not initialized :(");
                    System.exit(0);
                }
                break;
            case 2:
                variables.add(new Variable(line[1].length(), trimString(line[2])));
        }
    }

    private static String[] splitLine(String line) {
        String[] toReturn;
        ArrayList<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");
        Matcher regexMatcher = regex.matcher(line);
        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }
        toReturn = new String[matchList.size()];
        matchList.toArray(toReturn);
        return toReturn;
    }

    private static String trimString(String str){
        return str.substring(1, str.length()-1);
    }
}