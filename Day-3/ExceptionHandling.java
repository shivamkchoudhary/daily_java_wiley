package com.shivamkchoudhary;

public class ExceptionHandling {
    public static void main(String[] args) {
        System.out.println("First Statement");
        int arr[] = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[1]);
            System.out.println(arr[5]);
            System.out.println("Simple statement 2");
            String name = "Shivam";
            System.out.println(name.charAt(8));
            System.out.println(12/0);
            System.out.println("Test statement 1");
            System.out.println("Test statement 2");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e){
            System.out.println("Catch block 2");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("catch block 3");
            e.printStackTrace();
        }
        System.out.println("Last Statement");
    }
}
