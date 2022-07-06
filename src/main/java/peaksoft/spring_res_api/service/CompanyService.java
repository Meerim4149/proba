package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_res_api.dto.request.CompanyRequest;
import peaksoft.spring_res_api.dto.response.CompanyResponse;
import peaksoft.spring_res_api.exceptions.CompanyNotFoundException;
import peaksoft.spring_res_api.mapper.edit.CompanyMapperEdit;
import peaksoft.spring_res_api.mapper.view.CompanyMapperView;
import peaksoft.spring_res_api.model.Company;
import peaksoft.spring_res_api.repository.CompanyRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;
    private final CompanyMapperEdit editMapper;
    private final CompanyMapperView viewMapper;

    public CompanyResponse create (CompanyRequest companyRequest) {
        Company company = editMapper.create(companyRequest);
        repository.save(company);
        return viewMapper.viewCompany(company);
    }

    private Company getCompanyById(Long id){
        return repository.findById(id).orElseThrow(()->
                new CompanyNotFoundException(
                        "Company with id" + id + "not found!"));
    }
    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        Company company = getCompanyById(id);
        editMapper.update(company, companyRequest);
        return viewMapper.viewCompany(repository.save(company));
    }

    public CompanyResponse findById(Long id) {
        Company company = getCompanyById(id);
        return viewMapper.viewCompany(company);
    }
    public CompanyResponse deleteById(Long id) {
        Company company = getCompanyById(id);
        repository.delete(company);
        return viewMapper.viewCompany(company);
    }
    public List<CompanyResponse> getAllCompanies() {
        return viewMapper.view(repository.findAll());
    }



}
