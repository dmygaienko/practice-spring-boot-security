package com.mygaienko.service.impl;

import com.mygaienko.model.AEntity;
import com.mygaienko.model.BEntity;
import com.mygaienko.service.AEntityService;
import com.mygaienko.service.BEntityService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by enda1n on 15.10.2016.
 */
public class AEntityServiceImpl implements AEntityService {

    @Override
    public List<AEntity> getAll() {
        return Arrays.asList(new AEntity("a11", "a21"), new AEntity("a12", "a22"));
    }
}
