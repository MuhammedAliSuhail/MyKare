package com.example.Registration.repositorys;

import com.example.Registration.Entites.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {


  public Users findByGmail(String gmail);
}
