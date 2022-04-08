package GUI;

import MANAGER.PhoneManager;
import Validation.Accept_Input;

public class Main {

    public static void main(String[] args) {
        Accept_Input tool = new Accept_Input();
        PhoneManager function = new PhoneManager();
        Menu menu = new Menu();
        int choice = 0;
        do {
            menu.menu();
            choice = menu.getUserChoice();

            boolean continute = false;
            switch (choice) {
                case 1: //add
                    do {
                        int resultAdd = function.addToList();
                        if (resultAdd == 1) {
                            boolean check = false;
                            do {
                                String confirm = tool.acceptString("Continute to add or Stop? (Y/N)");
                                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                                    check = false;
                                    continute = true;
                                } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                                    System.out.println("Return to menu!\n");
                                    check = false;
                                    continute = false;
                                } else {
                                    System.out.println("Choice Yes or No, please!");
                                    check = true;
                                    continute = true;
                                }
                            } while (check);

                        } else {
                            System.out.println("Add phone again!");
                            System.out.println("");
                            continute = true;
                        }
                    } while (continute);
                    break;
                case 2: //search
                    do {
                        int resultSearch = function.searchPhone();
                        boolean check = false;
                        switch (resultSearch) {
                            case 0:
                                System.out.println("List is empty!");
                                System.out.println("Return to menu!\n");
                                continute = false;
                                break;
                            case 1:
                                do {
                                    String confirm = tool.acceptString("Continute to search or Stop? (Y/N)");
                                    if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                                        check = false;
                                        continute = true;
                                    } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                                        System.out.println("Return to menu!\n");
                                        check = false;
                                        continute = false;
                                    } else {
                                        System.out.println("Choice Yes or No, please!\n");
                                        check = true;
                                    }
                                } while (check);
                                break;
                            default:
                                continute = true;
                                break;
                        }
                    } while (continute);
                    break;

                case 3: //remove
                    do {
                        int resultRemove = function.removePhone();
                        String confirm;
                        boolean check = false;
                        switch (resultRemove) {
                            case 0:
                                System.out.println("List is empty!");
                                System.out.println("Return to menu!\n");
                                continute = false;
                                break;
                            case 1:
                                System.out.println("");
                                do {
                                    confirm = tool.acceptString("Continute to remove or Stop? (Y/N)");
                                    if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                                        check = false;
                                        continute = true;
                                    } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                                        System.out.println("Return to menu!\n");
                                        check = false;
                                        continute = false;
                                    } else {
                                        System.out.println("Choice Yes or No, please!\n");
                                        check = true;
                                    }
                                } while (check);
                                break;
                            case -1:
                                System.out.println("");
                                do {
                                    confirm = tool.acceptString("Remove again or Stop? (Y/N)");
                                    if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                                        check = false;
                                        continute = true;
                                    } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                                        System.out.println("Return to menu!\n");
                                        check = false;
                                        continute = false;
                                    } else {
                                        System.out.println("Choice Yes or No, please!\n");
                                        check = true;
                                    }
                                } while (check);
                                break;
                            case -2:
                                System.out.println("Return to menu!\n");
                                continute = false;
                                break;
                            case -4:
                                System.out.println("This phone Model does not exist!");
                                do {
                                    confirm = tool.acceptString("Remove again or Stop? (Y/N)");
                                    if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                                        check = false;
                                        continute = true;
                                    } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                                        System.out.println("Return to menu!\n");
                                        check = false;
                                        continute = false;
                                    } else {
                                        System.out.println("Choice Yes or No, please!\n");
                                        check = true;
                                    }
                                } while (check);
                                break;

                        }
                    } while (continute);

                    break;
                case 4: //print
                    function.printPhone();
                    break;
                case 5: //export
                    function.exportPhoneToList();
                    break;
                case 6: //import
                    function.importListPhone();
            }

        } while (choice < 7);
    }
}
