package data;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Cabinet {
    public Account[] account = new Account[1000];
    public int n;
    public Scanner sc = new Scanner(System.in);

    public Cabinet () {

    }
    public void input (Account account) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số tài khoản: ");
        account.setSoTK(sc.next());
        System.out.print("Nhập tên tài khoản: ");
        sc.nextLine();
        account.setTen(sc.nextLine());
        System.out.print("Nhập số tiền trong tài khoản: ");
        account.setTien(sc.nextDouble());
    }

    public void addAcount () {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập khách hàng thứ " + (i+1) + " ");
            account[i] = new Account();
            input(account[i]);
        }
    }

    public void searchAccount () {
        String stk;
        System.out.print("Nhập số tài khoản cần tìm: ");
        stk = sc.next();
        int i = 0;
        while (i < n) {
            if (stk.equals(account[i].getSoTK()) == true) {
                title();
                output(account[i]);
            }
            i++;
        }
        System.out.println("Không tìm thấy tài khoản!");
    }

    public Account searchAccount (String stk) {
        int i = 0;
        while (i < n) {
            if (stk.equals(account[i].getSoTK()) == true) {
                return account[i];
            }
            i++;
        }
        return null;
    }

    public void title () {
        System.out.printf("%20s%20s%20s","Số TK", "Tên TK", "Số tiền");
        System.out.println();
    }

    public void napTien() {
        String stk;
        double tien;
        System.out.print("Nhập số tài khoản cần nạp tiền: ");
        stk = sc.next();
        System.out.print("Nhập số tiền cần nạp: ");
        tien = sc.nextDouble();
        if (searchAccount(stk) != null) {
            searchAccount(stk).setTien(searchAccount(stk).getTien()+tien);
            System.out.println("Nạp tiền thành công!");
        }
        else {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }

    public void rutTien() {
        String stk;
        double tien;
        System.out.print("Nhập số tài khoản cần rút tiền: ");
        stk = sc.next();
        System.out.print("Nhập số tiền cần rút: ");
        tien = sc.nextDouble();
        if (searchAccount(stk) != null) {
            if (searchAccount(stk).getTien() > tien) {
                searchAccount(stk).setTien(searchAccount(stk).getTien() - tien);
                System.out.println("Rút tiền thành công!");
            }
            else {
                System.out.println("Tài khoản không đủ để rút!");
            }
        }
        else {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }

    public void chuyenKhoan() {
        String stkchuyen;
        String stknhan;
        double tien;
        boolean check = false;
        System.out.print("Nhập số tài khoản chuyển: ");
        stkchuyen = sc.next();
        System.out.print("Nhập só tài khoản nhận: ");
        stknhan = sc.next();
        System.out.print("Nhập số tiền cần chuyển: ");
        tien = sc.nextDouble();
        if (searchAccount(stkchuyen) != null) {
            if (searchAccount(stkchuyen).getTien() > tien) {
                searchAccount(stkchuyen).setTien(searchAccount(stkchuyen).getTien()-tien);
                check = true;
            }
            else {
                System.out.println("Tài khoản không đủ để chuyển!");
            }
        }
        else {
            System.out.println("Không tìm thấy tài khoản!");
        }

        if (check == true) {
            if (searchAccount(stknhan) != null) {
                searchAccount(stkchuyen).setTien(searchAccount(stknhan).getTien() + tien);
                System.out.println("Chuyển khoản thành công!");
            }
        }
        else {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }


    public void output (Account account) {
        System.out.printf("%20s%20s%20s",account.getSoTK(),account.getTen(),account.getTien());
        System.out.println();
    }

    public void printAccountList () {
        title();
        int i = 0;
        while (i < n) {
            output(account[i]);
            i++;
        }
    }

    public void removeAccount () {
        String stk;
        System.out.print("Nhập số tài khoản cần xóa: ");
        stk = sc.next();
        if (searchAccount(stk) != null) {
            int i = 0;
            n -= 1;
            while (i < n) {
                if (searchAccount(stk) == account[i]) {
                    for (int j = i; j < n; j++) {
                        account[j] = account[j+1];
                    }
                    System.out.println("Xóa tài khoản thành công!");
                    break;
                }
                i++;
            }
        } else {
            System.out.println("Không tìm thấy tài khoản cần xóa!");
        }
    }
}
