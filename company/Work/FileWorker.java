package com.company.Work;

import com.company.Exception.SerialNumberException;
import com.company.Entity.TextEntity;
import com.company.Entity.TextEntityStorage;

import java.io.*;

public class FileWorker {
    public TextEntityStorage readeTextEntityStorage(String fileName) throws SerialNumberException {
        TextEntity[] loadedObject = null;
        try (FileInputStream fiStream = new FileInputStream(fileName);
             ObjectInputStream objectStream = new ObjectInputStream(fiStream)) {
            loadedObject = (TextEntity[]) objectStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (TextEntity textEntity : loadedObject) {
            if (textEntity.getSerialNumber() < 0) {
                throw new SerialNumberException("Error");
            }
        }
        return new TextEntityStorage();
    }

    public static void writeTexts(String[] texts, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String text : texts) {
                writer.write(text + " ");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


