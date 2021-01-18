package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2{
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    final int LENGTH = 3;
    int[] no = new int[LENGTH];
    String[] project = new String[LENGTH];
    String[] content = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    String[] owner = new String[LENGTH];
    String[] member = new String[LENGTH];

    int size = 0;

    System.out.println("[프로젝트]");

    for(int i = 0; i < LENGTH; i++) {

      System.out.print("번호? ");
      no[i] = scanner.nextInt();
      scanner.nextLine();

      System.out.print("프로젝트명? ");
      project[i] = scanner.nextLine();

      System.out.print("내용? ");
      content[i] = scanner.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(scanner.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(scanner.nextLine());

      System.out.print("만든이? ");
      owner[i] = scanner.nextLine();

      System.out.print("팀원? ");
      member[i] = scanner.nextLine();

      size++;

      System.out.println();
      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String response = scanner.nextLine();
      if(response.length() == 0 || response.equalsIgnoreCase("n")) {
        break;
      }

      System.out.println();
    }

    System.out.println("-----------------------------------------------");

    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", no[i], project[i], startDate[i], endDate[i], owner[i]);
    }
    scanner.close();
  }
}
