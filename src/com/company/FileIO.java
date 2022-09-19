package com.company;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

    public static ArrayList<String> readFile (String filePath) throws IOException {
        ArrayList<String> data;

        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);
        data = new ArrayList<>();

        String line;
        while ((line=reader.readLine())!=null) {
            data.add(line);
        }
        reader.close();
        return data;
    }
    public static void fileOutput (String fp, ArrayList<String> data) throws IOException {
        FileWriter fileWriter = new FileWriter(fp+"(sort)");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (String str : data) {
            writer.write(str + "\n");
        }
        writer.close();
    }
}
