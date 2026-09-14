package com.HibernatePrac.CrudDemo.dao;

import com.HibernatePrac.CrudDemo.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class studentDaoImp implements studentDao {
    // as this is the main class which will interact with the repo thus we need this entity manager

    //difine field for entity manager
    private EntityManager entityManager;

    //inject entity manger using constructor injeection
    @Autowired
    public studentDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    // implement save method



    @Override
    @Transactional // must be of spring framework
    public void save(student student) {
        entityManager.persist(student);// this perisit actually help to save the object in database

    }

    // retreiving data from the database

    @Override
    public student findById(Integer id) {
        return entityManager.find(student.class, id);
    }

    @Override
    public List<student> findAll() {
        // create a query for
        TypedQuery<student> query = entityManager.createQuery("From student", student.class);

        // use of complexed condition
        TypedQuery<student> query1 = entityManager.createQuery("select s From student s where s.email='new@gmail.com'", student.class);


        // use of set parameter
        TypedQuery<student> query2 = entityManager.createQuery("select s From student s where s.lastname=:theData", student.class);

        query2.setParameter("theData","singh");


        // return result
        return query2.getResultList();
    }
}
