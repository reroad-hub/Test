import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    static Scanner input = new Scanner(System.in);
    private final ArrayList<Student> students = new ArrayList<>();
    private final Admin admin = new Admin();
    int currentStudentIndex = 0;

    public GradeManager() {
        students.add(new Student("messi", "메시"));
        students.add(new Student("ronaldo", "호날두"));
        students.add(new Student("park", "박지성"));
        students.add(new Student("son", "손흥민"));
        students.add(new Student("cha", "차두리"));
    }

    public void run() {
        while (true) {
            System.out.println("<<성적처리>>");
            System.out.println("1.관리자 로그인");
            System.out.println("2.종료");

            int select = input.nextInt();
            input.nextLine();

            if (select == 1) {
                if (adminLogin())
                    menuGradeSelect();
            } else if (select == 2) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못 입력하였습니다.");
            }
        }
    }

    public boolean adminLogin() {
        System.out.println("<<관리자의 정보를 입력하세요>>");
        System.out.print("이름: ");
        String name = input.nextLine();
        System.out.print("전화번호: ");
        String phone = input.nextLine();

        System.out.print("관리자 ID: ");
        String inputId = input.nextLine();
        System.out.print("관리자 PW: ");
        String inputPw = input.nextLine();

        if (admin.login(inputId, inputPw)) {
            System.out.println(inputId + "관리자님 반갑습니다.");
            System.out.print("*".repeat(50));
            return true;
        } else {
            System.out.println("관리자 계정이 틀렸습니다.");
            return false;
        }

    }

    public void menuGradeSelect() {
        while (true) {
            System.out.println("<<성적처리>>");
            System.out.println("1.성적 입력");
            System.out.println("2.성적 검색");
            System.out.println("3.전체 성적 출력");
            System.out.println("4.로그아웃");
            int select = input.nextInt();
            input.nextLine();

            switch (select) {
                case 1:
                    gradeInput();
                    break;
                case 2:
                    gradeSearch();
                    break;
                case 3:
                    System.out.println("전체 성적 출력 기능 X");
                    break;
                case 4:
                    System.out.println("로그아웃합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하였습니다.");
                    break;
            }
        }

    }

    public void gradeInput() {
        while (true) {
            System.out.println("<<성적 입력>>");
            if (students.isEmpty()) {
                System.out.println("학생 목록이 비어 있습니다.");
                return;
            }

            if (currentStudentIndex >= students.size()) {
                currentStudentIndex = 0;
                return;
            }

            Student student = students.get(currentStudentIndex);
            System.out.println("ID: " + student.getId() + " NAME: " + student.getName());


            System.out.print("국어: ");
            int score = input.nextInt();
            input.nextLine();

            System.out.print("영어: ");
            int score1 = input.nextInt();
            input.nextLine();

            System.out.print("수학: ");
            int score2 = input.nextInt();
            input.nextLine();

            System.out.println("계속 입력하시겠습니까? Y|N");
            String yn = input.nextLine();

            if (yn.equalsIgnoreCase("Y")) {
                currentStudentIndex++;
            } else if (yn.equalsIgnoreCase("N")) {
                System.out.println("모든학생의 입력이 끝났습니다.");
                currentStudentIndex = 0;
                break;
            } else {
                System.out.println("잘못 입력하였습니다.");
            }
        }
    }

    public void gradeSearch() {
        System.out.print("검색 할 학생의 ID: ");
        String id = input.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                if (!student.getGrades().isEmpty()) { // 성적이 입력된 경우
                    System.out.println("ID: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    int total = 0;
                    int count = 0;
                    for (String subject : student.getGrades().keySet()) {
                        int score = student.getGrades().get(subject);
                        System.out.println(subject + ": " + score);
                        total += score;
                        count++;
                    }
                    System.out.println("총점: " + total);
                    System.out.println("평균: " + (count > 0 ? (double) total / count : 0));
                } else {
                    System.out.println("해당 학생의 성적이 입력되지 않았습니다.");
                }
                return;
            }
        }
        System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
    }

    public void gradeSearchAll() {

    }

}
