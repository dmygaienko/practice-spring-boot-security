package com.mygaienko.service.impl.printer.csv;

import com.mygaienko.service.Printer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by enda1n on 16.10.2016.
 */
abstract class AbstractCsvPrinter<T> implements Printer<T> {

    @Override
    public void print(ServletOutputStream outputStream, List<T> entities) throws IOException {
        try (
                PrintWriter printWriter = new PrintWriter(outputStream);
                CSVPrinter csvPrinter = new CSVPrinter(printWriter, CSVFormat.DEFAULT.withRecordSeparator("\n"))) {

            printEntities(csvPrinter, entities);
        }
    }

    protected abstract void printEntities(CSVPrinter csvPrinter, List<T> entities);
}
