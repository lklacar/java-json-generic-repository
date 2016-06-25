package com.lukaklacar;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        GenericRepository<TestObject> repository = new GenericRepository<>(TestObject.class);

        repository.add(new TestObject("ASD"));


        ArrayList<TestObject> objects = new GenericRepository<>(TestObject.class).get(new Query<TestObject>() {
            @Override
            public boolean isValid(TestObject model) {
                return model.getName() != null;
            }
        });


        for (TestObject obj : objects) {
            System.out.println(obj.getName());
        }

    }
}
