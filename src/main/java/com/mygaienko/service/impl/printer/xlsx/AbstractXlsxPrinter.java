package com.mygaienko.service.impl.printer.xlsx;

import com.mygaienko.service.Printer;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by enda1n on 16.10.2016.
 */
abstract class AbstractXlsxPrinter<T> implements Printer<T> {

    private static final Logger logger = LoggerFactory.getLogger(BEntityXlsxPrinter.class);

    @Override
    public void print(ServletOutputStream outputStream, List<T> entities) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(getSheetName());

        printSheet(sheet, entities);

        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            logger.error("Error occurred during writing BEntity to xlsx stream", e);
        }
    }

    abstract void printSheet(XSSFSheet sheet, List<T> entities);

    abstract String getSheetName();
}
