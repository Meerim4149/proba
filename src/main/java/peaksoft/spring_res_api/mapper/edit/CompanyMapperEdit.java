package peaksoft.spring_res_api.mapper.edit;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.request.CompanyRequest;
import peaksoft.spring_res_api.model.Company;
import java.time.LocalDate;

@Component
public class CompanyMapperEdit {

        public Company create(CompanyRequest request) {
            if(request==null) {
                return null;
            }
            Company company = new Company();
            company.setCompanyName(request.getCompanyName());
            company.setLocatedCountry(request.getLocatedCountry());
            company.setCreated(LocalDate.now());
            return company;
        }

        public void update(Company company, CompanyRequest request) {
            company.setCompanyName(request.getCompanyName());
            company.setLocatedCountry(request.getLocatedCountry());
            company.setCreated(LocalDate.now());
        }

}
