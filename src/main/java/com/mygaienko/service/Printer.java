package com.mygaienko.service;


import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by enda1n on 13.10.2016.
 */
public interface Printer<T> {

    void print(ServletOutputStream outputStream, List<T> entities);
}
