package com.company.Entity;

import java.io.Serializable;

public class TextEntityStorage implements Serializable {
    TextEntity[] texts;

    public TextEntity[] getTexts() {
        return texts;
    }

    public void setTexts(TextEntity[] texts) {
        this.texts = texts;
    }

    public static void sort(TextEntity[] texts) {
    }
}

