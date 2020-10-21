package com.collections.concurrent.lock;

public class SynchronizedLockExample implements Runnable {
    private Resource resource;

    public SynchronizedLockExample(Resource r){
        this.resource = r;
    }

    @Override
    public void run() {
        synchronized (resource) {
            this.resource.doSomething();
            try {
                wait(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.resource.doLogging();
    }
}
