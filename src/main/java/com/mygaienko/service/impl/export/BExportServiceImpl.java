package com.mygaienko.service.impl.export;

import com.mygaienko.model.BEntity;
import com.mygaienko.model.ExportType;
import com.mygaienko.service.BEntityService;
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
@Service("bExportService")
public class BExportServiceImpl implements ExportService {

    private static final Logger logger = LoggerFactory.getLogger(BExportServiceImpl.class);

    @Autowired
    private PrinterFactory printerFactory;

    @Autowired
    private BEntityService bEntityService;

    public void export(ServletOutputStream outputStream, ExportType type) {
        Printer<BEntity> printer = printerFactory.getPrinter(type);
        try {
            printer.print(outputStream, bEntityService.getAll());
        } catch (IOException e) {
            logger.error("Error occurred during export BEntity to stream", e);
        }
    }

}
