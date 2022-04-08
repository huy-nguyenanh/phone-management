
package DAO;

import DTO.Phone;
import java.util.ArrayList;


public interface I_FileDAO {
    public int writeFile(ArrayList<Phone> list, String fileName);
    public  ArrayList<Phone> readFile(String fileName);
}
