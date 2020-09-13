package com.designpatterns.factory.abstrct;

import com.designpatterns.factory.Computer;

public class ComputerFactory  {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
