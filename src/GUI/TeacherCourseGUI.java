package GUI;

import Manager.TeacherCourseManager;
import Unit.TeacherCourse;

import java.util.Scanner;

public class TeacherCourseGUI {
    private TeacherCourseManager teacherCourseManager;
    private Scanner scanner;

    public TeacherCourseGUI() {
        teacherCourseManager = new TeacherCourseManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("ВывестиДанные")) {
                teacherCourseManager.showTeacherCourse();
            } else if (command.equals("Добавить")) {
                TeacherCourse teacherCourse = new TeacherCourse();
                teacherCourseManager.addTeacherCourse();
            } else if (command.equals("Обновить")) {
                TeacherCourse teacherCourse = new TeacherCourse();
                teacherCourseManager.updateTeacherCourse();
            } else if (command.equals("Удалить")) {
                teacherCourseManager.deleteTeacherCourse();
            } else if (command.equals("Выход")) {
                break;
            } else {
                System.out.println("Неверный ввод");
            }
        }
    }
}