package com.mygaienko.service;

import com.mygaienko.model.ExportType;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
public interface ExportService {

    void export(PrintWriter writer, ExportType type);
}
