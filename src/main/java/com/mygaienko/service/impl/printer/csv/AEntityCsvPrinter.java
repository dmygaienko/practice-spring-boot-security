package com.mygaienko.service.impl.printer.csv;

import com.mygaienko.model.AEntity;
import com.mygaienko.service.Printer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service
public class AEntityCsvPrinter implements Printer<AEntity> {

    private static final Logger logger = LoggerFactory.getLogger(AEntityCsvPrinter.class);

    @Override
    public void print(ServletOutputStream outputStream, List<AEntity> entities) throws IOException {

        try (
                PrintWriter printWriter = new PrintWriter(outputStream);
                CSVPrinter csvPrinter = new CSVPrinter(printWriter, CSVFormat.DEFAULT.withRecordSeparator("\n"))) {

            entities.stream()
                    .forEach(entity -> {
                                try {
                                    csvPrinter.print(entity.getA1());
                                    csvPrinter.print(entity.getA2());
                                    csvPrinter.println();
                                } catch (IOException e) {
                                    logger.error("Error occurred during writing AEntity to stream", e);
                                }

                            }
                    );
        }
    }
}
