package com.shivamkchoudhary;

public class Main implements Cloneable{
    int a = 10;
    public void add(){
        System.out.println("Number adding...");
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, CloneNotSupportedException {
        // Create object with new keyword
        Main m = new Main();
        m.add();
        System.out.println(m);
        // Create object with new instance
        try {
            Class c = Class.forName("com.shivamkchoudhary.Main");
            Main c1 = (Main) c.newInstance();
            c1.add();
            System.out.println(c1);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        // Create object with object clone

        Main objClone = (Main) m.clone();
        objClone.add();
        System.out.println(objClone);

    }
}