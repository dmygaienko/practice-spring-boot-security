package com.mygaienko.controller;


import com.mygaienko.model.FileType;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

/**
 * Created by enda1n on 14.10.2016.
 */
public abstract class AbstractExportController {

    private static final String simplePattern = "yyyy-MM-dd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(simplePattern);

    public void export(HttpServletResponse response, String fileName, Consumer<ServletOutputStream> export) {
        response.setContentType("text/csv");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            export.accept(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String getFileName(String name, FileType fileType) {
        return name + "_" + LocalDate.now().format(formatter) + "." + fileType.getExtension();
    }

}
