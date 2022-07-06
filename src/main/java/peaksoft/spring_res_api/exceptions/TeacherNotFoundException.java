package peaksoft.spring_res_api.exceptions;

public class TeacherNotFoundException extends  RuntimeException{
    public TeacherNotFoundException(String message) {
        super(message);
    }
}
