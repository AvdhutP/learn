
package com.concurrency;

//BATHROOM_SIZE - 5
//2 types of threads - MEN and WOMEN
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class UniSexBathRoom {
    AtomicInteger currentSize;
    int capacity;
    Semaphore noOfEntriesSemaphore;
    Semaphore currentGenderSemaphore = new Semaphore(1);
    volatile Person currentGender;

    public UniSexBathRoom(int capacity) {
        this.capacity = capacity;
        this.noOfEntriesSemaphore = new Semaphore(capacity);
        this.currentSize =  new AtomicInteger(0);
    }

    public void getLength(int[] nums)
    {
        int length= nums.length;
    }

    public void occupy(Person personSex) throws InterruptedException {
        acquireGenderSemaphore(personSex);
        useBathroomAndExit(personSex);
        releaseGenderSemaphore(personSex);
    }

    private void releaseGenderSemaphore(Person personSex) {
        if(currentSize.get()==0){
            currentGenderSemaphore.release();
            currentGender = null;
            System.out.println(personSex.type+ Thread.currentThread().getName()+" releasing gender semaphore");
        }
    }

    private void useBathroomAndExit(Person personSex) throws InterruptedException {
        noOfEntriesSemaphore.acquire();
        currentSize.incrementAndGet();
        System.out.println( "Semaphore entries: "+noOfEntriesSemaphore.getQueueLength() );
        System.out.println(personSex.type +  Thread.currentThread().getName()+" is stepping in, current capacity is : "+currentSize.get());
        Thread.sleep(1000);
        noOfEntriesSemaphore.release();
        currentSize.decrementAndGet();
        System.out.println(personSex.type +  Thread.currentThread().getName()+" is stepping out, current capacity is : "+ currentSize.get() +"-----------------");
    }

    private void acquireGenderSemaphore(Person personSex) throws InterruptedException {
        if(currentSize.get() == 0){
            currentGenderSemaphore.acquire();
            currentGender = personSex;
        }
        if(!personSex.type.equals(currentGender.type)){
            currentGenderSemaphore.acquire();
            currentGender = personSex;
        }
    }

    public static void main(String[] args){
        UniSexBathRoom uniSexBathroom = new UniSexBathRoom(2);
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();

        new Thread(new PersonThread(uniSexBathroom, Person.FEMALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.MALE)).start();
        new Thread(new PersonThread(uniSexBathroom, Person.FEMALE)).start();
    }
}

enum Person {
    MALE("Male"), FEMALE("Female");
    String type;

    Person(String type) {
        this.type = type;
    }
}

class PersonThread implements Runnable {
    public UniSexBathRoom uniSexBathroom;
    public Person person;
    public PersonThread(UniSexBathRoom uniSexBathroom, Person person){
        this.uniSexBathroom = uniSexBathroom;
        this.person = person;
    }

    @Override
    public void run() {
        try {
            uniSexBathroom.occupy(person);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}