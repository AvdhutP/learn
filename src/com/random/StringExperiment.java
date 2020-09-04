package com.random;

public class StringExperiment {
    public static void main(String[] args) {
        String str = "Automation";
        String str5= "Automation";
        System.out.println(str==str5);
        System.out.println(str.equals(str5));
        String str1 = new String("Automation");
        System.out.println(str==str1);
        System.out.println(str.equals(str1));
        String str2 = str;
        System.out.println(str==str2);
        System.out.println(str.equals(str2));
        System.out.println(str2.hashCode());
        str2.concat("2");
        System.out.println(str==str2);
        System.out.println(str.equals(str2));
        System.out.println(str2.hashCode());
        StringBuffer str3=new StringBuffer("Exp");
        System.out.println(str3.hashCode());
        StringBuffer str4=new StringBuffer("Exp");
        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));
        str3.append("2");
        System.out.println(str3.hashCode());

    }
}
