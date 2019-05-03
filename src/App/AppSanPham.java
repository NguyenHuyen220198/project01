/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import CheckData.CheckData;
import Object.SanPham;
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
public class AppSanPham {

    ArrayList<SanPham> listSP = new ArrayList();
    private String filename = "SanPham.txt";

    public void loadfile() {
        try {
            InputStream in = new FileInputStream(filename);
            Reader read = new InputStreamReader(in, "UTF-8");

            String Info;

            BufferedReader br = new BufferedReader(read);
            while ((Info = br.readLine()) != null) {
                String arr[] = Info.split("\t");
                SanPham sp = new SanPham();
                sp.setID(arr[0]);
                sp.setName(arr[1]);
                sp.setSoLuong(arr[2]);
                sp.setSoLuong(arr[3]);

                listSP.add(sp);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void menu() {
        int n;
        do {
            System.out.println("-------QUẢN LÍ SẢN PHẨM-------");
            System.out.println("1.Xem danh sách sản phẩm");
            System.out.println("2.Tìm kiếm sản phẩm theo mã.");
            System.out.println("3. Cập nhật thông tin sản phẩm.");
            System.out.println("4.Thêm mới một sản phẩm ");
            System.out.println("5.Xóa thông tin sản phẩm.");
            System.out.println("6. Thoát.");
            System.out.println("Mời bạn nhập lựa chọn.");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            switch (n) {
                case 1:
                    this.xem();
                    break;
                case 2:
                    this.timKiem();
                    break;
                case 3:
                    this.capNhat();
                    break;
                case 4:
                    this.them();
                    break;
                case 5:
                    this.xoa();
                    break;
                case 6:
                    System.out.println("thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("không hợp lệ");
            }
        } while (n != 6);

    }

    public void xem() {
        for (int i = 0; i < listSP.size(); i++) {
            listSP.get(i).showInfo();
        }
    }

    public void them() {
        SanPham sp = new SanPham();
        sp.add();
        if (!checkExit(sp.getID())) {
            listSP.add(sp);
            this.xem();
            save();
        } else {
            System.err.println("Mã sản phẩm đã tồn tại!!!");
        }
    }
    SanPham sp = new SanPham();
    int index = 0;

    public boolean checkExit(String ID) {
        boolean check = false;
        for (int i = 0; i < listSP.size(); i++) {
            sp = listSP.get(i);
            if (ID.equalsIgnoreCase(sp.getID())) {
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
        System.out.println("Mời nhập mã sản phẩm cần tìm :");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        for (int i = 0; i < listSP.size(); i++) {
            sp = listSP.get(i);
            if (ID.equalsIgnoreCase(sp.getID())) {
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
            System.out.println("danh sách : " + listSP);
            System.out.println("thông tin sản phẩm tìm thấy: ");
            System.out.println("cập nhật thông tin sản phẩm : ");

            System.out.println("mã sản phẩm  " + sp.getID());

            System.out.println("tên sản phẩm cũ : " + sp.getName());
            System.out.println("tên sản phẩm mới : ");
            sp.setName(sc.nextLine());

            do {
                System.out.println("số lượng cũ : " + sp.getSoLuong());
                System.out.println("số lượng mới : ");
                sp.setSoLuong(sc.nextLine());
                if (check.checkSoLuong(sp.getSoLuong())) {

                }
            } while (check.checkSoLuong(sp.getSoLuong()));

            do {
                System.out.println("đơn giá cũ : " + sp.getDonGia());
                System.out.println("đơn giá mới : ");
                sp.setDonGia(sc.nextLine());
                if(check.checkGia(sp.getDonGia())){
                    
                }
            } while (check.checkGia(sp.getDonGia()));

            listSP.set(index, sp);
            System.out.println("danh sách " + listSP);
            save();

        } else {
            System.err.println("không tìm thấy sản phẩm ");
        }
    }

    public void xoa() {
        timKiem();
        if (timKiem() == true) {
            System.out.println("thông tin  sản phẩm tìm thấy : " + sp);
            listSP.remove(sp);
        } else {
            System.err.println("không tìm thấy  sản phẩm hợp lệ.");
        }
    }

    public void save() {
        try {
            Writer fw = new FileWriter(this.filename);
            BufferedWriter bw = new BufferedWriter(fw);
            String DL = "";
            for (int i = 0; i < listSP.size(); i++) {
                String c = "";
                c += listSP.get(i).getID() + "\t";
                c += listSP.get(i).getName() + "\t";
                c += listSP.get(i).getSoLuong() + "\t";
                c += listSP.get(i).getDonGia() + "\t";
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
