package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App{
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    //회원 등록
    final int LENGTH = 100;
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] mail = new String[LENGTH];
    String[] pw = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] date = new Date[LENGTH];
    int size = 0;

    //프로젝트
    final int PROJECT_LENGTH =100;
    int[] pno = new int[PROJECT_LENGTH];
    String[] pproject = new String[PROJECT_LENGTH];
    String[] pcontent = new String[PROJECT_LENGTH];
    Date[] pstartDate = new Date[PROJECT_LENGTH];
    Date[] pendDate = new Date[PROJECT_LENGTH];
    String[] powner = new String[PROJECT_LENGTH];
    String[] pmember = new String[PROJECT_LENGTH];
    int psize = 0;

    final int TASK_LENGTH =100;
    int[] tno = new int[TASK_LENGTH];
    String[] tcontent = new String[TASK_LENGTH];
    Date[] tendDate = new Date[TASK_LENGTH];
    int[] tstatus = new int[TASK_LENGTH];
    String[] towner = new String[TASK_LENGTH]; 

    int tsize = 0;

    while (true) {

      System.out.print("명령> ");
      String order = scanner.nextLine();

      if (order.equalsIgnoreCase("/member/add")) {
        System.out.println("[회원 등록]");

        System.out.print("번호? ");
        no[size] = scanner.nextInt();
        scanner.nextLine();

        System.out.print("이름? ");
        name[size] = scanner.nextLine();

        System.out.print("이메일? ");
        mail[size] = scanner.nextLine();

        System.out.print("암호? ");
        pw[size] = scanner.nextLine();

        System.out.print("사진? ");
        photo[size] = scanner.nextLine();

        System.out.print("전화? ");
        tel[size] = scanner.nextLine();

        date[size] = new Date(System.currentTimeMillis());

        size ++;

        System.out.println();

      }else if (order.equalsIgnoreCase("/member/list")) {
        System.out.println("[회원 목록]");

        for(int i = 0; i < size; i++) {

          System.out.printf("%d, %s, %s, %s, %s\n", no[i], name[i], mail[i], tel[i], date[i]);

        }

        System.out.println();

      }else if(order.equalsIgnoreCase("/project/add")) {
        System.out.println("[프로젝트 등록]");

        System.out.print("번호? ");
        pno[psize] = scanner.nextInt();
        scanner.nextLine();

        System.out.print("프로젝트명? ");
        pproject[psize] = scanner.nextLine();

        System.out.print("내용? ");
        pcontent[psize] = scanner.nextLine();

        System.out.print("시작일? ");
        pstartDate[psize] = Date.valueOf(scanner.nextLine());

        System.out.print("종료일? ");
        pendDate[psize] = Date.valueOf(scanner.nextLine());

        System.out.print("만든이? ");
        powner[psize] = scanner.nextLine();

        System.out.print("팀원? ");
        pmember[psize] = scanner.nextLine();

        psize++;

        System.out.println();

      }else if(order.equalsIgnoreCase("/project/list")){
        System.out.println("[프로젝트 목록]");

        for(int i = 0; i < psize; i++) {
          System.out.printf("%d, %s, %s, %s, %s\n", pno[i], pproject[i], pstartDate[i], pendDate[i], powner[i]);
        }
        System.out.println();

      }else if(order.equalsIgnoreCase("/task/add")) {
        System.out.println("[작업 등록]");

        System.out.print("번호? ");
        tno[tsize] = scanner.nextInt();
        scanner.nextLine();

        System.out.print("내용? ");
        tcontent[tsize] = scanner.nextLine();

        System.out.print("완료일? ");
        tendDate[tsize] = Date.valueOf(scanner.nextLine());

        System.out.println("상태? ");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        tstatus[tsize] = Integer.parseInt(scanner.nextLine());

        System.out.print("담당자? ");
        towner[tsize] = scanner.nextLine();

        tsize++;

        System.out.println();
      }else if(order.equalsIgnoreCase("/task/list")) {
        System.out.println("[작업 목록]");

        for(int i = 0; i < tsize; i++) {

          String statusLabel = null;

          switch(tstatus[i]) {
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

          System.out.printf("%d, %s, %s, %s, %s\n", tno[i], tcontent[i], tendDate[i], towner[i], statusLabel);

        }
        System.out.println();
      }else if(order.equalsIgnoreCase("exit")) {
        System.out.println("안녕!");
        break;
      }
    }
    scanner.close();

  }
}
