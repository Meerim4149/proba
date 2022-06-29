package peaksoft.spring_res_api.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

        private String companyName;
        private String locatedCountry;

}
