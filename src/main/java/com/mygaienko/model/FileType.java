package com.mygaienko.model;


/**
 * Created by enda1n on 14.10.2016.
 */
public enum FileType {
    CSV("csv"), XLSX("xlsx");

    private String extension;

    FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}