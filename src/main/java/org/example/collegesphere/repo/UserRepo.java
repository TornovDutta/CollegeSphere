package org.example.collegesphere.repo;

import org.example.collegesphere.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    void removeById(Integer id);
}
