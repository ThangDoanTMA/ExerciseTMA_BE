package com.example.ManagerEmployee.Repository;

import com.example.ManagerEmployee.Model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
}
