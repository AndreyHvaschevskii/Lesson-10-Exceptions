package com.company;

import com.company.Entity.TextEntity;
import com.company.Exception.SerialNumberException;
import com.company.Interface.TextProcessable;
import com.company.Processors.ChainTextWorker;
import com.company.Processors.ReverseInformation;
import com.company.Processors.StubTextProcessable;
import com.company.Work.FileWorker;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String file = "yourFile.txt";
        FileOutputStream fileOutput = null;
        ObjectOutputStream outputStream = null;
        TextEntity[] texts = new TextEntity[]{new TextEntity( ), new TextEntity( ), new TextEntity( )};
        try {
            fileOutput = new FileOutputStream(file);
            outputStream = new ObjectOutputStream(fileOutput);
            outputStream.writeObject(texts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutput.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWorker fileWorker = new FileWorker();
        try {
            fileWorker.readeTextEntityStorage("yourFile.txt");
        } catch (SerialNumberException e) {
            e.printStackTrace();
        }

        System.out.println("Before sorting: " + Arrays.toString(texts));
        Arrays.sort(texts);
        System.out.println("After sorting: " + Arrays.toString(texts));
        String[] text = new String[texts.length];
        for (int i = 0; i < texts.length; i++) {
            text[i] = texts[i].getText();
        }

        ChainTextWorker worker = new ChainTextWorker(new TextProcessable[]{new StubTextProcessable(), new ReverseInformation()});
        String[] resultTExt = worker.processText(text);
        for (String s : resultTExt) {
            System.out.println(s);
        }
        FileWorker.writeTexts(resultTExt, "yourFile.txt");
    }
}
