package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboardScan = new Scanner(System.in);

  //Member
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] registeredDate = new Date[LENGTH];
  static int size = 0;

  //Project
  static final int PLENGTH = 100;
  static int[] pno = new int[PLENGTH];
  static String[] ptitle = new String[PLENGTH];
  static String[] pcontent = new String[PLENGTH];
  static Date[] pstartDate = new Date[PLENGTH];
  static Date[] pendDate = new Date[PLENGTH];
  static String[] powner = new String[PLENGTH];
  static String[] pmembers = new String[PLENGTH];
  static int psize = 0;

  //Task
  static final int TLENGTH = 100;
  static int[] tno = new int[TLENGTH];
  static String[] tcontent = new String[TLENGTH];
  static Date[] tdeadline = new Date[TLENGTH];
  static String[] towner = new String[TLENGTH];
  static int[] tstatus = new int[TLENGTH];
  static int tsize = 0;


  public static void main(String[] args) {

    while(true) {

      System.out.print("명령> ");
      String command = keyboardScan.nextLine();

      if(command.equalsIgnoreCase("/member/add")) {

        System.out.println("[회원 등록]");

        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        name[size] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        email[size] = keyboardScan.nextLine();

        System.out.print("암호? ");
        password[size] = keyboardScan.nextLine();

        System.out.print("사진? ");
        photo[size] = keyboardScan.nextLine();

        System.out.print("전화? ");
        tel[size] = keyboardScan.nextLine();

        registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

        size++;
        System.out.println(); // 빈 줄 출력


      }else if(command.equalsIgnoreCase("/member/list")){

        System.out.println("[회원 목록]");

        for (int i = 0; i < size; i++) {
          // 번호, 이름, 이메일, 전화, 가입일
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], name[i], email[i], tel[i], registeredDate[i]);
        }
        System.out.println();
      }else if(command.equalsIgnoreCase("/project/add")){
        System.out.println("[프로젝트 등록]");


        System.out.print("번호? ");
        pno[psize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("프로젝트명? ");
        ptitle[psize] = keyboardScan.nextLine();

        System.out.print("내용? ");
        pcontent[psize] = keyboardScan.nextLine();

        System.out.print("시작일? ");
        pstartDate[psize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("종료일? ");
        pendDate[psize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("만든이? ");
        powner[psize] = keyboardScan.nextLine();

        System.out.print("팀원? ");
        pmembers[psize] = keyboardScan.nextLine();

        psize++;
        System.out.println(); // 빈 줄 출력

      }else if(command.equalsIgnoreCase("/project/list")) {
        System.out.println("[프로젝트 목록]");

        for (int i = 0; i < psize; i++) {
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              pno[i], ptitle[i], pstartDate[i], pendDate[i], powner[i]);
        }
        System.out.println();
      }else if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")){
        System.out.println("안녕!");
        break;
      }else if(command.equalsIgnoreCase("/task/add")) {
        System.out.println("[작업 등록]");

        System.out.print("번호? ");
        tno[tsize] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("내용? ");
        tcontent[tsize] = keyboardScan.nextLine();

        System.out.print("마감일? ");
        tdeadline[tsize] = Date.valueOf(keyboardScan.nextLine());

        System.out.println("상태?");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        tstatus[tsize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("담당자? ");
        towner[tsize] = keyboardScan.nextLine();

        tsize++;
        System.out.println(); // 빈 줄 출력

      }else if(command.equalsIgnoreCase("/task/list")) {
        System.out.println("[작업 목록]");

        for (int i = 0; i < tsize; i++) {
          String stateLabel = null;
          switch (tstatus[i]) {
            case 1:
              stateLabel = "진행중";
              break;
            case 2:
              stateLabel = "완료";
              break;
            default:
              stateLabel = "신규";
          }
          // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              tno[i], tcontent[i], tdeadline[i], stateLabel, towner[i]);
        }
        System.out.println();
      }else {
        System.out.println("명령어를 잘못 입력하셨습니다.");
        System.out.println();
      }

    }
    keyboardScan.close();

  }
}
