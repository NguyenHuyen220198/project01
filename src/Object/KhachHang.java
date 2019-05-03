/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import App.AppKhachHang;
import CheckData.CheckData;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class KhachHang {
    private String ID;
    private String name;
    private String phone;
    private String email;
    private String local;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public KhachHang() {
    }

    public KhachHang(String ID, String name, String phone, String email, String local) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.local = local;
    }

    @Override
    public String toString() {
        return this.ID+" - "+ this.name+ " - "+ this.local;
    }
    public void add(){
        AppKhachHang kh = new AppKhachHang();
        Scanner sc = new Scanner(System.in);
        CheckData check = new CheckData();
        System.out.println("Nhập thông tin nhân viên : ");
        do {
            System.out.print("\t-ID: ");
            this.ID = sc.nextLine();
            System.out.println("khách hàng đã tồn tại!!!");
        } while (!kh.checkExit(this.ID));
       
        do {
            System.out.print("\t-name: ");
            this.name = sc.nextLine();
            if (check.ktraTen(this.name)){
                System.out.println("tên khách hàng không được chứa số!");
            }
        } while (check.ktraTen(this.name));
        
        do {
            System.out.print("\t-phone: ");
            this.phone = sc.nextLine();
        } while (check.ktraPhone(this.phone));
        
        do {
             System.out.print("\t-email: ");
             this.email = sc.nextLine();
             if(check.kiemTraEmail(this.email)){
                 
             }
        } while (check.kiemTraEmail(this.email));
        
        System.out.print("\t-local: ");
        this.local= sc.nextLine();
        
    }
    
    public void showInfo(){
            System.out.println("Thông tin nhân viên : ");
            System.out.println("\t-ID : "+ this.ID);
            System.out.println("\t-name : "+this.name);
            System.out.println("\t-phone : "+this.phone);
            System.out.println("\t-email : "+this.email);
            System.out.println("\t-local : "+this.local);
    }
}
