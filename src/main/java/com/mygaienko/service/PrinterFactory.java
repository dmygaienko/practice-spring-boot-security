package com.mygaienko.service;

import com.mygaienko.model.ExportType;

/**
 * Created by enda1n on 15.10.2016.
 */
public interface PrinterFactory {

    <T> Printer<T> getPrinter(ExportType type);
}
