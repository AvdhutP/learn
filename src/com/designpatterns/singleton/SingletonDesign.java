package com.designpatterns.singleton;

public class SingletonDesign {
    /* there are many ways to create singleton pattern
    best way is creating private static inner class to return the instance
    */

    private SingletonDesign(){}

    private static class  SignletonDesignHelper
    {
        private static final SingletonDesign INSTANCE= new SingletonDesign();
    }

    public static SingletonDesign getInstance()
    {
        return SignletonDesignHelper.INSTANCE;
    }

}
