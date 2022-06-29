package peaksoft.spring_res_api.mapper.view;

import org.springframework.stereotype.Component;
import peaksoft.spring_res_api.dto.response.CompanyResponse;
import peaksoft.spring_res_api.model.Company;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapperView {
        public CompanyResponse viewCompany(Company company) {
            if(company==null) {
                return null;
            }
            CompanyResponse response = new CompanyResponse();
            response.setId(company.getId());
            response.setCompanyName(company.getCompanyName());
            response.setLocatedCountry(company.getLocatedCountry());
            response.setCourses(company.getCourses());
            response.setCreated(company.getCreated());
            return response;
        }

        public List<CompanyResponse> view(List<Company> companies) {
            List<CompanyResponse> responses = new ArrayList<>();
            for (Company company:  companies) {
                responses.add(viewCompany(company));
            }
            return responses;
        }
}
