package com.company.Processors;

import com.company.Interface.TextProcessable;

public class ReverseInformation implements TextProcessable {

    public ReverseInformation() {
    }

    @Override
    public void process(StringBuilder strB) {
        strB.reverse().toString();
    }
}
