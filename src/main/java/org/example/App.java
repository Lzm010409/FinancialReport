package org.example;

import csv.Csv;
import csv.CsvLine;
import entity.ExportDatev;
import restfulapi.requests.Request;
import restfulapi.requests.builder.JsonBuilder;
import restfulapi.requests.url.Token;
import restfulapi.requests.url.URL;
import restfulapi.requests.url.UrlBuilder;
import time.TimeStampGenerator;
import zip.Zip;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.zip.*;


public class App {


    public static void main(String[] args) throws IOException {
        TimeStampGenerator timeStampGenerator = new TimeStampGenerator();

        ExportDatev exportDatev = new ExportDatev(timeStampGenerator.generateTimestamp(2022, 12, 1), timeStampGenerator.generateTimestamp(2022, 12, 12), "T");
        System.out.println(new JsonBuilder().build(exportDatev));
        Token token = new Token();
        token.setToken("");
        Request request = new Request();
        String output = request.httpGet(new JsonBuilder().build(exportDatev), new UrlBuilder().buildUrl(URL.GETDATEVEXPORT), token.getToken()).replace("{\"objects\":", "");
        String newOutput = output.replace("}}", "}");
        ExportDatev exportDatev1 = (ExportDatev) new JsonBuilder().deserializeExportDatev(newOutput);
        Zip zip = new Zip();
        zip.unzipFile(exportDatev1.getContent(), "/Users/lukegollenstede/Desktop/TEST");
        File f = new File("/Users/lukegollenstede/Desktop/TEST");
        File[] fileArray = f.listFiles();
        String filePath = "";
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].getName().contains("Buchungsstapel")) {
                filePath = fileArray[i].getAbsolutePath();
            }
        }
        Csv csv = new Csv();
        List<CsvLine> csvLines = csv.parseCsvFile(filePath);
        csv.adjustCsvFile(csvLines);
        csv.writeCsvDataAtOnce(csv.toList(csvLines), "/Users/lukegollenstede/Desktop/TEST/test.csv");
    }
}
