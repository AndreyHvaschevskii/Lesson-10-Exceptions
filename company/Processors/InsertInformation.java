package com.company.Processors;

import com.company.Interface.TextProcessable;

public class InsertInformation implements TextProcessable {
    int index;
    String str;

    public InsertInformation(int index, String str) {
        this.index=index;
        this.str=str;
    }

    @Override
    public void process(StringBuilder strB) {
        strB.insert(index,str);
    }
}
