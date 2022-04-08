/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MANAGER;

import DTO.Phone;
import Validation.Accept_Input;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class PhoneManager implements I_PhoneManager {

    Accept_Input tool = new Accept_Input();
    PhoneList list = new PhoneList();

    public PhoneManager() {
    }

    public int addToList() {
        String model;
        String CPU;
        String color;
        String brand;
        double RAM = 0;
        double primaryCamera = 0;
        double screenSize = 0;
        long price = 0;
        boolean continute = false;
        do {
            model = tool.acceptString("Enter model: (Format: String)");
            if (list.findPhone(model) != null) {
                System.out.println("Model is already in store");
                System.out.println("Enter another model");
                continute = true;
            } else if (model == null) {
                System.out.println("Model not be empty! ");
                System.out.println("");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);

        do {
            CPU = tool.acceptCPU("Enter CPU: (Format: String)");
            if (CPU == null) {
                System.out.println("CPU not be empty! ");
                System.out.println("");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);

        do {
            try {
                RAM = tool.acceptDouble("Enter RAM (Format: number)");
                if (RAM > 0) {
                    continute = false;
                    
                }else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Enter number, please!");
                System.out.println("");
                continute = true;
            }
        } while (continute);

        do {
            try {
                primaryCamera = tool.acceptDouble("Enter primary camera (Format: number)");
                if (primaryCamera > 0) {
                    continute = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Enter number, please!");
                System.out.println("");
                continute = true;
            }
        } while (continute);

        do {
            try {
                screenSize = tool.acceptDouble("Enter srceen size (Format: number)");
                if (screenSize > 0) {
                    continute = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Enter number, please!");
                System.out.println("");
                continute = true;
            }
        } while (continute);

        do {
            color = tool.acceptColor("Enter phone color: (Format: a-zA-Z)");
            if (color == null) {
                System.out.println("Input again!");
                System.out.println("");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);

        do {
            brand = tool.acceptBrand("Enter brand: (Format: a-zA-Z)");
            if (brand == null) {
                System.out.println("");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);

        do {
            try {
                price = tool.acceptLong("Enter price (Format: number)");
                if (price > 0) {
                    continute = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Enter number, please!");
                System.out.println("");
                continute = true;
            }
        } while (continute);
        Phone phone = new Phone(model, CPU, RAM, primaryCamera, screenSize, color, brand, price);
        if (list.addPhoneToList(phone)) {
            System.out.println("Added!");
            return 1; // add thanh cong
        } else {
            System.out.println("Add fail!");
            return -1; // add that bai
        }
    }

    public int searchPhone() {
        if (list.checkEmpty()) {
            return 0; // list trong'
        } else {
            int result = 0;
            String model = tool.acceptString("Enter model to find!");
            result = list.searchPhone(model);
            if (result == 1) {
                System.out.println("Founded!");
                return 1;
            } else if (result == -1) {
                System.out.println("This phone Model does not exist");
                return 1;
            }
        }
        return -1;
    }

    public int removePhone() {
        if (list.checkEmpty()) {
            return 0;
        } else {
            int result = 0;
            String userChoice = "";
            String model = tool.acceptString("Enter model want to remove");
            if (list.findPhone(model) != null) {
                do {
                    userChoice = tool.acceptString("Are you sure to remove? (Y/N)");
                    result = list.removePhone(model, userChoice);
                    switch (result) {
                        case 0:  // k tim thay
                            return -4;
                        case 1: 
                            System.out.println("Removed!");
                            return 1;
                        case -1:
                            System.out.println("Remove fail");
                            return -1;
                        case -2: // quay lai menu
                            return  -2;
                    }
                } while (result == -3);
            }
            return -4;
        }
    }

    public void printPhone() {
        if (list.checkEmpty()) {
            System.out.println("List is empty!");
            System.out.println("Return to menu!\n");
        } else {
            ArrayList<Phone> tmp = list.descendingSort();
            for (Phone phone : tmp) {
                System.out.println(phone);
            }
        }
    }

    public void exportPhoneToList() {
        boolean continute = false;
        if (list.checkEmpty()) {
            System.out.println("List is empty!");
            System.out.println("Return to menu!\n");

        } else {
            do {
                String confirm = tool.acceptString("You want to export List-Phone to file? (Y/N)");
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    String filename = tool.acceptFileName("File name is: ");
                    int resultExport = list.exportPhoneList(filename);
                    if (resultExport == 1) {
                        System.out.println("Exported!");
                        System.out.println("Return to menu!\n");
                        continute = false;
                    } else if (resultExport == -1) {
                        System.out.println("Export fail!");
                        System.out.println("Return to menu!\n");
                        continute = false;
                    }
                } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                    System.out.println("Return to menu!\n");
                    continute = false;
                } else {
                    System.out.println("Choice Yes or No, please!\n");
                    continute = true;
                }
            } while (continute);
        }

    }

    public void importListPhone() {
        boolean continute = false;
        do {
            String confirm = tool.acceptString("You want to import List-Phone to this program? (Y/N)");
            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                list.importStudentList("PhoneList1.txt");
                System.out.println("Completed import!");
                continute = false;
            } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                System.out.println("Return to menu!\n");
                continute = false;
            } else {
                System.out.println("Choice Yes or No, please!\n");
                continute = true;
            }
        } while (continute);
    }

}
