package com.mygaienko.controller;

import com.mygaienko.model.AEntity;
import com.mygaienko.model.BEntity;
import com.mygaienko.model.Dto;
import com.mygaienko.model.ExportType;
import com.mygaienko.service.ExportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by enda1n on 13.10.2016.
 */
@Controller("/bentity")
public class BEntityExportController extends AbstractExportController {

    @RequestMapping("/export/{type}")
    public void export(@RequestBody Dto dto, @PathVariable("type") ExportType type, HttpServletResponse response) {
        export(response, getFileName(), () -> fetchData(dto), type);
    }

    private List<BEntity> fetchData(Dto dto) {
        return Arrays.asList(new BEntity("b11", "b21"), new BEntity("b12", "b22"));
    }

    private String getFileName() {
        return StringUtils.EMPTY;
    }
}
