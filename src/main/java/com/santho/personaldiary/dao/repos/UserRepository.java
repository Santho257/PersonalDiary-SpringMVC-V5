package com.santho.personaldiary.dao.repos;

import com.santho.personaldiary.collections.CustomUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<CustomUser, String> {
}
