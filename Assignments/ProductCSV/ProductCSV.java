package com.shivamkchoudhary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductCSV {
    private String name;
    private int price;
    private String category;
    private double rating;

    public ProductCSV(String name, int price, String category, double rating) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public double getRating() {
        return rating;
    }
    public String getData(){
        return "Product1 --> Name: "+this.name+" price: "+this.price+" category: "+this.category+" rating: "+this.rating;
    }

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br;

        List<ProductCSV> productList = new ArrayList<>();

        try{
            FileReader fr  =new FileReader("products.csv");
            br  = new BufferedReader(fr);

            String i;
            while((i= br.readLine())!=null){
                String[] productInfo = i.split(",");

                System.out.println(productInfo.length);
                String name  = productInfo[0];
                int price = Integer.parseInt(productInfo[1]);
                String category  = productInfo[2];
                double rating  = Double.parseDouble(productInfo[3]);
                ProductCSV product = new ProductCSV(name,price,category,rating);
                productList.add(product);
            }}
        catch(Exception e){
            e.printStackTrace();
        }
        for (ProductCSV product: productList) {
            System.out.println(product.getData());
        }
    }
}