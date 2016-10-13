package com.mygaienko.service.impl;

import com.mygaienko.model.AEntity;
import com.mygaienko.service.Printer;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by enda1n on 14.10.2016.
 */
public class AEntityXlsxPrinter implements Printer<AEntity> {

    @Override
    public void print(ServletOutputStream outputStream, List<AEntity> entities) {

    }
}
