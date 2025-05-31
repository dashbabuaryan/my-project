package com.example.bank.Repository;

import com.example.bank.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Integer> {
    public Optional<Users> findById(Integer id);

    public Optional<Users> findByEmail(String email);





    @Query(value = "SELECT * FROM users WHERE email > :email", nativeQuery = true)
    List<Users> findUsersWithEmailID(@Param("email") String email);



}
