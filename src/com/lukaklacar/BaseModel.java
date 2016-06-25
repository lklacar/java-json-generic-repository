package com.lukaklacar;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Luka on 6/25/2016.
 */
public abstract class BaseModel {


    protected String id;

    @JsonProperty
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
