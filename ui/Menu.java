package ui;

import java.util.ArrayList;
import util.MyToys;

public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList<>();
    //chứa các lựa chọn/ thực đơn

    //khởi tạo tên menu
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
        
    //bổ sung một lựa chọn vào danh sách, bắt đầu xây dựng thực đơn/
    //lựa chọn của chương trình
    public void addNewOption(String newOption) {
        // thêm lựa chọn 
        optionList.add(newOption);        
    }
    
    //in ra danh sách các lựa chọn
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("Không có lựa chọn nào ");
            return;
        }
        System.out.println("\n------------------------------------");
        System.out.println("Chào mừng đến với " + menuTitle);
        for (String x : optionList)
            System.out.println(x);  
    }
    
    // hàm lưu lựa chọn 
    public int getChoice() {
        int maxOption = optionList.size();
        //lựa chọn lớn nhất là số thứ tự ứng với số mục chọn
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption; 
        return MyToys.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
}
