package peaksoft.spring_res_api.dto.response;

import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_res_api.model.Course;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter

public class CompanyResponse {
     private Long id;
     private String companyName;
     private String locatedCountry;
     private LocalDate created;
     private List<Course> courses;

}
