package ru.ftc.focusstart.unittests;

import java.util.ArrayList;
import java.util.List;

public class ListInverter {

    public List<String> invertList(List<String> input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
        List<String> output = new ArrayList<>();
        for (int i = input.size() - 1; i >= 0; --i) {
            String value = input.get(i);
            if (value != null) {
                output.add(value);
            }
        }
        return output;
    }
}
