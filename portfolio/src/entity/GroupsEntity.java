package entity;

import javax.persistence.*;

/**
 * Created by p on 2017/5/31.
 */
@Entity
@Table(name = "groups", schema = "portfolio", catalog = "")
public class GroupsEntity {
    private String id;
    private Integer agree;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "agree")
    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsEntity that = (GroupsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (agree != null ? !agree.equals(that.agree) : that.agree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (agree != null ? agree.hashCode() : 0);
        return result;
    }
}
