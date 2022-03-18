package data;
import java.text.NumberFormat;
import java.util.Scanner;
 
public class Account {
 
    private long soTK;
    private String tenTK;
    private double soTienTrongTK;
 
    Scanner sc = new Scanner(System.in);

    public Account() {
    }

    public Account(long soTK, String tenTK, double soTienTrongTK) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTienTrongTK = soTienTrongTK;
    }

    public long getSoTK() {
        return this.soTK;
    }
 
    public void setSoTK(long soTK) {
        this.soTK = soTK;
    }
 
    public String getTenTK() {
        return this.tenTK;
    }
 
    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }
 
    public double getSoTienTrongTK() {
        return this.soTienTrongTK;
    }
 
    public void setSoTienTrongTK(double soTienTrongTK) {
        this.soTienTrongTK = soTienTrongTK;
    }
 
 
    public String toString() {
       
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        return soTK + "-" + tenTK + "-" + str1;
    }
}