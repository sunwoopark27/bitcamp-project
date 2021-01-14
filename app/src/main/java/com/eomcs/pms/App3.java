package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[작업]");
    System.out.print("프로젝트? ");
    String project = scanner.nextLine();

    System.out.print("번호? ");
    int no = scanner.nextInt();
    scanner.nextLine();//스캐너버그

    System.out.print("내용? ");
    String content = scanner.nextLine();

    System.out.print("완료일? ");
    Date endDate = Date.valueOf(scanner.nextLine());

    System.out.println("상태? ");  
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2. 완료 ");
    System.out.print("> ");
    int status = Integer.valueOf(scanner.nextLine());

    System.out.print("담당자? ");
    String manager = scanner.nextLine();

    scanner.close();

    System.out.println("-------------------------------");

    System.out.printf("프로젝트: %s\n", project);
    System.out.printf("번호: %d\n", no);
    System.out.printf("내용: %s\n", content);
    System.out.printf("완료일: %s\n", endDate);
    System.out.print("상태: ");

    switch(status) {
      case 0:
        System.out.println("신규");
        break;
      case 1:
        System.out.println("진행중");
        break;
      case 2:
        System.out.println("완료");
        break;
    }

    System.out.printf("담당자: %s", manager);

  }
}
