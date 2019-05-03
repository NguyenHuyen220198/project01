/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import CheckData.CheckData;
import Object.NhanVien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AppNhanVien {

    ArrayList<NhanVien> listNV = new ArrayList();
    private String filename = "NhanVien.txt";

    public void loadfile() {
        try {
            InputStream in = new FileInputStream(filename);
            Reader read = new InputStreamReader(in, "UTF-8");

            String Info;

            BufferedReader br = new BufferedReader(read);
            while ((Info = br.readLine()) != null) {
                String arr[] = Info.split("\t");
                NhanVien nv = new NhanVien();
                nv.setID(arr[0]);
                nv.setName(arr[1]);
                nv.setPhone(arr[2]);
                nv.setEmail(arr[3]);
                nv.setLocal(arr[4]);
                nv.setPass(arr[5]);

                listNV.add(nv);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void menu() {
        int n;
        do {
            System.out.println("-------QUẢN LÍ NHÂN VIÊN-------");
            System.out.println("1.Xem danh sách nhân viên");
            System.out.println("2.Thêm mới một nhân viên.");
            System.out.println("3. Cập nhật thông tin nhân viên.");
            System.out.println("4. Xóa thông tin nhân viên.");
            System.out.println("5. Thoát.");
            System.out.println("Mời bạn nhập lựa chọn.");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            switch (n) {
                case 1:
                    this.xem();
                    break;
                case 2:
                    this.them();
                    break;
                case 3:
                    this.capNhat();
                    break;
                case 4:
                    this.xoa();
                    break;
                case 5:
                    System.out.println("thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("không hợp lệ");
            }
        } while (n != 5);

    }

    public void xem() {
        for (int i = 0; i < listNV.size(); i++) {
            listNV.get(i).showInfo();
        }
    }

    public void them() {
        NhanVien nv = new NhanVien();
           nv.add();
       // if (!checkExit(nv.getID())) {      
        //    listNV.add(nv);
        //    this.xem();
        //    save();
       // } else {
            System.err.println("Mã nhân viên đã tồn tại!!!");
    }
    NhanVien nv = new NhanVien();
    int index = 0;

    public boolean checkExit(String ID) {
        boolean check = false;
        for (int i = 0; i < listNV.size(); i++) {
            nv = listNV.get(i);
            if (ID.equalsIgnoreCase(nv.getID())) {
                check = true;
                index = i;
                break;
            }
        }
        return check;
    }
    //kiểm tra ID đã tồn tại hay chưa

    public boolean ktraPass() {
        boolean check = false;
        System.out.println("nhập mật khẩu  :  ");
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        for (int i = 0; i < listNV.size(); i++) {
            nv = listNV.get(i);
            if (pass.equalsIgnoreCase(nv.getPass())) {
                check = true;
                index = i;
                break;
            }
        }
        return check;
    }
    //kiểm tra mật khẩu có trùng hay không

    public boolean timKiem() {
        boolean check = false;
        System.out.println("Mời nhập mã nhân viên cần tìm :");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        for (int i = 0; i < listNV.size(); i++) {
            nv = listNV.get(i);
            if (ID.equalsIgnoreCase(nv.getID())) {
                check = true;
                index = i;
                break;
            }
        }
        return check;
    }

    public void capNhat() {
        CheckData check = new CheckData();
        timKiem();
        Scanner sc = new Scanner(System.in);
        if (timKiem() == true) {
            System.out.println("danh sách : " + listNV);
            System.out.println("thông tin nhân viên tìm thấy: ");
            System.out.println("cập nhật thông tin nhân viên : ");

            System.out.println("mã nhân viên " + nv.getID());

            do {
                System.out.println("tên nhân viên cũ : " + nv.getName());
                System.out.println("tên nhân viên mới : ");
                nv.setName(sc.nextLine());
                if (check.ktraTen(nv.getName())) {
                    System.out.println("tên nhân viên không được chứa số hoặc rỗng. ");
                }
            } while (check.ktraTen(nv.getName()));

            do {
                System.out.println("số điện thoại cũ : " + nv.getPhone());
                System.out.println("số điện thoại  mới : ");
                nv.setPhone(sc.nextLine());
                if (check.ktraPhone(nv.getPhone())) {

                }
            } while (check.ktraPhone(nv.getPhone()));

            do {
                System.out.println("email cũ : " + nv.getEmail());
                System.out.println("email mới : ");
                nv.setEmail(sc.nextLine());
                if (check.kiemTraEmail(nv.getEmail())) {
                }
            } while (check.kiemTraEmail(nv.getEmail()));

            System.out.println("địa chỉ cũ : " + nv.getLocal());
            System.out.println("địa chỉ mới : ");
            nv.setLocal(sc.nextLine());

            System.out.println("mật khẩu cũ : " + nv.getPass());
            System.out.println("mật khẩu mới : ");
            nv.setPass(sc.nextLine());

            listNV.set(index, nv);
            save();

        } else {
            System.err.println("không tìm thấy nhân viên ");
        }
    }

    public void xoa() {
        timKiem();
        if (timKiem() == true) {
            System.out.println("thông tin nhân viên tìm thấy : " + nv);
            listNV.remove(nv);
        } else {
            System.err.println("không tìm thấy nhân viên hợp lệ.");
        }
    }

    public void save() {
        try {
            Writer fw = new FileWriter(this.filename);
            BufferedWriter bw = new BufferedWriter(fw);
            String DL = "";
            for (int i = 0; i < listNV.size(); i++) {
                String c = "";
                c += listNV.get(i).getID() + "\t";
                c += listNV.get(i).getName() + "\t";
                c += listNV.get(i).getPhone() + "\t";
                c += listNV.get(i).getEmail() + "\t";
                c += listNV.get(i).getLocal() + "\t";
                c += listNV.get(i).getPass() + "\t";
                DL += c;
                bw.write(DL);
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(AppNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
