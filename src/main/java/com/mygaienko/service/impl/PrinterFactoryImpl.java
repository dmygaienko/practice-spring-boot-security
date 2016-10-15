package com.mygaienko.service.impl;

import com.mygaienko.model.ExportType;
import com.mygaienko.service.Printer;
import com.mygaienko.service.PrinterFactory;
import com.mygaienko.service.impl.AEntityCsvPrinter;
import com.mygaienko.service.impl.AEntityXlsxPrinter;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service
public class PrinterFactoryImpl implements PrinterFactory {

    @Override
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
