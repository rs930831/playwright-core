package test.playwright.test.internal;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

@Test //(dataProvider = "iteratorProvider", dataProviderClass = CommonDataProvider.class)
public class Test1 {

    public final String[] currentLine;

    public static ConcurrentMap<Integer, String> concurrentMap = (ConcurrentMap<Integer, String>) new HashMap<Integer, String>();

    public Test1(String[] currentLine) {
        this.currentLine = currentLine;
    }

    public void test1(ITestContext context) {
        List<String> currentList = Arrays.asList(this.currentLine);
        System.out.println(currentList);
    }


}
