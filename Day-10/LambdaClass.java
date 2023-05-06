package com.shivamkchoudhary;

public class LambdaClass {

    static String printThing(Printable thing) {
        return thing.print("Edge");
    }

    public static void main(String[] args) {

        //Product myProd = new Product();
        // myProd.print();

        // printThing(myProd);
//		printThing(
//				  () {
//
//					System.out.println("This is a Product Class that implements printable interface");
//
//				}
//				);

        //printThing(() -> System.out.println("This is a lambda expression"));

//		Printable lambaPrinciple = (s) -> System.out.println("expression");
        //Printable lambaPrinciple = s -> System.out.println("expression" + s);
        //Printable lambaPrinciple = (p,s) -> System.out.println("expression" + s);

//		Printable lambaPrinciple = s -> {
//			System.out.println("expression" + s);
//			return "wiley";
//		}

        Printable lambaPrinciple = s -> {
            return "Wiley " + s;
        };

        System.out.println(printThing(lambaPrinciple));
    }

}