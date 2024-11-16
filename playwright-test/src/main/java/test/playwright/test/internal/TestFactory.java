package test.playwright.test.internal;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class TestFactory {

    @Factory(dataProvider = "iteratorProvider", dataProviderClass = CommonDataProvider.class)
    public Object[] createInstance(Iterator<String[]> iterator) {
        String[] heading = iterator.next();
        return null; // TODO : Temp Fix
    }
}
