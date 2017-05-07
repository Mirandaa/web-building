package entity;

import javax.persistence.*;

/**
 * Created by p on 2017/5/4.
 */
@Entity
@Table(name = "user_info", schema = "portfolio", catalog = "")
public class UserInfoEntity {
    private String name;
    private String psw;
    private String email;

    @Id
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "psw", nullable = false, length = 32)
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (psw != null ? !psw.equals(that.psw) : that.psw != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (psw != null ? psw.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
