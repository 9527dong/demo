package com.demo;

public class SingleTest {
    private final static SingleTest instance = new SingleTest();
    private SingleTest()
    {
    }
    public static SingleTest newInstance()
    {
        return instance;
    }
}
