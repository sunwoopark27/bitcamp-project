package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  Node first;
  Node last;
  int size = 0;
  MemberHandler memberHandler;

  // 생성자 정의
  // - ProjectHandler가 의존하는 객체를 반드시 주입하도록 강요한다.
  // - 다른 패키지에서 생성자를 호출할 수 있도록 공개한다.
  public ProjectHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project p = new Project();

    p.no = Prompt.inputInt("번호? ");
    p.title = Prompt.inputString("프로젝트명? ");
    p.content = Prompt.inputString("내용? ");
    p.startDate = Prompt.inputDate("시작일? ");
    p.endDate = Prompt.inputDate("종료일? ");

    p.owner = inputMember("만든이?(취소: 빈 문자열) ");
    if (p.owner == null) {
      System.out.println("프로젝트 입력을 취소합니다.");
      return;
    }

    p.members = inputMembers("팀원?(완료: 빈 문자열) ");

    Node node = new Node(p);

    if (last == null) {
      last = node;
      first = node;
      //prev = null;
    }else {
      last.next = node;
      node.prev = last;
      last = node;
    }
    this.size++;

  }

  public void list() {
    System.out.println("[프로젝트 목록]");

    Node cursor = first;

    while(cursor != null) {
      Project p = cursor.project;

      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          p.no, p.title, p.startDate, p.endDate, p.owner, p.members);

      cursor = cursor.next;
    }
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);
    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.title);
    System.out.printf("내용: %s\n", project.content);
    System.out.printf("시작일: %s\n", project.startDate);
    System.out.printf("종료일: %s\n", project.endDate);
    System.out.printf("관리자: %s\n", project.owner);
    System.out.printf("팀원: %s\n", project.members);

  }

  public void update() {
    System.out.println("[프로젝트 변경]");

    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);
    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.startDate));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));

    String owner = inputMember(String.format("만든이(%s)?(취소: 빈 문자열) ", project.owner));
    if (owner == null) {
      System.out.println("프로젝트 변경을 취소합니다.");
      return;
    }

    String members = inputMembers(
        String.format("팀원(%s)?(완료: 빈 문자열) ", project.members));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      project.title = title;
      project.content = content;
      project.startDate = startDate;
      project.endDate = endDate;
      project.owner = owner;
      project.members = members;

      System.out.println("프로젝트을 변경하였습니다.");

    } else {
      System.out.println("프로젝트 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");

    int no = Prompt.inputInt("번호? ");

    Project p = findByNo(no);
    if (p == null) {
      System.out.println("해당 번호의 프로젝트이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      Node cursor = first;
      while(cursor != null) {
        if(cursor.project == p) {
          if(first == last) { //노드가 하나일 경우
            first = null;
            last = null;
          }else if(cursor == first){ //첫번째 노드일 경우
            first = cursor.next;
            first.prev = null;
          }else if(cursor == last) { //마지막 노드일경우
            cursor.prev.next = null;
            last = cursor.prev;
          }else{//중간에 다른 노드들
            cursor.prev.next = cursor.next;
            if(cursor.next !=null) {
              cursor.next.prev = cursor.prev;
            }
          }
          this.size--;
          break;
        }
        cursor = cursor.next;
      }
      System.out.println("프로젝트을 삭제하였습니다.");

    } else {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
    }

  }


  // 프로젝트 번호에 해당하는 인스턴스를 찾아 리턴한다.
  Project findByNo(int projectNo) {
    Node cursor = this.first;
    while(cursor != null) {
      if(projectNo  == cursor.project.no) {
        return cursor.project;
      }
      cursor = cursor.next;
    }
    return null;
  }

  String inputMember(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } 
      if (this.memberHandler.exist(name)) {
        return name;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  String inputMembers(String promptTitle) {
    String members = "";
    while (true) {
      String name = inputMember(promptTitle);
      if (name == null) {
        return members;
      } else {
        if (!members.isEmpty()) {
          members += ",";
        }
        members += name;
      }
    }
  }

  static class Node{
    Project project;
    Node next;
    Node prev;

    Node(Project p){
      this.project = p;
    }
  }

}








