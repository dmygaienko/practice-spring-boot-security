package com.mygaienko.service.impl;

import com.mygaienko.model.ExportType;
import com.mygaienko.service.ExportService;
import com.mygaienko.service.Printer;
import com.mygaienko.service.PrinterFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service
public class ExportServiceImpl implements ExportService {

    private PrinterFactory printerFactory;

    public <T> void print(ServletOutputStream outputStream, List<T> entities, ExportType type) {
        Printer<T> printer = printerFactory.getPrinter(type);
        printer.print(outputStream, entities);
    }
}
