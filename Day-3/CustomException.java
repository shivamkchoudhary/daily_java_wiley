package com.shivamkchoudhary;

class AgeNotValid extends Exception{
    public AgeNotValid(String message){
        super(message);
    }
    public String getMessage(){
        return "AgeNotValid: " + super.getMessage();
    }
    public String toString(){
        return "AgeNotValid: " + super.getMessage();
    }
}
public class CustomException {
    public static void getAge(int age) throws AgeNotValid{
        if(age < 18){
            try{
                throw new AgeNotValid("You are not eligible to vote");
            } catch (AgeNotValid ageNotValid) {
                ageNotValid.printStackTrace();
                System.out.println(ageNotValid.getMessage());
                System.out.println(ageNotValid.toString());
            }
        }else{
            System.out.println("You are eligible to vote");
        }
    }
    public static void main(String[] args) throws AgeNotValid {
        getAge(12);
    }
}
