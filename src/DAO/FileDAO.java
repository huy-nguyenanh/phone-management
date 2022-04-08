package DAO;

import DTO.Phone;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileDAO implements I_FileDAO {

    public int writeFile(ArrayList<Phone> list, String fileName) {
        File f = new File(fileName);
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            for (Phone phone : list) {
                pw.println(phone.getModel() + " - " + phone.getCPU() + " - " + phone.getRAM() + " - " + phone.getPrimary_camera()
                        + " - " + phone.getScreen_size() + " - " + phone.getColor() + " - " + phone.getBrand() + " - " + phone.getPrice());
                pw.flush();
            }
            return 1;

            //w.println(list[i]);
        } catch (Exception e) {
            System.out.println("Export fail");
            return -1;
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println("Something wrong");
            }
        }
    }

    public ArrayList<Phone> readFile(String fileName) {
        //tạo mảng để chứa kq
        ArrayList<Phone> tmpList = new ArrayList<>();
        FileReader f = null;
        BufferedReader r = null;
        try {
            f = new FileReader(fileName);
            r = new BufferedReader(f);
            while (r.ready()) {
                String s = r.readLine();
                if (s != null && !s.isEmpty()) { // cắt 1 dòng thành từng chuỗi nhỏ 
                    StringTokenizer stk = new StringTokenizer(s, ",");
                    String model = stk.nextToken();
                    String CPU = stk.nextToken();
                    double RAM = Double.parseDouble(stk.nextToken());
                    double camera = Double.parseDouble(stk.nextToken());
                    double screensize = Double.parseDouble(stk.nextToken());
                    String color = stk.nextToken();
                    String brand = stk.nextToken();
                    long price = Long.parseLong(stk.nextToken());
                    Phone x = new Phone(model, CPU, RAM, camera, screensize, color, brand, price);
                    tmpList.add(x);
                }

            }
        } catch (IOException e) {
            System.out.println(" wrong");
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (r != null) {
                    r.close();
                }
            } catch (Exception e) {
                System.out.println("Something wrong");
            }
        }
        return tmpList;
    }

}
