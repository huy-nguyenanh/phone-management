
package MANAGER;

import DTO.Phone;
import java.util.ArrayList;


public interface I_PhoneList {
    public boolean addPhoneToList(Phone phone);
    public Phone findPhone(String model);
    public int searchPhone(String model);
    public int removePhone(String model, String userConfirm);
    public boolean checkEmpty();
    public ArrayList<Phone> descendingSort();
    public int exportPhoneList(String fileName);
    public void importStudentList(String fileName);
}
