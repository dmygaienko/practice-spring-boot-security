package com.mygaienko.service.impl;

import com.mygaienko.model.BEntity;
import com.mygaienko.model.ExportType;
import com.mygaienko.service.BEntityService;
import com.mygaienko.service.ExportService;
import com.mygaienko.service.Printer;
import com.mygaienko.service.PrinterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service("bExportService")
public class BExportServiceImpl implements ExportService {

    @Autowired
    private PrinterFactory printerFactory;

    @Autowired
    private BEntityService bEntityService;

    public void export(ServletOutputStream outputStream, ExportType type) {
        Printer<BEntity> printer = printerFactory.getPrinter(type);
        printer.print(outputStream, bEntityService.getAll());
    }

}
