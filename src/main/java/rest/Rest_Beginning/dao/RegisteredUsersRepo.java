package rest.Rest_Beginning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.Rest_Beginning.model.RegisteredUsers;

import java.util.Optional;

@Repository
public interface RegisteredUsersRepo extends JpaRepository<RegisteredUsers,String> {
    Optional<RegisteredUsers> findByEmail(String email);
}
