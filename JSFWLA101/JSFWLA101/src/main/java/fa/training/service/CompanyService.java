package fa.training.service;

import fa.training.entity.EipCompany;

public interface CompanyService {
    EipCompany findByCompanyName(String companyName);

    void saveCompany(EipCompany newCompany);
}
