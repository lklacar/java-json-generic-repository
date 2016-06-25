package com.lukaklacar;

/**
 * Created by Luka on 6/25/2016.
 */
public interface Query<T extends BaseModel> {

    boolean isValid(T model);

}
