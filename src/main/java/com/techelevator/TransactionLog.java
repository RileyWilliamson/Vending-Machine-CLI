package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionLog {
    private String fileName = "log.txt";
    private boolean deleteFile = new File(fileName).delete();
    private File logFile = new File(fileName);


    //Constructor
    public TransactionLog() {

        fileGenerator();
    }
    //Methods

    //Generate a log file
    public File fileGenerator() {
        try {
            //Creates a new file called "log.txt"
            logFile.createNewFile();
        } catch (IOException e) {
        }
        return logFile;
    }

    //Gets the current time and puts it into a string called "date"
    public String getCurrentTime() {
        String date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
        return date;
    }

    //Logs each event
    public String logEvent(String event, String balanceBeforeTransaction, String afterTransaction) {
        //Formats a string to print out like "____|______|_____|_____"
        String logString = String.format("%-24s %-22s %-14s %-14s", getCurrentTime(), event, balanceBeforeTransaction,
                afterTransaction);
        //Adds a line between each log? ***********
        try (Writer fileWriter = new FileWriter(logFile, true);
             BufferedWriter buffered = new BufferedWriter(fileWriter)) {
            buffered.write(logString + "\n");
        } catch (IOException e1) {
        }
        return logString;
    }
}