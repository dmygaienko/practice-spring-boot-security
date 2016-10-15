package com.mygaienko.service;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by enda1n on 13.10.2016.
 */
public interface Printer<T> {

    void print(PrintWriter writer, List<T> entities) throws IOException;
}
