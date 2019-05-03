/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_Main;

import App.AppKhachHang;
import App.AppNhanVien;
import App.AppSanPham;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        
        int n;
        do {
            System.out.println("---------------------------------------");
            System.out.println("-------HỆ THỐNG QUẢN LÍ BÁN HÀNG-------");
            System.out.println("1.Quản lí nhân viên ");
            System.out.println("2.Quản lí khách hàng.");
            System.out.println("3.Quản lí sản phẩm.");
            System.out.println("4.Thoát.");
            System.out.println("Mời bạn chọn chức năng.");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            switch (n) {
                case 1: {
                    AppNhanVien nvapp = new AppNhanVien();
                    nvapp.loadfile();
                    nvapp.menu();
                }
                break;
                case 2: {
                    AppKhachHang khapp = new AppKhachHang();
                    khapp.loadfile();
                    khapp.menu();
                }
                break;
                case 3: {
                    AppSanPham spapp = new AppSanPham();
                    spapp.loadfile();
                    spapp.menu();
                }
                break;
                case 4:
                    System.out.println("thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("không hợp lệ");
            }
        } while (n != 4);
        System.out.println("Many Thanks!!!");
    }
}
