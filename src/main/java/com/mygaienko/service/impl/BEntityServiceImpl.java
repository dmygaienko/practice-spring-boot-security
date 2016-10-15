package com.mygaienko.service.impl;

import com.mygaienko.model.BEntity;
import com.mygaienko.service.BEntityService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by enda1n on 15.10.2016.
 */
@Service
public class BEntityServiceImpl implements BEntityService {

    @Override
    public List<BEntity> getAll() {
        return Arrays.asList(new BEntity("b11", "b21", "b31", "b41"), new BEntity("b12", "b22", "b32", "b42"));
    }
}
