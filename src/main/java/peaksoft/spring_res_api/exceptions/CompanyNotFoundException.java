package peaksoft.spring_res_api.exceptions;

public class CompanyNotFoundException extends  RuntimeException{

    public CompanyNotFoundException(String message) {
        super(message);
    }

}
