package fa.training.repository;


import fa.training.entity.TurbineUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<TurbineUser, Long> {
    @Query("SELECT DISTINCT tu.username, tu.firstname, tu.lastname " +
            "FROM TurbineUser tu " +
            "LEFT JOIN tu.eipCompany up " +
            "LEFT JOIN up.eipPosts ep")
    List<Object[]> getUsernameNameAndPostName();

    void deleteByUsername(String username);

    TurbineUser findByUsername(String username);


}
