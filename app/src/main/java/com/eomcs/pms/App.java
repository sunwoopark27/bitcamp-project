package com.eomcs.pms;

public class App {

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;

    java.util.Scanner keyScan = new java.util.Scanner(keyboard);

    System.out.println("[회원]");

    System.out.print("번호? ");
    String id = keyScan.nextLine();

    System.out.print("이름? ");
    String name = keyScan.nextLine();

    System.out.print("이메일? ");
    String email = keyScan.nextLine();

    System.out.print("암호? ");
    String pw = keyScan.nextLine();

    System.out.print("사진? ");
    String photo = keyScan.nextLine();

    System.out.print("전화? ");
    String phoneNum = keyScan.nextLine();

    java.util.Date today = new java.util.Date();

    keyScan.close();

    System.out.println("----------------------------------");
    System.out.printf("번호 : %s\n", id);
    System.out.printf("이름 : %s\n", name);
    System.out.printf("이메일 : %s\n", email);
    System.out.printf("암호 : %s\n", pw);
    System.out.printf("사진 : %s\n", photo);
    System.out.printf("전화 : %s\n", phoneNum);
    System.out.printf("가입일 : %1$tY-%1$tm-%1$td\n",today);






  }
}
