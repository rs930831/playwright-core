package test.playwright.util.common;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class CsvUtil {


    private static CSVReader getCsvReader(final String filePath) throws IOException {
        return new CSVReader(new FileReader(filePath));
    }

    public static Iterator<String[]> getCsvIterator(final String filePath) throws IOException {
        CSVReader reader = getCsvReader(filePath);
        return reader.iterator();
    }

    private static void test(final String filePath) throws IOException, CsvValidationException {
        CSVReader reader = getCsvReader(filePath);
        Iterator<String[]> itr = reader.iterator();
        itr.next();

//        System.out.println(Arrays.stream(reader.peek()).collect(Collectors.toList()));
//        System.out.println("Lines Read " + reader.getLinesRead());
//        System.out.println("Multi Line Limit " + reader.getMultilineLimit());
//        System.out.println();
        System.out.println();
        System.out.println();
        for(int i=0; i < 5; i++) {
            boolean breakLoop = false;
            if(itr.hasNext()) {
                Arrays.stream(itr.next()).forEach(val -> System.out.print(val + ","));
                System.out.println();
            } else {
                breakLoop = true;
            }
            if (breakLoop) {
                break;
            }
        }

    }

    public static String[] getCsvData(final Iterator<String[]> iterator) {
        return iterator.next();
    }


    public static void main(String[] args) throws IOException, CsvValidationException {
        test("C:\\Users\\rajshekhar.salimath\\Documents\\employee.csv");
        System.out.println();
        System.out.println();
        System.out.println();
//        final Iterator<String[]> csvIterator = getCsvIterator("C:\\Users\\rajshekhar.salimath\\Documents\\employee.csv");
//        csvIterator.next();
//        csvIterator.remove();

//        for(int i=0; i < 5; i++) {
//            boolean breakLoop = false;
//            if(csvIterator.hasNext()) {
//                Arrays.stream(csvIterator.next()).forEach(val -> System.out.print(val + ","));
//                System.out.println();
//            } else {
//                breakLoop = true;
//            }
//            if (breakLoop) {
//                break;
//            }
//        }

    }
}
