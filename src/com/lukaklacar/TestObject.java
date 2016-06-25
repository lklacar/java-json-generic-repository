package com.lukaklacar;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Luka on 6/25/2016.
 */
public class TestObject extends BaseModel {

    private String name;

    public TestObject() {
    }

    public TestObject(String asd) {
        super();
        this.name = asd;
    }


    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
