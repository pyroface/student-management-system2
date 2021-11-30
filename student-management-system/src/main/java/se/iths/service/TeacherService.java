package se.iths.service;

import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {
    @PersistenceContext
    EntityManager entityManager;

    //CREATE
    public Teacher createTeacher(Teacher teacher){
        entityManager.persist(teacher);
        return teacher;
    }

    //READ
    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    //UPDATE
    public Teacher updateTeacher(Teacher teacher){
        entityManager.merge(teacher);
        return teacher;
    }

    //DELETE
    public void deleteTeacher(Long id){
        Teacher foundTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(foundTeacher);
    }
}
