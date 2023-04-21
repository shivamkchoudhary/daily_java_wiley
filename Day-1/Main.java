// Basic
//public class Main {
//    public static void main(String[] args) {
//    System.out.println("Hello world!");
//
//}
//}


//Enum introduction
//public class Main {
//
//    enum DayOfWeek {
//        MONDAY,
//        TUESDAY,
//        WEDNESDAY,
//        THURSDAY,
//        FRIDAY,
//        SATURDAY,
//        SUNDAY
//    }
//
//    public static void main(String[] args) {
//        for (DayOfWeek day : DayOfWeek.values()) {
//            System.out.println(day);
//        }
//        for (int i=0;i<DayOfWeek.values().length; i++){
//            System.out.println(DayOfWeek.values()[i]);
//        }
//    }
//}


//// Basic discount method code
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter the number of items: ");
//        int numItems = sc.nextInt();
//
//        double totalPrice = 0;
//        for (int i = 1; i <= numItems; i++) {
//            System.out.print("Enter the price of item " + i + ": $");
//            double price = sc.nextDouble();
//            totalPrice += price;
//        }
//
//        double discountPercentage = calculateDiscountPercentage(totalPrice);
//
//        System.out.println("Total price: $" + totalPrice);
//        if (discountPercentage == 0) {
//            System.out.println("No discount available.");
//            System.out.println(totalPrice);
//        } else {
//            System.out.println("Discount percentage: " + discountPercentage + "%");
//            double discountAmount = calculatePercentage(totalPrice, discountPercentage);
//            System.out.println("Discount amount: $" + discountAmount);
//            System.out.println("Discounted price: $" + (totalPrice - discountAmount));
//        }
//    }
//
//    public static double calculatePercentage(double price, double percentage) {
//        double amount = (percentage / 100) * price;
//        return amount;
//    }
//
//    public static double calculateDiscountPercentage(double totalPrice) {
//        double discountPercentage = 0;
//        if (totalPrice >= 10000) {
//            discountPercentage = 10;
//        }
//        return discountPercentage;
//    }
//
//}

//Loops
public class Main{
    public static void main(String[] args) {
        // For loop
//        for(int i=0;i<=10;i++){
//            System.out.println("Value of i is : " + i);
//            for(int j=0;j<=i;j++){
//                System.out.println("Value of j is : " + j);
//            }
//        }
        int i = 0;
        //While loop
//        while(i<11){
//            System.out.println("Value of i is : "+i);
//            i++;
//        }
        // do-while loop
        do{
            System.out.println("Value of i is : "+ i);
            i++;
        }
        while (i<11);
    }
}