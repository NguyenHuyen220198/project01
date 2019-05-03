/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckData;

/**
 *
 * @author Administrator
 */
public class CheckData {

    public boolean ktraTen(String name) {
        for (int i = 0; i < 10; i++) {
            if (name.contains(i + "") == true || name.equalsIgnoreCase("")) {
                return true;
            }
        }
        return false;
    }

    public boolean ktraPhone(String phone) {
        boolean check = false;
        try {
            if (phone.startsWith(0 + "") == false) {
                System.out.println("số điện thoại phải bắt đầu bằng số 0");
                check = true;
            } else if (phone.length() < 10 || phone.length() > 11) {
                System.out.println("số điện thoại phải có 10 hoặc 11 số.");
                check = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("số điện thoại không được nhập chữ.");
            check = true;
        } catch (Exception e) {
            System.out.println("Fail" + e.getMessage());
            check = true;
        }

        return check;
    }

    public boolean kiemTraEmail(String email) {
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        if (ktEmail == false) {
            System.err.println("Email sai, nhập lại theo dạng abc@domain.com");
            return true;
        }
        return false;
        // String dinhDangEmail nó giống như là format chuẩn cho email mình nhập vào, nếu sai cái
        // dịnh dạng này thì là lỗi.
        // Hàm matches dùng để xác định xem chuỗi email của mình có khớp với định dạng mình đã quy 
        // định trước hay không. hàm này trả về true , false nên mình khởi tạo 1 biến ktEmail rồi gán
        // cho nó. false thì báo lỗi.
    }

    public boolean checkSoLuong(String soLuong) {
        try {

            int SL = Integer.parseInt(soLuong);
            if (SL < 0) {
                System.out.println("số lượng sản phẩm phải lớn hơn 0.");
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("số lượng sản phẩm không được chứa chữ.");
            return true;
        } catch (Exception e) {
            System.out.println("Fail" + e.getMessage());
            return true;
        }

        return false;
    }

    public boolean checkGia(String gia) {
        try {

            int G = Integer.parseInt(gia);
            if (G < 0) {
                System.out.println("giá sản phẩm phải lớn hơn 0!!");
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("giá sản phẩm không được chứa chữ");
            return true;
        } catch (Exception e) {
            System.out.println(" Fail" + e.getMessage());
            return true;
        }
        return false;
    }
}
