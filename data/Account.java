package data;

public class Account {
  String soTK;
  String ten;
  double tien;

  public Account(String soTK, String ten, double tien) {
    this.soTK = soTK;
    this.ten = ten;
    this.tien = tien;
  }

  public String getSoTK() {
    return soTK;
  }
  public String getTen(){
    return ten;
  }  
  public double getTien() {
    return tien;
  }
  public void setTien(double tien){
    this.tien = tien;
  }
  public static void showTitle(){
    System.out.printf("|%-12s|%-20s|%-20s|\n", "SO TAI KHOAN", "TEN KHACH HANG", "SO TIEN");
  }
  
  public void showAccount() {
    System.out.printf("|%-12s|%-20s|%-16.3f VND|\n", soTK, ten, tien);
  }
}
