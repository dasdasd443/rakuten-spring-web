package com.web.rakuten.Repository;

import com.web.rakuten.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>{
    
}
