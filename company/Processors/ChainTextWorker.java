package com.company.Processors;

import com.company.Interface.TextProcessable;

public class ChainTextWorker {
    TextProcessable[] processes;

    public ChainTextWorker(TextProcessable[] processes) {
        this.processes = processes;
    }

    public String[] processText(String[] text) {
        StringBuilder stringBuilder = null;
        for (int i = 0; i < text.length; i++) {
            stringBuilder = new StringBuilder(text[i]);
            for (TextProcessable process : processes)
                try {
                    process.process(stringBuilder);
                    text[i] = stringBuilder.toString();
                } catch (UnsupportedOperationException e) {

                }
        }
        return text;
    }
}
