
package GUI;

import Validation.Accept_Input;


public class Menu {
    
    public  void menu(){
        System.out.println("-----------------------Menu-------------------------");
        System.out.println("");
        System.out.println("1. Add a phone");
        System.out.println("2. Search a phone by model");
        System.out.println("3. Remove the phone by model");
        System.out.println("4. Print list phone in the descending order of model");
        System.out.println("5. Export to file");
        System.out.println("6. Import form file");
        System.out.println("7. Quit");
        System.out.println("");
    }
    
    public int getUserChoice(){
        Accept_Input tool = new Accept_Input();
        int result = 0;
        boolean flag = false;
        do {
            try {
                result = tool.acceptInt("Choice");
                if(result > 0 && result <= 7)
                    flag = true;
                else { 
                    System.out.println("Choice 1 - 7 please!");
                    flag = false;
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Please enter number!!");
            }
        } while (flag == false);
        return result;
    }
    
}
