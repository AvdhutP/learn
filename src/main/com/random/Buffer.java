package com.random;


class BufferChild
{
    public BufferChild()
    {
        System.out.println("In BufferChild constr");
    }

    public void Display()
    {
        System.out.println("In buffer child mthd");
    }

}

public class Buffer extends BufferChild
{
   public Buffer()
   {
       System.out.println("In Buffer");
   }




    public static void main(String[] args) {
        BufferChild bc=new Buffer();
        bc.Display();
    }
}