package com.company.Processors;

import com.company.Interface.TextProcessable;

public class AppendInformation implements TextProcessable {
    Object endObject;

    public AppendInformation(Object endObject) {
        this.endObject = endObject;
    }

    @Override
    public void process(StringBuilder strB) {
        strB.append(endObject);
    }

}
