package com.mygaienko.service.impl;

import com.mygaienko.model.AEntity;
import com.mygaienko.model.ExportType;
import com.mygaienko.service.AEntityService;
import com.mygaienko.service.ExportService;
import com.mygaienko.service.Printer;
import com.mygaienko.service.PrinterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service("aExportService")
public class AExportServiceImpl implements ExportService {

    @Autowired
    private PrinterFactory printerFactory;

    @Autowired
    private AEntityService aEntityService;

    public void export(ServletOutputStream outputStream, ExportType type) {
        Printer<AEntity> printer = printerFactory.getPrinter(type);
        printer.print(outputStream, aEntityService.getAll());
    }

}
