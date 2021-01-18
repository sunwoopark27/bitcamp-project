package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App{

  static Scanner scanner = new Scanner(System.in);

  //회원 등록
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] mail = new String[LENGTH];
  static String[] pw = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] date = new Date[LENGTH];
  static int size = 0;

  public static void addMember() {
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
  }

  public static void listMember() {
    System.out.println("[회원 목록]");

    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", no[i], name[i], mail[i], tel[i], date[i]);
    }

    System.out.println();
  }

  //프로젝트
  static final int PROJECT_LENGTH =100;
  static int[] pno = new int[PROJECT_LENGTH];
  static String[] pproject = new String[PROJECT_LENGTH];
  static String[] pcontent = new String[PROJECT_LENGTH];
  static Date[] pstartDate = new Date[PROJECT_LENGTH];
  static Date[] pendDate = new Date[PROJECT_LENGTH];
  static String[] powner = new String[PROJECT_LENGTH];
  static String[] pmember = new String[PROJECT_LENGTH];
  static int psize = 0;

  public static void addProject() {
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
  }

  public static void listProject() {
    System.out.println("[프로젝트 목록]");

    for(int i = 0; i < psize; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", pno[i], pproject[i], pstartDate[i], pendDate[i], powner[i]);
    }
    System.out.println();
  }

  //작업
  static final int TASK_LENGTH =100;
  static int[] tno = new int[TASK_LENGTH];
  static String[] tcontent = new String[TASK_LENGTH];
  static Date[] tendDate = new Date[TASK_LENGTH];
  static int[] tstatus = new int[TASK_LENGTH];
  static String[] towner = new String[TASK_LENGTH]; 
  static int tsize = 0;

  public static void addTask() {
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
    tstatus[tsize] = Integer.valueOf(scanner.nextLine());

    System.out.print("담당자? ");
    towner[tsize] = scanner.nextLine();

    tsize++;

    System.out.println();
  }

  public static void listTask() {
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
  }

  public static void main(String[] args) {



    while (true) {

      System.out.print("명령> ");
      String order = scanner.nextLine();

      if (order.equalsIgnoreCase("/member/add")) {
        addMember();

      }else if (order.equalsIgnoreCase("/member/list")) {
        listMember();

      }else if(order.equalsIgnoreCase("/project/add")) {
        addProject();

      }else if(order.equalsIgnoreCase("/project/list")){
        listProject();

      }else if(order.equalsIgnoreCase("/task/add")) {
        addTask();

      }else if(order.equalsIgnoreCase("/task/list")) {
        listTask();

      }else if(order.equalsIgnoreCase("exit")) {
        System.out.println("안녕!");
        break;
      }else {
        System.out.println("잘못된 명령어입니다.");
      }
    }
    scanner.close();

  }
}