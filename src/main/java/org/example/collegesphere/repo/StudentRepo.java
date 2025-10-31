package org.example.collegesphere.repo;

import org.example.collegesphere.model.Student;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    void removeById(Integer id);
}
