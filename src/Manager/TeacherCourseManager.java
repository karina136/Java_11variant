package Manager;

import Unit.TeacherCourse;
import TeacherCourse.TeacherCourseDatabase;

import java.util.List;
import java.util.Scanner;

public class TeacherCourseManager {
    private TeacherCourseDatabase teacherCourseDatabase;

    public TeacherCourseManager() {
        teacherCourseDatabase = new TeacherCourseDatabase();
    }

    public void showTeacherCourse() {
        try {
            List<TeacherCourse> teachercourse = teacherCourseDatabase.getAllTeacherCourse();


            if (teachercourse.isEmpty()) {
                System.out.println("Нет учителей и курсов");
            } else {
                System.out.println("Учителя и курсы:");
                for (TeacherCourse teacherCourse : teachercourse) {
                    System.out.println(teacherCourse);
                }
            }
        } finally {
            teacherCourseDatabase.closeConnection();
        }
    }

    public void addTeacherCourse() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("ФИО учителя:");
            String teacher_name = scanner.nextLine();

            System.out.println("Возраст учителя:");
            String age = scanner.nextLine();

            System.out.println("Название курса:");
            String course_name = scanner.nextLine();

            System.out.println("Длительность курса:");
            String hours = scanner.nextLine();

            TeacherCourse teacherCourse = new TeacherCourse();
            teacherCourse.setTeacherName(teacher_name);
            teacherCourse.setAge(Integer.valueOf(age));
            teacherCourse.setCourseName(course_name);
            teacherCourse.setHours(Integer.valueOf(hours));

            teacherCourseDatabase.addTeacherCourse(teacherCourse);

            System.out.println("Учитель и курс добавлены");
        } finally {
            teacherCourseDatabase.closeConnection();
        }
    }

    public void updateTeacherCourse() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID учителя и курса:");
            int id = scanner.nextInt();
            scanner.nextLine();

            TeacherCourse teacherCourseToUpdate = teacherCourseDatabase.getTeacherCourse(id);

            if (teacherCourseToUpdate == null) {
                System.out.println("Учитель и курс с указанным id не найдены");
                return;
            }

            System.out.println("Новое ФИО учителя:");
            String teacher_name = scanner.nextLine();

            System.out.println("Новый возраст учителя:");
            String age = scanner.nextLine();

            System.out.println("Новое название курса:");
            String course_name = scanner.nextLine();

            System.out.println("Новая продолжительность курса:");
            String hours = scanner.nextLine();

            teacherCourseToUpdate.setTeacherName(teacher_name);
            teacherCourseToUpdate.setAge(Integer.valueOf(age));
            teacherCourseToUpdate.setCourseName(course_name);
            teacherCourseToUpdate.setHours(Integer.valueOf(hours));

            teacherCourseDatabase.updateTeacherCourse(teacherCourseToUpdate);

            System.out.println("Учитель и курс добавлены");
        } finally {
            teacherCourseDatabase.closeConnection();
        }
    }

    public void deleteTeacherCourse() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("id учителя и курса для удаления:");
            int id = scanner.nextInt();
            scanner.nextLine();

            TeacherCourse teacherCourseToDelete = teacherCourseDatabase.getTeacherCourse(id);

            if (teacherCourseToDelete == null) {
                System.out.println("Учитель и курс с указанным ID не найден");
                return;
            }

            teacherCourseDatabase.deleteTeacherCourse(id);

            System.out.println("Учитель и курс удалены");
        } finally {
            teacherCourseDatabase.closeConnection();
        }
    }

    public TeacherCourse getTeacherCourse(int id) {
        try {
            return teacherCourseDatabase.getTeacherCourse(id);
        } finally {
            teacherCourseDatabase.closeConnection();
        }
    }
}