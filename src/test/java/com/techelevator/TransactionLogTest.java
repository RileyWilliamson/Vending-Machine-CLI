package com.techelevator.view;

import com.techelevator.TransactionLog;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TransactionLogTest extends TransactionLog{

    //Arrange
    //Act
    //Assert

    @Test
    public void does_log_file_get_generated() {
        TransactionLog transactionLog = new TransactionLog();

        File expected = new File("log.txt");
        File actual = transactionLog.fileGenerator();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void correct_time_test() {
        TransactionLog transactionLog = new TransactionLog();

        String TestDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
        String expected = TestDate;
        String actual = transactionLog.getCurrentTime();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void does_it_log_correctly() throws FileNotFoundException {
        TransactionLog transactionLog = new TransactionLog();
        String fileName = "log.txt";
        File logFile = new File(fileName);

        Scanner fileScanner = new Scanner(logFile);

        String testLogString = String.format("%-24s %-22s %-14s %-14s",transactionLog.getCurrentTime(),"FEED MONEY:", 10.00, 6.95);
        String expected = testLogString;
        String actual = transactionLog.logEvent("FEED MONEY:", "10.0","6.95");

        Assert.assertEquals(expected, actual);
    }

}
