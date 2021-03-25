package com.bakyt.spring.rest.dao;

import com.bakyt.spring.rest.entity.EmployeeNew;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeNewDAOImpl implements EmployeeNewDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<EmployeeNew> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
      /*  List<EmployeeNew> allEmployees = session.createQuery("from EmployeeNew ",
                EmployeeNew.class).getResultList();*/
        Query<EmployeeNew> query = session.createQuery("from EmployeeNew ", EmployeeNew.class);
        List<EmployeeNew> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    @Transactional
    public void saveEmployee(EmployeeNew employeeNew) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employeeNew);
    }

    @Override
    @Transactional
    public EmployeeNew getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        EmployeeNew employeeNew = session.get(EmployeeNew.class, id);
        return employeeNew;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<EmployeeNew> query = session.createQuery("delete from EmployeeNew " +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
