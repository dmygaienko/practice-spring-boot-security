package com.mygaienko.model;

import static com.mygaienko.model.FileType.CSV;
import static com.mygaienko.model.FileType.XLSX;

/**
 * Created by enda1n on 14.10.2016.
 */
public enum ExportType {
    AENTITY_CSV(CSV),
    AENTITY_XLSX(XLSX),
    BENTITY_CSV(CSV),
    BENTITY_XLSX(XLSX);

    private FileType fileType;

    ExportType(FileType fileType) {
        this.fileType = fileType;
    }

    public FileType getFileType() {
        return fileType;
    }
}
