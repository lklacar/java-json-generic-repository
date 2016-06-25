package com.lukaklacar;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luka on 6/25/2016.
 */
@SuppressWarnings("ALL")
public class GenericRepository<T extends BaseModel> {

    private Class<T> clazz;

    public GenericRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void add(T model) {
        ObjectMapper mapper = new ObjectMapper();

        ArrayList<T> objects = all();
        objects.add(model);
        try {
            mapper.writeValue(new File(clazz.getName() + ".json"), objects);
        } catch (IOException e) {

        }
    }

    public ArrayList<T> all() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return mapper.readValue(new File(clazz.getName() + ".json"), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<T>();
    }

    public ArrayList<T> get(Query c) {
        ArrayList<T> objects = new ArrayList<T>();
        for (int i = 0; i < all().size(); i++) {
            T obj = all().get(i);
            if (c.isValid(obj))
                objects.add(obj);
        }

        return objects;
    }

}
