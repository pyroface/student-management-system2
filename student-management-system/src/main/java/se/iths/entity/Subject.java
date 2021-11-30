package se.iths.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Long id;
    private String subjectname;

    @ManyToMany
    private List<Student> students= new ArrayList<>();

    @ManyToOne
    //@JoinColumn(name = "teacherId", referencedColumnName = "id")
    private Teacher teacher;

    public Subject(){}

    public Subject(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public Teacher getTeacher() {
        return teacher;
    }
}
