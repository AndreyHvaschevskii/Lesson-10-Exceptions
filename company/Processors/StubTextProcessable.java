package com.company.Processors;

import com.company.Interface.TextProcessable;

public class StubTextProcessable implements TextProcessable {

    @Override
    public void process(StringBuilder strB) {
        throw new UnsupportedOperationException("deprecated method");
    }
}
