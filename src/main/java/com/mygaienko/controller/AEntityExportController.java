package com.mygaienko.controller;

import com.mygaienko.model.AEntity;
import com.mygaienko.model.Dto;
import com.mygaienko.model.ExportType;
import com.mygaienko.service.ExportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by enda1n on 13.10.2016.
 */
@Controller("/aentity")
public class AEntityExportController extends AbstractExportController{

    private ExportService exportService;

    @RequestMapping("/export/{type}")
    public void export(@RequestBody Dto dto, @PathVariable("type") ExportType type, HttpServletResponse response) {
        export(response, getFileName(), () -> fetchData(dto), type);
    }

    private List<AEntity> fetchData(Dto dto) {
        return Arrays.asList(new AEntity("a11", "a21"), new AEntity("a12", "a22"));
    }

    private String getFileName() {
        return StringUtils.EMPTY;
    }
}
