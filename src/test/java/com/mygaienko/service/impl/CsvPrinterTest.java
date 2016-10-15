package com.mygaienko.service.impl;

import com.mygaienko.model.AEntity;
import com.mygaienko.service.impl.printer.csv.AEntityCsvPrinter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doThrow;


/**
 * Created by enda1n on 14.10.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CsvPrinterTest {

    @Mock
    private PrintWriter writer;

    @Before
    public void init() throws IOException {
       doThrow(IOException.class).when(writer).print(anyString());
    }

    @Test
    public void test() throws Exception {
        AEntityCsvPrinter csvPrinter = new AEntityCsvPrinter();
        List<AEntity> entities = Arrays.asList(
                new AEntity("a11", "a22")
        );
        csvPrinter.print(writer, entities);
    }
}