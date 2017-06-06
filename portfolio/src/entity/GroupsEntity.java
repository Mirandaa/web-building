package entity;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by p on 2017/5/31.
 */
public class GroupsEntity {
    private int id;
    private Integer agree;
    private String name;
    private Integer type;
    private Integer days;
    private Double yearRate;
    private Integer minMoney;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getYearRate() {
        return yearRate;
    }

    public void setYearRate(Double yearRate) {
        this.yearRate = yearRate;
    }

    public Integer getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(Integer minMoney) {
        this.minMoney = minMoney;
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
