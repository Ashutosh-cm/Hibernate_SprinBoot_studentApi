package com.HibernatePrac.CrudDemo.dao;

import com.HibernatePrac.CrudDemo.entity.student;

import java.util.List;

public interface studentDao {
    void save(student student);

    student findById(Integer id);

    List<student> findAll();

}
