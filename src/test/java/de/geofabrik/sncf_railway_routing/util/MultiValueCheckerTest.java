package de.geofabrik.sncf_railway_routing.util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MultiValueCheckerTest {

    private ArrayList<Integer> permittedInt;
    private ArrayList<Double> permittedDouble;
    private String tagValue;

    @Before
    public void setUp() {
        permittedInt = new ArrayList<Integer>();
        permittedDouble = new ArrayList<Double>();
    }

    @Test
    public void testTagContainsInt() {
        tagValue = "1435;1000";
        permittedInt.add(1435);
        ArrayList<Integer> permitted2 = new ArrayList<Integer>();
        permitted2.add(762);
        assertTrue(MultiValueChecker.tagContainsInt(tagValue, permittedInt, true));
        assertFalse(MultiValueChecker.tagContainsInt(tagValue, permitted2, true));
    }

    @Test
    public void testTagContainsIntNotSet() {
        tagValue = null;
        permittedInt.add(1435);
        assertTrue(MultiValueChecker.tagContainsInt(tagValue, permittedInt, true));
        assertFalse(MultiValueChecker.tagContainsInt(tagValue, permittedInt, false));
    }

    @Test
    public void testTagContainsIntEmtpyValue() {
        tagValue = "";
        permittedInt.add(1435);
        assertTrue(MultiValueChecker.tagContainsInt(tagValue, permittedInt, true));
        assertFalse(MultiValueChecker.tagContainsInt(tagValue, permittedInt, false));
    }

    @Test
    public void testTagContainsDouble() {
        tagValue = "16.7;50";
        permittedDouble.add(16.7);
        ArrayList<Double> permitted2 = new ArrayList<Double>();
        permitted2.add(25.0);
        assertTrue(MultiValueChecker.tagContainsDouble(tagValue, permittedDouble, true));
        assertFalse(MultiValueChecker.tagContainsDouble(tagValue, permitted2, true));
    }

    @Test
    public void testTagContainsDoubleNotSet() {
        tagValue = null;
        permittedDouble.add(16.7);
        assertTrue(MultiValueChecker.tagContainsDouble(tagValue, permittedDouble, true));
        assertFalse(MultiValueChecker.tagContainsDouble(tagValue, permittedDouble, false));
    }

    @Test
    public void testTagContainsDoubleEmtpyValue() {
        tagValue = "";
        permittedDouble.add(16.7);
        assertTrue(MultiValueChecker.tagContainsDouble(tagValue, permittedDouble, true));
        assertFalse(MultiValueChecker.tagContainsDouble(tagValue, permittedDouble, false));
    }

}
