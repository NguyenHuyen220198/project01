/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import CheckData.CheckData;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class SanPham {

    private String ID;
    private String name;
    private String soLuong;
    private String donGia;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public SanPham() {
    }

    public SanPham(String ID, String name, String soLuong, String donGia) {
        this.ID = ID;
        this.name = name;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return this.ID + " - " + this.name + " - " + this.donGia;
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        CheckData check = new CheckData();
        System.out.println("Nhập thông tin sản phẩm : ");
        System.out.print("\t-ID: ");
        this.ID = sc.nextLine();

        System.out.print("\t-name: ");
        this.name = sc.nextLine();
        do {
            System.out.print("\t-số lượng: ");
            this.soLuong = sc.nextLine();
            if (check.checkSoLuong(this.soLuong)) {

            }
        } while (check.checkSoLuong(this.soLuong));

        do {

            System.out.print("\t-đơn giá : ");
            this.donGia = sc.nextLine();
            if (check.checkGia(this.donGia)) {

            }
        } while (check.checkGia(this.donGia));

    }

    public void showInfo() {
        System.out.println("Thông tin sản phẩm : ");
        System.out.println("\t-ID : " + this.ID);
        System.out.println("\t-name : " + this.name);
        System.out.println("\t-số lượng : " + this.soLuong);
        System.out.println("\t-đơn giá : " + this.donGia);
    }
}
