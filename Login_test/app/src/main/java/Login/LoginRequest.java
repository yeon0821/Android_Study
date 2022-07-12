package Login;

public class LoginRequest {

    private Long student_id;
    private String password;

    public LoginRequest(Long student_id, String password){
        this.student_id = student_id;
        this.password = password;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
