package com.mygaienko.service.impl.printer.xlsx;

import com.mygaienko.model.AEntity;
import com.mygaienko.service.Printer;

import javax.servlet.ServletOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
public class BEntityXlsxPrinter implements Printer<AEntity> {

    @Override
    public void print(PrintWriter writer, List<AEntity> entities) {

    }
}
