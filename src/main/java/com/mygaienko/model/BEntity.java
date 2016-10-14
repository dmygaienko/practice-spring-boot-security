package com.mygaienko.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by enda1n on 13.10.2016.
 */
@Data
@RequiredArgsConstructor
@Builder
public class BEntity {

    private final String b1;
    private final String b2;
    private final String b3;
    private final String b4;

}
