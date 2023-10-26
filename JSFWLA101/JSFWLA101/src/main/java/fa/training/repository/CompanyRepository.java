package fa.training.repository;

import fa.training.entity.EipCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<EipCompany, Long> {
    EipCompany findByCompanyName(String companyName);


}
