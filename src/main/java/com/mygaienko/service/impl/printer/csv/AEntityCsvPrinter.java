package com.mygaienko.service.impl.printer.csv;

import com.mygaienko.model.AEntity;
import com.mygaienko.service.Printer;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service
public class AEntityCsvPrinter extends AbstractCsvPrinter<AEntity> implements Printer<AEntity> {

    private static final Logger logger = LoggerFactory.getLogger(AEntityCsvPrinter.class);

    @Override
    protected void printEntities(CSVPrinter csvPrinter, List<AEntity> entities) {
        entities.stream()
                .forEach(entity -> {
                            try {
                                csvPrinter.print(entity.getA1());
                                csvPrinter.print(entity.getA2());
                                csvPrinter.println();
                            } catch (IOException e) {
                                logger.error("Error occurred during writing AEntity to csv stream", e);
                            }
                        }
                );
    }
}

