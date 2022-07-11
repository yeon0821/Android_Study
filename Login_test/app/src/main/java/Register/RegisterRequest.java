package Register;

public class RegisterRequest {
    private long student_id;
    private String password;
    private String username;

    public RegisterRequest(long student_id, String password, String username){
        this.student_id = student_id;
        this.password = password;
        this.username = username;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
