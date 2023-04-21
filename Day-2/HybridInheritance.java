package com.shivamkchoudhary;

class GrandFather{
    public void Color(){
        System.out.println("White....");
    }
}
class Father extends GrandFather{
    public void Rich(){
        System.out.println("False....");
    }
}
class Uncle extends GrandFather{
    public void Brain(){
        System.out.println("False....");
    }
}
class Son extends Father{
    public void Study(){
        System.out.println("Zero....");
    }
}
class Daughter extends Father{
    public void Fat(){
        System.out.println("True....");
    }
}
public class HybridInheritance {
    public static void main(String[] args) {
        Father f = new Father();
        Uncle u = new Uncle();
        Son s = new Son();
        Daughter d = new Daughter();
        f.Rich();
        f.Color();
        u.Color();
        u.Brain();
        s.Color();
        s.Rich();
        s.Study();
        d.Color();
        d.Rich();
        d.Fat();
    }
}
