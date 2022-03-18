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

  public void setSoTK(String soTK) {
    this.soTK = soTK;
  }

  public double getTien() {
    return tien;
  }

  public void showAccount() {
    System.out.printf("|%-10s|%-20s|%-24.4f|\n", soTK, ten, tien);
  }

  @Override
  public String toString() {
    return String.format("|%-10s|%-20s|%-24.4f|\n", soTK, ten, tien);
  }
}
