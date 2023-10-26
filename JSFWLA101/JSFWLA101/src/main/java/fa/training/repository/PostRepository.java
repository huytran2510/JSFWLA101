package fa.training.repository;

import fa.training.entity.EipPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<EipPost, Long> {
    EipPost findByPostName(String postName);
}
