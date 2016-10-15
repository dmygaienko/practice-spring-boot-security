package com.mygaienko.service.impl.printer.xlsx;

import com.mygaienko.model.BEntity;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
public class BEntityXlsxPrinter extends AbstractXlsxPrinter<BEntity>  {

    @Override
    void printSheet(XSSFSheet sheet, List<BEntity> entities) {
        int rows = 0;
        for (BEntity entity : entities) {
            XSSFRow row = sheet.createRow(rows);

            int cellIndex = 0;
            row.createCell(cellIndex++).setCellValue(entity.getB1());
            row.createCell(cellIndex++).setCellValue(entity.getB2());
            row.createCell(cellIndex++).setCellValue(entity.getB3());
            row.createCell(cellIndex++).setCellValue(entity.getB4());

            rows++;
        }
    }

    @Override
    String getSheetName() {
        return "bentities";
    }
}
