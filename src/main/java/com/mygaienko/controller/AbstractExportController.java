package com.mygaienko.controller;

import com.mygaienko.model.ExportType;
import com.mygaienko.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
@Controller
public abstract class AbstractExportController {

    @Autowired
    private ExportService exportService;

    public <T> void export(HttpServletResponse response, String fileName, FetchData<List<T>> fetchData, ExportType type) {
        response.setContentType("text/csv");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            exportService.print(outputStream, fetchData.get(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
