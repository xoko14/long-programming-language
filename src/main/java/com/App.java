package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App 
{
    private static ArrayList<String> code;
    public static void main( String[] args ) throws IOException
    {
        code = new ArrayList<>();
        File file = new File(args[0]); 
		  
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		while ((st = br.readLine()) != null) 
		{
            st = st.replaceAll("\t", "");
            while(st.substring(0, 1).equals(" ")) st = st.substring(1);
			code.add(st);
		}

        printAll();
    }

    private static void printAll(){
        for (String line : code) {
            System.out.println(line);
        }
    }
}
