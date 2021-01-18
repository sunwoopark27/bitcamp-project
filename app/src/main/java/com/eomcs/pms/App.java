package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

// 1) 회원 데이터를 다루는 메서드를 별도로 분류한다.
//    MemberHandler 클래스를 정의한다.
//    addMember(), listMember()메서드를 MemberHandler 클래스로 옮긴다

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

    no[size] = promptInt("번호? ");

    name[size] = promptString("이름? ");

    mail[size] = promptString("이메일? ");

    pw[size] = promptString("암호? ");

    photo[size] = promptString("사진? ");

    tel[size] = promptString("전화? ");

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

    pno[psize] = promptInt("번호? ");

    pproject[psize] = promptString("프로젝트? ");

    pcontent[psize] = promptString("내용? ");

    pstartDate[psize] = promptDate("시작일? ");

    pendDate[psize] = promptDate("종료일? ");

    powner[psize] = promptString("만든이? ");

    pmember[psize] = promptString("팀원? ");

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

    tno[tsize] = promptInt("번호? ");

    tcontent[tsize] = promptString("내용? ");

    tendDate[tsize] = promptDate("완료일? ");

    tstatus[tsize] = promptInt("상태?\n" + "0: 신규\n" + "1: 진행중\n" + "2: 완료\n" + "> ");

    towner[tsize] = promptString("담당자? ");

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

      //사용자에게 명령어를 입력 받는 코드

      //System.out.print("명령> ");
      //String order = scanner.nextLine();
      String order = promptString("명령> ");

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

  //사용자에게 명령 입력 받는 메소드
  static String promptString(String title){ 
    System.out.print(title);
    return scanner.nextLine(); 
  }

  //명령 string 으로 입력받아서 int 값으로 전환해주는 메소드
  static int promptInt(String title){
    String str = promptString(title);
    return Integer.valueOf(str);
  }

  //입력받은 명령을 Date 값으로 전환해주는 메소드
  static Date promptDate(String title) {
    String str = promptString(title);
    return Date.valueOf(str);
  }
}