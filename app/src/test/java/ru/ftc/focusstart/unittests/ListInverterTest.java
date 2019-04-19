package ru.ftc.focusstart.unittests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListInverterTest {

    private ListInverter listInverter;

    @Before
    public void setUp() {
        listInverter = new ListInverter();
    }

    @Test
    public void testInvertNormalList() {
        List<String> input = new ArrayList<>();
        input.add("qwe");
        input.add("asd");
        input.add("zxc");

        List<String> actualResult = listInverter.invertList(input);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("zxc");
        expectedResult.add("asd");
        expectedResult.add("qwe");
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvertNull() {
        listInverter.invertList(null);
    }

    @Test
    public void testInvertListWithNulls() {
        List<String> input = new ArrayList<>();
        input.add("qwe");
        input.add(null);
        input.add("zxc");

        List<String> actualResult = listInverter.invertList(input);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("zxc");
        expectedResult.add("qwe");
        assertEquals(expectedResult, actualResult);
    }
}