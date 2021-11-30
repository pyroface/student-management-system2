package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    //CREATE
    public Student createStudent(Student student){
        entityManager.persist(student);
        return student;
    }

    //READ
    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> getByLastnameQuery(String name) {
        String query = "SELECT i FROM Student i WHERE i.lastName = '" + name + "'";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    //UPDATE
    public Student updateStudent(Student student){
        entityManager.merge(student);
        return student;
    }

    //DELETE
    public void deleteStudent(Long id){
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }

}
