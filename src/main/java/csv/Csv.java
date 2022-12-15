package csv;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Csv {
    /*String[] header = new String[]{
            "Umsatz", "Soll-/Haben-Kennzeichen", "WKZ Umsatz", "Kurs", "Basisumsatz", "WKZ Basisumsatz", "Konto", "Gegenkonto", "BU-Schlüssel",
            "Belegdatum", "Belegfeld 1", "Belegdatum 2", "Skonto", "Buchungstext", "Postensperre", "Diverse Adressnummer",
            "Geschäftspartnerbank", "Sachverhalt", "Zinssperre", "Beleglink", "Beleginfo-Art 1", "Beleginfo-Inhalt 1", "Beleginfo-Art 2", "Beleginfo-Inhalt 2"
            , "Beleginfo-Art 3", "Beleginfo-Inhalt 3", "Beleginfo-Art 4", "Beleginfo-Inhalt 4", "Beleginfo-Art 5", "Beleginfo-Inhalt 5", "Beleginfo-Art 6", "Beleginfo-Inhalt 6"
            , "Beleginfo-Art 7", "Beleginfo-Inhalt 7", "Beleginfo-Art 8"
    };*/

    String[] info;
    String[] headertest;

    private CsvLine processCsvLine(String data) {
        System.out.println("-------------------------- Neue Zeile:");
        data += "\n";
        final StringTokenizer st = new StringTokenizer(data, ";");
        boolean containsForderungsverluste = false;

        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {

            tokens.add(st.nextToken());

        }


        CsvLine csvLine = new CsvLine();
        csvLine.setUmsatz(tokens.get(0));
        csvLine.setSollHabenKennzeichen(tokens.get(1));
        csvLine.setKonto(tokens.get(2));
        csvLine.setGegenkonto(tokens.get(3));
        csvLine.setBelegDatum(tokens.get(4));
        csvLine.setBelegfeld1(tokens.get(5));
        csvLine.setBuchungstext(tokens.get(6));
        csvLine.setBelefinfoInhalt3(tokens.get(11));
        /*csvLine.setBeleginfoArt1(tokens.get(7));
        csvLine.setBelefinfoInhalt1(tokens.get(8));
        csvLine.setBeleginfoArt2(tokens.get(9));
        csvLine.setBeleginfoArt3(tokens.get(10));

        csvLine.setBeleginfoArt5(tokens.get(12));
        csvLine.setBeleginfoArt6(tokens.get(13));
        csvLine.setBeleginfoArt7(tokens.get(14));
        csvLine.setBeleginfoArt7(tokens.get(15));*/

        return csvLine;
    }

    private String[] processCsvLineAsString(String current) {
        StringTokenizer st = new StringTokenizer(current, ";");
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());

        }
        String[] array = new String[tokens.size()];
        for (int j = 0; j < tokens.size(); j++) {
            array[j] = tokens.get(j);


        }

        return array;
    }

    /**
     * Lese CSV Datei und verarbeite zeilenweise.
     */
    public List<CsvLine> parseCsvFile(final String fileName) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String current = reader.readLine();
        List<CsvLine> csvLines = new ArrayList<>();
        int i = 0;
        while (current != null) {
            if (i > 1) {
                csvLines.add(processCsvLine(current));
                current = reader.readLine();
            } else if (i == 0) {
                info = processCsvLineAsString(current);
                current = reader.readLine();
                i += 1;
            } else if (i == 1) {
                headertest = processCsvLineAsString(current);
                current = reader.readLine();
                i += 1;
            }

        }
        reader.close();
        return csvLines;
    }

    public void adjustCsvFile(List<CsvLine> list) {
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getSollHabenKennzeichen().contains("S")) {
                list.get(i).setGegenkonto("8400");
                String newString = list.get(i).getBelefinfoInhalt3().replace("\"", "");
                list.get(i).setBelegfeld1(list.get(i).getBelegfeld1() + " " + newString);
            }
            if (list.get(i).getKonto().equals("1203")) {
                list.set(i, null);
            } else {
                list.get(i).setGegenkonto("1590");
                String newString = list.get(i).getBelefinfoInhalt3().replace("\"", "");
                list.get(i).setBelegfeld1(list.get(i).getBelegfeld1() + " " + newString);
            }

        }
    }

    public void writeCsvDataAtOnce(List<String[]> list, String filePath) {
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            //writer.writeNext(header);
            writer.writeNext(info);
            writer.writeNext(headertest);
            for (int i = 0; i < list.size(); i++) {
                writer.writeNext(list.get(i));
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> toList(List<CsvLine> list) {
        List<String[]> stringList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                String[] array = new String[]{
                        list.get(i).getUmsatz(),
                        list.get(i).getSollHabenKennzeichen(),
                        list.get(i).getWkzUmsatz(),
                        list.get(i).getKurs(),
                        list.get(i).getBasisumsatz(),
                        list.get(i).getWkzBasisumsatz(),
                        list.get(i).getKonto(),
                        list.get(i).getGegenkonto(),
                        list.get(i).getBuSchlüssel(),
                        list.get(i).getBelegDatum(),
                        list.get(i).getBelegfeld1(),
                        list.get(i).getBelegfeld2(),
                        list.get(i).getSkonto(),
                        list.get(i).getBuchungstext(),
                };
                stringList.add(array);
            }

        }
        return stringList;
    }

}
