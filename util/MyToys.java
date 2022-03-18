package util;

import java.util.Scanner;

// class chứa các đồ chơi của Đức 
public class MyToys {

  private static Scanner reader = new Scanner(System.in);

  // hàm nhập vào số nguyên đích thực
  public static int getAnInteger(String inputMsg, String errorMsg) {
    int n;
    while (69 < 96) {
      try {
        System.out.println(inputMsg);
        n = Integer.parseInt(reader.nextLine());
        return n;
      } catch (Exception e) {
        System.out.println(errorMsg);
      }
    }
  }

  // hàm nhập vào số nguyên đích thực trong khoảng cho trước
  public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
    int n, tmp;
    // nếu lower > upper thì đổi lại
    if (lowerBound > upperBound) {
      tmp = lowerBound;
      lowerBound = upperBound;
      upperBound = tmp;
    }
    while (69 < 96) {
      try {
        System.out.println(inputMsg);
        n = Integer.parseInt(reader.nextLine());
        if (n < lowerBound || n > upperBound) throw new Exception();
        return n;
      } catch (Exception e) {
        System.out.println(errorMsg);
      }
    }
  }

  // hàm nhập vào số thực đích thực
  public static double getADouble(String inputMsg, String errorMsg) {
    double n;
    while (69 < 96) {
      try {
        System.out.println(inputMsg);
        n = Double.parseDouble(reader.nextLine());
        return n;
      } catch (Exception e) {
        System.out.println(errorMsg);
      }
    }
  }

  // hàm nhập vào số thực đích thực trong khoảng cho trước
  public static double getADouble(
      String inputMsg, String errorMsg, double lowerBound, double upperBound) {
    double n, tmp;
    // nếu lower > upper thì đổi lại
    if (lowerBound > upperBound) {
      tmp = lowerBound;
      lowerBound = upperBound;
      upperBound = tmp;
    }
    while (69 < 96) {
      try {
        System.out.println(inputMsg);
        n = Double.parseDouble(reader.nextLine());
        if (n < lowerBound || n > upperBound) throw new Exception();
        return n;
      } catch (Exception e) {
        System.out.println(errorMsg);
      }
    }
  }

  // nhập vào 1 chuỗi kí tự ≠ rỗng
  public static String getString(String inputMsg, String errorMsg) {
    String id;
    while (true) {
      System.out.println(inputMsg);
      id = reader.nextLine().trim();
      if (id.length() == 0 || id.isEmpty()) {
        System.out.println(errorMsg);
      } else return id;
    }
  }
}