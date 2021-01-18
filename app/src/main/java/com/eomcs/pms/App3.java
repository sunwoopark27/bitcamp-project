package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int LENGTH =3;
    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] endDate = new Date[LENGTH];
    int[] status = new int[LENGTH];
    String[] owner = new String[LENGTH]; 

    int size = 0;

    System.out.println("[작업]");

    System.out.print("프로젝트? ");
    String project = scanner.nextLine();

    for(int i = 0; i < 3; i++) {

      System.out.print("번호? ");
      no[i] = scanner.nextInt();
      scanner.nextLine();

      System.out.print("내용? ");
      content[i] = scanner.nextLine();

      System.out.print("완료일? ");
      endDate[i] = Date.valueOf(scanner.nextLine());

      System.out.println("상태? ");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      System.out.print("> ");
      status[i] = Integer.parseInt(scanner.nextLine());

      System.out.print("담당자? ");
      owner[i] = scanner.nextLine();

      size++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String response = scanner.nextLine();
      if(response.length() == 0 || response.equalsIgnoreCase("n")) {
        break;
      }

      System.out.println();

    }

    System.out.println("--------------------------------");

    System.out.printf("[%s]\n", project);

    for(int i = 0; i < size; i++) {

      String statusLabel = null;

      switch(status[i]) {
        case 0:
          statusLabel = "신규";
          break;
        case 1:
          statusLabel = "진행중";
          break;
        case 2:
          statusLabel = "완료";
          break;
      }

      System.out.printf("%d, %s, %s, %s, %s\n", no[i], content[i], endDate[i], statusLabel, owner[i]);

    }


    scanner.close();
  }
}