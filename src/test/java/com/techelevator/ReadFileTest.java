package com.techelevator.view;

import com.techelevator.ReadFile;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {

    @Test
    public void does_it_get_the_lines_correctly(){

        ReadFile readFile = new ReadFile();
        List<String> listOfTestInputFileLines = new ArrayList<String>();

        listOfTestInputFileLines.add("A1|Potato Crisps|3.05|Chip");
        listOfTestInputFileLines.add("A2|Stackers|1.45|Chip");
        listOfTestInputFileLines.add("A3|Grain Waves|2.75|Chip");
        listOfTestInputFileLines.add("A4|Cloud Popcorn|3.65|Chip");
        listOfTestInputFileLines.add("B1|Moonpie|1.80|Candy");
        listOfTestInputFileLines.add("B2|Cowtales|1.50|Candy");
        listOfTestInputFileLines.add("B3|Wonka Bar|1.50|Candy");
        listOfTestInputFileLines.add("B4|Crunchie|1.75|Candy");
        listOfTestInputFileLines.add("C1|Cola|1.25|Drink");
        listOfTestInputFileLines.add("C2|Dr. Salt|1.50|Drink");
        listOfTestInputFileLines.add("C3|Mountain Melter|1.50|Drink");
        listOfTestInputFileLines.add("C4|Heavy|1.50|Drink");
        listOfTestInputFileLines.add("D1|U-Chews|0.85|Gum");
        listOfTestInputFileLines.add("D2|Little League Chew|0.95|Gum");
        listOfTestInputFileLines.add("D3|Chiclets|0.75|Gum");
        listOfTestInputFileLines.add("D4|Triplemint|0.75|Gum");


        List<String> expected =listOfTestInputFileLines;
        List<String> actual = ReadFile.getListOfAllLines();

        Assert.assertEquals(expected,actual);
    }
}
