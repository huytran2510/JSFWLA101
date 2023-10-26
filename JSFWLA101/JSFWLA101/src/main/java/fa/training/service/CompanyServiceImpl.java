package fa.training.service;


import fa.training.entity.EipCompany;
import fa.training.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void saveCompany(EipCompany newCompany) {
        companyRepository.save(newCompany);
    }

    @Override
    public EipCompany findByCompanyName(String companyName) {
        return companyRepository.findByCompanyName(companyName);
    }

}
