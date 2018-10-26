package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<User,Integer> {

    //spring boot will generate the bean in this code and it saves it n hibernate  crudrepository does all this shit  read crud and all repository

}
