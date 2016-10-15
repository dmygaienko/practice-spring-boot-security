package com.mygaienko.service.impl.export;

import com.mygaienko.model.AEntity;
import com.mygaienko.model.ExportType;
import com.mygaienko.service.AEntityService;
import com.mygaienko.service.ExportService;
import com.mygaienko.service.Printer;
import com.mygaienko.service.PrinterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service("aExportService")
public class AExportServiceImpl implements ExportService {

    private static final Logger logger = LoggerFactory.getLogger(BExportServiceImpl.class);

    @Autowired
    private PrinterFactory printerFactory;

    @Autowired
    private AEntityService aEntityService;

    public void export(ServletOutputStream outputStream, ExportType type) {
        Printer<AEntity> printer = printerFactory.getPrinter(type);
        try {
            printer.print(outputStream, aEntityService.getAll());
        } catch (IOException e) {
            logger.error("Error occurred during export AEntity to stream", e);
        }
    }

}
