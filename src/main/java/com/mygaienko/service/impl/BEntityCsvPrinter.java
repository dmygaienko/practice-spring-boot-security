package com.mygaienko.service.impl;

import com.mygaienko.model.BEntity;
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
public class BEntityCsvPrinter implements Printer<BEntity> {

    private static final Logger logger = LoggerFactory.getLogger(BEntityCsvPrinter.class);

    @Override
    public void print(ServletOutputStream outputStream, List<BEntity> entities) {
        entities.stream()
                .forEach(entity -> {
                            try {
                                outputStream.print(entity.getB1());
                                outputStream.print(entity.getB2());
                            } catch (IOException e) {
                                logger.error("Error occurred during writing BEntity to stream", e);
                            }
                        }
                );
    }
}
