package data;

//import data.Account;
import util.MyToys;
import java.util.ArrayList;

public class Cabinet {
  // list lưu trữ các Account
  private ArrayList<Account> arr = new ArrayList<>();

  public void addAccount() {
    String soTK, ten;
    double tien;
    //kiểm tra nhập số tài khoản, không cho trùng
    while (true) {
      soTK = MyToys.getString("Vui lòng nhập số tài khoản:", "Vui lòng nhập lại!");
      if (searchAccount(soTK) != null) {
        System.out.println("Số tài khoản này đã tồn tại! Vui lòng tạo số tài khoản khác!");
      } else {
        break;
      }
    }
    ten = MyToys.getString("Vui lòng nhập tên:", "Vui lòng nhập lại!");
    tien = MyToys.getADouble("Vui lòng nhập số tiền:", "Vui lòng nhập lại!", 0, 30_000_000);
    // thêm 1 Account vào mảng
    arr.add(new Account(soTK, ten, tien));
    System.out.println("------------------------------------");
    System.out.println("Tạo tài khoản thành công!");
  }
  // in danh sách tài khoản
  public void printAccountList() {
    Account.showTitle();
    for (Account x : arr) {
      x.showAccount();
    }
  }

  /* CÁC HÀM TÌM KIẾM */

  public Account searchAccount(String soTK) {
    if (arr.isEmpty()) {
      return null;
    }
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i).getSoTK().equalsIgnoreCase(soTK)) {
        return arr.get(i);
      }
    }
    return null;
  }

  public void searchAccount() {
    String soTK;
    soTK = MyToys.getString("Vui lòng nhập số tài khoản bạn muốn tìm:", "Vui lòng nhập lại!");
    Account x = searchAccount(soTK);
    System.out.println("------------------------------------");
    if (x == null) {
      System.out.println("Không tìm thấy!");
    } else {
      System.out.println("Tìm thấy: " + x.getTen() + "!");
      Account.showTitle();
      x.showAccount();
    }
  }

  public int searchPosOfAccount(String soTK) {
    if (arr.isEmpty()) return -1; // ko tìm gì cả
    // quét hết list, coi có trùng id nào ko, thì trả về vị trí
    for (int i = 0; i < arr.size(); i++) if (arr.get(i).getSoTK().equalsIgnoreCase(soTK)) return i;
    return -1;
  }

  // hàm xoá 1 Account
  public void removeAccount() {
    String soTK;
    int pos; // vị trí tìm thấy
    soTK = MyToys.getString("Nhập số tài khoản muốn xoá:", "Vui lòng nhập lại");
    pos = searchPosOfAccount(soTK);
    System.out.println("------------------------------------");
    if (pos == -1) System.out.println("Không tìm thấy!");
    else {
      arr.remove(pos);
      System.out.println("Đã xoá thành công!");
    }
  }

  public void napTien() {
    String soTK;
    double tien;
    soTK = MyToys.getString("Vui lòng nhập số tài khoản bạn muốn nạp tiền:", "Vui lòng nhập lại!");
    Account x = searchAccount(soTK);
    if (x == null) {
      System.out.println("Không tìm thấy!");
    } else {
      System.out.println("Tìm thấy: " + x.getTen() + "!");
      Account.showTitle();
      x.showAccount();
      tien =
          MyToys.getADouble(
              "Nhập số tiền muốn nạp (Tối đa 30 triệu/lần):", "Vui lòng nhập lại!", 0, 30_000_000);
      x.setTien(x.getTien() + tien);
      System.out.println("------------------------------------");
      System.out.println("Nạp tiền thành công!");
      Account.showTitle();
      x.showAccount();
    }
  }

  public void rutTien() {
    String soTK;
    double tien;
    soTK = MyToys.getString("Vui lòng nhập số tài khoản bạn muốn rút tiền:", "Vui lòng nhập lại!");
    Account x = searchAccount(soTK);
    if (x == null) {
      System.out.println("Không tìm thấy!");
    } else {
      System.out.println("Tìm thấy: " + x.getTen() + "!");
      Account.showTitle();
      x.showAccount();
      tien =
          MyToys.getADouble(
              "Nhập số tiền muốn muốn rút (Tối đa 30 triệu/lần):",
              "Vui lòng nhập lại! Số tiền tối đa có thể rút là: " + x.getTien() + " VND!",
              0,
              x.getTien());
      System.out.println("------------------------------------");
      x.setTien(x.getTien() - tien);
      System.out.println("Rút tiền thành công!");
      Account.showTitle();
      x.showAccount();
    }
  }

  public void chuyenKhoan() {
    if (arr.size() < 2) {
      System.out.println("Không đủ số lượng tài khoản để thực hiện!");
      return;
    }
    String soTKChuyen, soTKNhan;
    double tien;

    soTKChuyen = MyToys.getString("Nhập số tài khoản chuyển: ", "Vui lòng nhập lại!");
    Account x1 = searchAccount(soTKChuyen);
    if (x1 == null) {
      System.out.println("Không tìm thấy!");
      return;
    } else {
      System.out.println("Tìm thấy: " + x1.getTen() + "!");
      Account.showTitle();
      x1.showAccount();
    }

    soTKNhan = MyToys.getString("Nhập số tài khoản nhận: ", "Vui lòng nhập lại!");
    Account x2 = searchAccount(soTKNhan);
    if (x2 == null) {
      System.out.println("Không tìm thấy!");
      return;
    } else {
      System.out.println("Tìm thấy: " + x2.getTen() + "!");
      Account.showTitle();
      x2.showAccount();
    }

    tien =
        MyToys.getADouble(
            "Nhập số tiền cần chuyển (Tối đa 30 triệu/lần): ",
            "Vui lòng nhập lại! Số tiền tối đa có thể chuyển là " + x1.getTien() + " VND!",
            0,
            x1.getTien());

    x1.setTien(x1.getTien() - tien);
    x2.setTien(x2.getTien() + tien);
    System.out.println("------------------------------------");
    System.out.println("Chuyển khoản thành công!");
    Account.showTitle();
    x1.showAccount();
    x2.showAccount();
  }
}
