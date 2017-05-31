package entity;

/**
 * Created by p on 2017/5/31.
 */
public class GroupsEntity {
    private int id;
    private Integer agree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        if (id != that.id) return false;
        if (agree != null ? !agree.equals(that.agree) : that.agree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (agree != null ? agree.hashCode() : 0);
        return result;
    }
}
