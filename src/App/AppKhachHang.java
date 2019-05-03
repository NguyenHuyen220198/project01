/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import CheckData.CheckData;
import Object.KhachHang;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
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
public class AppKhachHang {
    ArrayList<KhachHang> listKH = new ArrayList();
    private String filename = "KhachHang.txt";

    public void loadfile() {
        try {
            InputStream in = new FileInputStream(filename);
            Reader read = new InputStreamReader(in, "UTF-8");

            String Info;

            BufferedReader br = new BufferedReader(read);
            while ((Info = br.readLine()) != null) {
                String arr[] = Info.split("\t");
                KhachHang kh = new KhachHang();
                kh.setID(arr[0]);
                kh.setName(arr[1]);
                kh.setPhone(arr[2]);
                kh.setEmail(arr[3]);
                kh.setLocal(arr[4]);

                listKH.add(kh);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void menu() {
        int n;
        do {
            System.out.println("-------QUẢN LÍ KHÁCH HÀNG-------");
            System.out.println("1.Xem danh sách khách hàng");
            System.out.println("2.Thêm mới một khách hàng.");
            System.out.println("3. Cập nhật thông tin khách hàng.");
            System.out.println("4. Xóa thông tin khách hàng.");
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
        for (int i = 0; i < listKH.size(); i++) {
            listKH.get(i).showInfo();
        }
    }

    public void them() {
        KhachHang kh = new KhachHang();
        kh.add();
//        if (!checkExit(kh.getID())) {
//            listKH.add(kh);
//            this.xem();
//            save();
//        } else {
//            System.err.println("Mã khách hàng đã tồn tại!!!");
//        }
    }
    KhachHang kh = new KhachHang();
    int index = 0;

    public boolean checkExit(String ID) {
        boolean check = false;
        for (int i = 0; i < listKH.size(); i++) {
            kh = listKH.get(i);
            if (ID.equalsIgnoreCase(kh.getID())) {
                check = true;
                index = i;
                break;
            }
        }
        return check;
    }
    //kiểm tra ID đã tồn tại hay chưa

    public boolean timKiem() {
        boolean check = false;
        System.out.println("Mời nhập mã nhân viên cần tìm :");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        for (int i = 0; i < listKH.size(); i++) {
            kh = listKH.get(i);
            if (ID.equalsIgnoreCase(kh.getID())) {
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
            System.out.println("danh sách : " + listKH);
            System.out.println("thông tin khách hàng tìm thấy: ");
            System.out.println("cập nhật thông tin khách hàng : ");

            System.out.println("mã nhân viên " + kh.getID());

            do {
                System.out.println("tên nhân viên cũ : " + kh.getName());
                System.out.println("tên nhân viên mới : ");
                kh.setName(sc.nextLine());
                if (check.ktraTen(kh.getName())) {
                    System.out.println("tên nhân viên không được chứa số hoặc rỗng. ");
                }
            } while (check.ktraTen(kh.getName()));

            do {
                System.out.println("số điện thoại cũ : " + kh.getPhone());
                System.out.println("số điện thoại  mới : ");
                kh.setPhone(sc.nextLine());               
            } while (check.ktraPhone(kh.getPhone()));

            do {
                System.out.println("email cũ : " + kh.getEmail());
                System.out.println("email mới : ");
                kh.setEmail(sc.nextLine());
                if (check.kiemTraEmail(kh.getEmail())) {
                }
            } while (check.kiemTraEmail(kh.getEmail()));

            System.out.println("địa chỉ cũ : " + kh.getLocal());
            System.out.println("địa chỉ mới : ");
            kh.setLocal(sc.nextLine());
            
            save();

        } else {
            System.err.println("không tìm thấy nhân viên ");
        }
    }

    public void xoa() {
        timKiem();
        if (timKiem() == true) {
            System.out.println("thông tin nhân viên tìm thấy : " + kh);
            listKH.remove(kh);
        } else {
            System.err.println("không tìm thấy nhân viên hợp lệ.");
        }
    }

    public void save() {
        try {
            Writer fw = new FileWriter(this.filename);
            BufferedWriter bw = new BufferedWriter(fw);
            String DL = "";
            for (int i = 0; i < listKH.size(); i++) {
                String c = "";
                c += listKH.get(i).getID() + "\t";
                c += listKH.get(i).getName() + "\t";
                c += listKH.get(i).getPhone() + "\t";
                c += listKH.get(i).getEmail() + "\t";
                c += listKH.get(i).getLocal() + "\t";
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

