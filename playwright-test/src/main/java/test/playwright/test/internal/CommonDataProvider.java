package test.playwright.test.internal;

import org.testng.annotations.DataProvider;
import test.playwright.util.common.CsvUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonDataProvider {

    @DataProvider(name = "iteratorProvider")
    public Iterator<String[]> testDataProvider() throws IOException {
        Iterator<String[]> iterator = CsvUtil.getCsvIterator("C:\\Users\\rajshekhar.salimath\\Documents\\employee.csv");
        return iterator;


    }

}
