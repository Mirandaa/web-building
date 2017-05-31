package entity;

import javax.persistence.*;

/**
 * Created by p on 2017/5/31.
 */
@Entity
@Table(name = "user_risk_like", schema = "portfolio", catalog = "")
public class UserRiskLikeEntity {
    private String name;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String option6;
    private String option7;
    private String option8;
    private Integer mlike;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "option1")
    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    @Basic
    @Column(name = "option2")
    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    @Basic
    @Column(name = "option3")
    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    @Basic
    @Column(name = "option4")
    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    @Basic
    @Column(name = "option5")
    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    @Basic
    @Column(name = "option6")
    public String getOption6() {
        return option6;
    }

    public void setOption6(String option6) {
        this.option6 = option6;
    }

    @Basic
    @Column(name = "option7")
    public String getOption7() {
        return option7;
    }

    public void setOption7(String option7) {
        this.option7 = option7;
    }

    @Basic
    @Column(name = "option8")
    public String getOption8() {
        return option8;
    }

    public void setOption8(String option8) {
        this.option8 = option8;
    }

    @Basic
    @Column(name = "mlike")
    public Integer getMlike() {
        return mlike;
    }

    public void setMlike(Integer mlike) {
        this.mlike = mlike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRiskLikeEntity that = (UserRiskLikeEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (option1 != null ? !option1.equals(that.option1) : that.option1 != null) return false;
        if (option2 != null ? !option2.equals(that.option2) : that.option2 != null) return false;
        if (option3 != null ? !option3.equals(that.option3) : that.option3 != null) return false;
        if (option4 != null ? !option4.equals(that.option4) : that.option4 != null) return false;
        if (option5 != null ? !option5.equals(that.option5) : that.option5 != null) return false;
        if (option6 != null ? !option6.equals(that.option6) : that.option6 != null) return false;
        if (option7 != null ? !option7.equals(that.option7) : that.option7 != null) return false;
        if (option8 != null ? !option8.equals(that.option8) : that.option8 != null) return false;
        if (mlike != null ? !mlike.equals(that.mlike) : that.mlike != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (option1 != null ? option1.hashCode() : 0);
        result = 31 * result + (option2 != null ? option2.hashCode() : 0);
        result = 31 * result + (option3 != null ? option3.hashCode() : 0);
        result = 31 * result + (option4 != null ? option4.hashCode() : 0);
        result = 31 * result + (option5 != null ? option5.hashCode() : 0);
        result = 31 * result + (option6 != null ? option6.hashCode() : 0);
        result = 31 * result + (option7 != null ? option7.hashCode() : 0);
        result = 31 * result + (option8 != null ? option8.hashCode() : 0);
        result = 31 * result + (mlike != null ? mlike.hashCode() : 0);
        return result;
    }
}
