package fa.training.repository;

import fa.training.entity.EipCompany;
import fa.training.entity.EipPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<EipPosition, Long> {
    EipPosition findByName(String name);
}
