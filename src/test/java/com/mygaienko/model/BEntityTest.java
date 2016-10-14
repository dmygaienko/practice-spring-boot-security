package com.mygaienko.model;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by enda1n on 14.10.2016.
 */
public class BEntityTest {

    @Test
    public void testBuilder() throws Exception {
        BEntity entity = BEntity.builder()
                .b1("1").b2("2").b3("3").b4("4")
                .build();

        assertThat(entity.getB1(), is("1"));
    }
}