package com.example.companyapp.service;

import com.example.companyapp.model.Company;
import com.example.companyapp.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return repository.findById(id);
    }

    public Company createCompany(Company company) {
        return repository.save(company);
    }

    public Company updateCompany(Long id, Company updatedCompany) {
        return repository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setCompanyName(updatedCompany.getCompanyName());
                    existingCompany.setOwner(updatedCompany.getOwner());
                    return repository.save(existingCompany);
                })
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    public void deleteCompany(Long id) {
        repository.deleteById(id);
    }
}

