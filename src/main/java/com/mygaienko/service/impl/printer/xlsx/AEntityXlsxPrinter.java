package com.mygaienko.service.impl.printer.xlsx;

import com.mygaienko.model.AEntity;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by enda1n on 14.10.2016.
 */
public class AEntityXlsxPrinter extends AbstractXlsxPrinter<AEntity> {

    @Override
    public void printSheet(XSSFSheet sheet, List<AEntity> entities) {
        IntStream.range(0, entities.size())
                .forEach(i -> {
                    AEntity entity = entities.get(i);
                    XSSFRow row = sheet.createRow(i);
                    int cellIndex = 0;
                    row.createCell(cellIndex++).setCellValue(entity.getA1());
                    row.createCell(cellIndex++).setCellValue(entity.getA2());
                });
    }

    @Override
    String getSheetName() {
        return "aentities";
    }

}
