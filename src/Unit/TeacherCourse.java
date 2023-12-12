package Unit;

public class TeacherCourse {
    private int id;
    private String name_teacher;
    private Integer age;
    private String course_name;
    private Integer hours;

    public TeacherCourse() {
    }

    public TeacherCourse(int id, String teacher_name, Integer age, String course_name, Integer hours) {
        this.id = id;
        this.name_teacher = teacher_name;
        this.age = age;
        this.course_name = course_name;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_teacher() {
        return name_teacher;
    }

    public void setTeacherName(String teacher_name) {
        this.name_teacher = teacher_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourseName(String genre) {
        this.course_name = genre;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer dayOfWeek) {
        this.hours = dayOfWeek;
    }

    @Override
    public String toString() {
        return "\nУчителя и курсы:{" +
                "id=" + id +
                ",Учитель='" + name_teacher + '\'' +
                ",Возраст='" + age + '\'' +
                ",Название курса='" + course_name + '\'' +
                ",Продолжительность курса='" + hours + '\'' +
                "}";
    }
}
