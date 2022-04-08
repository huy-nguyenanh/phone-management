package Validation;

import java.util.Scanner;

public class Accept_Input {

    Scanner sc = new Scanner(System.in);

    public Accept_Input() {
    }

    public String acceptString(String msg) {
        String model;
        System.out.println(msg);
        model = sc.nextLine();
        return model;
    }

    public String acceptColor(String msg) {
        String color;
        System.out.println(msg);
        color = sc.nextLine();
        if (color.matches("[a-zA-Z]{1,10}")) {
            return color;
        } else if(color.matches("[0-9]") || color.matches("[a-zA-Z0-9_]{1,10}")){
            System.out.println("Not accept number in color information!");
            return null;
        } else {
            System.out.println("Color not be empty!");
            return null;
        }    
    }

    public String acceptBrand(String msg) {
        String brand;
        System.out.println(msg);
        brand = sc.nextLine();
        if (brand.matches("[a-zA-Z]{1,20}")) {
            return brand;
        } else if(brand.matches("[0-9]") || brand.matches("[a-zA-Z0-9_]{1,20}")){
            System.out.println("Not accept number in color information!");
            return null;
        } else {
            System.out.println("Brand not be empty!");
            return null;
        }    
    }

    public String acceptCPU(String msg) {
        String CPU;
        System.out.println(msg);
        CPU = sc.nextLine();
        return CPU;
    }

    public double acceptDouble(String msg) throws NumberFormatException {
        double number = 0;
        System.out.println(msg);
        number = Double.parseDouble(sc.nextLine());
        return number;
    }

    public long acceptLong(String msg) throws NumberFormatException {
        long number = 0;
        System.out.println(msg);
        number = Long.parseLong(sc.nextLine());
        return number;
    }

    public int acceptInt(String msg) throws NumberFormatException {
        int number = 0;
        System.out.println(msg);
        number = Integer.parseInt(sc.nextLine());
        return number;
    }

    public String acceptFileName(String msg) {
        String fileName;
        System.out.println(msg);
        fileName = sc.nextLine();
        fileName = fileName + ".txt";
        return fileName;
    }
}
