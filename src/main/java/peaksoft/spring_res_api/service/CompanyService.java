package peaksoft.spring_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_res_api.dto.request.CompanyRequest;
import peaksoft.spring_res_api.dto.response.CompanyResponse;
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
        public CompanyResponse update(Long id, CompanyRequest companyRequest) {
            Company company = repository.findById(id).get();
            editMapper.update(company, companyRequest);
            return viewMapper.viewCompany(repository.save(company));
        }

        public CompanyResponse findById(Long id) {
            Company company = repository.findById(id).get();
            return viewMapper.viewCompany(company);
        }
        public CompanyResponse deleteById(Long id) {
            Company company = repository.getById(id);
            repository.delete(company);
            return viewMapper.viewCompany(company);
        }
        //    public List<CompanyResponse> view(List<Company> companies) {
//        List<CompanyResponse> responses = new ArrayList<>();
//        for (Company company:  companies ) {
//            responses.add(viewMapper.viewCompany(company));
//
//        }
//        return responses;
//    }
        public List<CompanyResponse> getAllCompanies() {
            return viewMapper.view(repository.findAll());
        }



}
