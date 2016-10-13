package com.mygaienko.service.impl;

import com.mygaienko.model.AEntity;
import com.mygaienko.service.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
@Service
public class AEntityCsvPrinter implements Printer<AEntity> {

    private static final Logger logger = LoggerFactory.getLogger(AEntityCsvPrinter.class);

    @Override
    public void print(ServletOutputStream outputStream, List<AEntity> entities) {
        entities.stream()
                .forEach(entity -> {
                            try {
                                outputStream.print(entity.getA1());
                                outputStream.print(entity.getA2());
                            } catch (IOException e) {
                                logger.error("Error occurred during writing AEntity to stream", e);
                            }
                        }
                );
    }
}
