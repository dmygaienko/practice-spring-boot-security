package com.mygaienko.service;

import com.mygaienko.model.ExportType;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
public interface ExportService {

    <T> void print(ServletOutputStream outputStream, List<T> entities, ExportType type);
}
