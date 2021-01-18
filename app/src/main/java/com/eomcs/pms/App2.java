package com.eomcs.pms;

import java.sql.Date; //date import
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {

    Scanner keyScan = new Scanner(System.in);

    System.out.println("[프로젝트]");

    System.out.print("번호? ");
    int number = keyScan.nextInt();
    keyScan.nextLine();

    System.out.print("프로젝트명? ");
    String title = keyScan.nextLine();

    System.out.print("내용? ");
    String content = keyScan.nextLine();

    System.out.print("시작일? ");
    Date startDate = Date.valueOf(keyScan.nextLine());
    //사용자가 입력한 날짜 문자열을 date 도구(=객체)로 return

    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyScan.nextLine());

    System.out.print("만든이? ");
    String manager = keyScan.nextLine();

    System.out.print("팀원? ");
    String members = keyScan.nextLine();

    keyScan.close();

    System.out.println("----------------------------------");
    System.out.printf("번호: %d\n", number);
    System.out.printf("프로젝트명: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("만든이: %s\n", manager);
    System.out.printf("팀원: %s\n", members);

  }
}
