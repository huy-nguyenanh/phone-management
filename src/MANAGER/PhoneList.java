
package MANAGER;

import DAO.FileDAO;
import DTO.Phone;
import java.util.ArrayList;
import java.util.Collections;


public class PhoneList implements I_PhoneList {

    ArrayList<Phone> list = new ArrayList<>();

    public boolean addPhoneToList(Phone phone) {
        return list.add(phone);
    }

    public Phone findPhone(String model) {
        for (Phone phone : list) {
            if (phone.getModel().equalsIgnoreCase(model)) {
                return phone;
            }
        }
        return null;
    }

    public int searchPhone(String model) {
        int count = 0;
        for (Phone phone : list) {
            if (phone.getModel().startsWith(model)) {
                System.out.println(phone);
                count++;
            }
        }
        if (count == 0) {
            return -1; // k tim thay gia tri phu hop
        }
        return 1;
    }

    public int removePhone(String model, String userConfirm) {
        Phone removePhone = findPhone(model);
        if (removePhone != null) {
            
                if (userConfirm.equalsIgnoreCase("y") || userConfirm.equalsIgnoreCase("yes")) {
                    boolean isRemoved = list.remove(removePhone);
                    if (isRemoved) {
                        return 1; // xoa thanh cong
                    } else {
                        return -1; // xoa that bai
                    }
                } else if(userConfirm.equalsIgnoreCase("n") || userConfirm.equalsIgnoreCase("no")){
                    
                    return -2; // quay lai menu
                }  else {
                    System.out.println("Choice Yes or No, please!\n");
                    return  -3; // chỉ chọn Y or N
                    
                }
        } 
        return 0; // k tim thay
    }

    public boolean checkEmpty() {
        int result = list.size();
        if (result == 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Phone> descendingSort() {
        ArrayList<Phone> tmp = list;
        Collections.sort(tmp, Phone.byName);
        return tmp;
    }

    public int exportPhoneList(String fileName) {
        FileDAO exprotFile = new FileDAO();
        int resultExport = exprotFile.writeFile(list, fileName);
        return resultExport;
    }

    public void importStudentList(String fileName) {
        FileDAO importFile = new FileDAO();
        list = importFile.readFile(fileName);
    }

}
