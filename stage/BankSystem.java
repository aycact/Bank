package stage;

import data.Cabinet;
import ui.Menu;


public class BankSystem {

    public static void main(String[] args) {
        Menu menu = new Menu("Hệ thống quản lý ngân hàng");
        menu.addNewOption("1. Thêm tài khoản");
        menu.addNewOption("2. Tìm kiếm bằng id");
        menu.addNewOption("3. Nạp tiền bằng id");
        menu.addNewOption("4. Rút tiền bằng id");
        menu.addNewOption("5. Chuyển khoản bằng id");
        menu.addNewOption("6. Xoá tài khoản bằng id");
        menu.addNewOption("7. In danh sách");
        menu.addNewOption("8. Thoát");
       
        Cabinet cage = new Cabinet(); 
               
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("Bạn đang tạo 1 tài khoản");
                    cage.addAccount();
                    break;
                case 2:
                    System.out.println("Bạn đang tìm kiếm tài khoản bằng id");
                    cage.searchAcount();
                    break;                    
                case 3:
                    System.out.println("Bạn đang nạp tiền bằng id");
                    cage.napTien();
                    break;
                case 4:
                    System.out.println("Bạn đang rút tiền bằng id");
                    cage.rutTien();
                    break;
                case 5:
                    System.out.println("Bạn đang chuyển khoản bằng id");    
                    cage.chuyenKhoan();
                    break;
                case 6:
                    System.out.println("Bạn đang xoá tài khoản bằng id");
                    cage.removeAcount();
                    break;
                case 7:
                    System.out.println("Danh sách tài khoản");
                    cage.printAccountList();
                    break;    
                case 8:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 8);
    }
}
