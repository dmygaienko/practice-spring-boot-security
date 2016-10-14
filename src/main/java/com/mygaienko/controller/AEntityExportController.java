package com.mygaienko.controller;

import com.mygaienko.model.Dto;
import com.mygaienko.model.ExportType;
import com.mygaienko.service.ExportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by enda1n on 13.10.2016.
 */
@Controller("/aentity")
public class AEntityExportController extends AbstractExportController {

    @Autowired
    @Qualifier("aExportService")
    private ExportService aExportService;

    @RequestMapping("/export/{type}")
    public void export(@RequestBody Dto dto, @PathVariable("type") ExportType type, HttpServletResponse response) {
        export(response, getFileName(), outputStream -> aExportService.export(outputStream, type));
    }

    private String getFileName() {
        return StringUtils.EMPTY;
    }
}
