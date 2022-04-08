
package DTO;

import java.util.Comparator;


public class Phone implements Comparable<Phone>{
    
    private String model;
    private String CPU;
    private double RAM;
    private double primary_camera;
    private double screen_size;
    private double price;
    private String color;
    private String brand;
    
    public static Comparator<Phone> byName = new Comparator<Phone>() {
       
        @Override
        public int compare(Phone o1, Phone o2) {
            return o2.getModel().compareTo(o1.getModel());
        }
    };

    public Phone(String model, String CPU, double RAM, double primary_camera, double screen_size, String color, String brand, long price) {
        this.model = model;
        this.CPU = CPU;
        this.RAM = RAM;
        this.primary_camera = primary_camera;
        this.screen_size = screen_size;
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

    public Phone() {
        this.model = "";
        this.CPU = "";
        this.RAM = 0.0;
        this.primary_camera = 0.0;
        this.screen_size = 0.0;
        this.color = "";
        this.brand = "";
        this.price = 0.0;
    }

    public String getModel() {
        return model;
    }

    public String getCPU() {
        return CPU;
    }

    public double getRAM() {
        return RAM;
    }

    public double getPrimary_camera() {
        return primary_camera;
    }

    public double getScreen_size() {
        return screen_size;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCPU(String CPU) {
        if(CPU.isEmpty() == false)
            this.CPU = CPU;
    }

    public void setRAM(double RAM) {
        if(RAM > 0)
            this.RAM = RAM;
    }

    public void setPrimary_camera(double primary_camera) {
        if(primary_camera > 0)
            this.primary_camera = primary_camera;
    }

    public void setScreen_size(double screen_size) {
        if(screen_size > 0)
            this.screen_size = screen_size;
    }

    public void setPrice(double price) {
        if(price > 0)
            this.price = price;
    }

    public void setColor(String color) {
        if(color.isEmpty() == false)
            this.color = color;
    }

    public void setBrand(String brand) {
        if(brand.isEmpty() == false)
            this.brand = brand;
    }

    @Override
    public int compareTo(Phone o) {
        if(model.equalsIgnoreCase(o.getModel()))
            return -1;
        return 1;
    }

    @Override
    public String toString() {
        return "Phone information:\n"
                + "Model: " + model + "\n"
                + "CPU: " + CPU + "\n"
                + "RAM: " + RAM + "GB" + "\n"
                + "Primary camera: " + primary_camera +  "MP" + "\n"
                + "Screen size: " + screen_size + "\"" + "\n"
                + "Color: " + color + "\n"
                + "Brand: " + brand + "\n"
                + "Price: " + price + "\n\n";
    }
}
