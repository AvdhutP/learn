package com.designpatterns.factory.abstrct;

import com.designpatterns.factory.Computer;
import com.designpatterns.factory.Server;

public class ServerFactory implements ComputerFactory{
    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram,hdd,cpu);
    }
}
