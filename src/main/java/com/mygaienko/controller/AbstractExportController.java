package com.mygaienko.controller;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * Created by enda1n on 14.10.2016.
 */
public abstract class AbstractExportController {

    public void export(HttpServletResponse response, String fileName, Consumer<ServletOutputStream> export) {
        response.setContentType("text/csv");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            export.accept(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
