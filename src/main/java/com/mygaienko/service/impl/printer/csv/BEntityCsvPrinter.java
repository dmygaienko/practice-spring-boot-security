package com.mygaienko.service.impl.printer.csv;

import com.mygaienko.model.BEntity;
import com.mygaienko.service.Printer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service
public class BEntityCsvPrinter implements Printer<BEntity> {

    private static final Logger logger = LoggerFactory.getLogger(BEntityCsvPrinter.class);

    @Override
    public void print(PrintWriter writer, List<BEntity> entities) throws IOException {
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withRecordSeparator("\n"));

        entities.stream()
                .forEach(entity -> {
                            try {
                                csvPrinter.print(entity.getB1());
                                csvPrinter.print(entity.getB2());
                                csvPrinter.print(entity.getB3());
                                csvPrinter.print(entity.getB4());
                                csvPrinter.println();
                            } catch (IOException e) {
                                logger.error("Error occurred during writing BEntity to stream", e);
                            }

                        }
                );
    }
}
