package com.mygaienko.service;

import com.mygaienko.model.ExportType;
import com.mygaienko.service.impl.AEntityCsvPrinter;
import com.mygaienko.service.impl.AEntityXlsxPrinter;

/**
 * Created by enda1n on 14.10.2016.
 */
public class PrinterFactory {

    public  <T> Printer<T> getPrinter(ExportType type) {
        Printer printer;
        switch (type) {
            case AENTITY_CSV:
                printer = new AEntityCsvPrinter();
                break;
            case AENTITY_XLSX:
                printer = new AEntityXlsxPrinter();
                break;
            case BENTITY_CSV:
                printer = new AEntityCsvPrinter();
                break;
            case BENTITY_XLSX:
                printer = new AEntityXlsxPrinter();
                break;
            default: throw new IllegalStateException("Printer for export cannot be defined");
        }
        return printer;
    }
}
