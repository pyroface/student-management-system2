package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    //CREATE
    public Subject createSubject(Subject subject){
        entityManager.persist(subject);
        return subject;
    }

    //READ
    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public List<Subject> getAllSubjects(){
        return entityManager.createQuery("SELECT s from Subject s", Subject.class).getResultList();
    }

    //UPDATE
    public Subject updateSubject(Subject subject){
        entityManager.merge(subject);
        return subject;
    }

    //DELETE
    public void deleteSubject(Long id){
        Subject foundSubject = entityManager.find(Subject.class, id);
        entityManager.remove(foundSubject);
    }

}