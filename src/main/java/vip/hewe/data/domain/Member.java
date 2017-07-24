package vip.hewe.data.domain;

public class Member {
    private String id;

    private String cel;

    private String email;

    private String passwd;
    private String salt;

    public Member() {
    }

    public Member(String id, String cel, String email, String passwd, String salt) {
        this.id = id;
        this.cel = cel;
        this.email = email;
        this.passwd = passwd;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", cel='" + cel + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel == null ? null : cel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}