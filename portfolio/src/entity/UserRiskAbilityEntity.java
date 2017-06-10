package entity;

/**
 * 实体类，对应表中user_risk_ability
 * Created by p on 2017/5/31.
 */
public class UserRiskAbilityEntity {
    private String name;
    private Integer option1;
    private Integer option2;
    private Integer option3;
    private Integer option4;
    private Integer option5;
    private Integer option6;
    private Integer option7;
    private Integer option8;
    private Integer option9;
    private Integer option10;
    private Integer ability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOption1() {
        return option1;
    }

    public void setOption1(Integer option1) {
        this.option1 = option1;
    }

    public Integer getOption2() {
        return option2;
    }

    public void setOption2(Integer option2) {
        this.option2 = option2;
    }

    public Integer getOption3() {
        return option3;
    }

    public void setOption3(Integer option3) {
        this.option3 = option3;
    }

    public Integer getOption4() {
        return option4;
    }

    public void setOption4(Integer option4) {
        this.option4 = option4;
    }

    public Integer getOption5() {
        return option5;
    }

    public void setOption5(Integer option5) {
        this.option5 = option5;
    }

    public Integer getOption6() {
        return option6;
    }

    public void setOption6(Integer option6) {
        this.option6 = option6;
    }

    public Integer getOption7() {
        return option7;
    }

    public void setOption7(Integer option7) {
        this.option7 = option7;
    }

    public Integer getOption8() {
        return option8;
    }

    public void setOption8(Integer option8) {
        this.option8 = option8;
    }

    public Integer getOption9() {
        return option9;
    }

    public void setOption9(Integer option9) {
        this.option9 = option9;
    }

    public Integer getOption10() {
        return option10;
    }

    public void setOption10(Integer option10) {
        this.option10 = option10;
    }

    public Integer getAbility() {
        return ability;
    }

    public void setAbility(Integer ability) {
        this.ability = ability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRiskAbilityEntity entity = (UserRiskAbilityEntity) o;

        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
        if (option1 != null ? !option1.equals(entity.option1) : entity.option1 != null) return false;
        if (option2 != null ? !option2.equals(entity.option2) : entity.option2 != null) return false;
        if (option3 != null ? !option3.equals(entity.option3) : entity.option3 != null) return false;
        if (option4 != null ? !option4.equals(entity.option4) : entity.option4 != null) return false;
        if (option5 != null ? !option5.equals(entity.option5) : entity.option5 != null) return false;
        if (option6 != null ? !option6.equals(entity.option6) : entity.option6 != null) return false;
        if (option7 != null ? !option7.equals(entity.option7) : entity.option7 != null) return false;
        if (option8 != null ? !option8.equals(entity.option8) : entity.option8 != null) return false;
        if (option9 != null ? !option9.equals(entity.option9) : entity.option9 != null) return false;
        if (option10 != null ? !option10.equals(entity.option10) : entity.option10 != null) return false;
        if (ability != null ? !ability.equals(entity.ability) : entity.ability != null) return false;

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
        result = 31 * result + (option9 != null ? option9.hashCode() : 0);
        result = 31 * result + (option10 != null ? option10.hashCode() : 0);
        result = 31 * result + (ability != null ? ability.hashCode() : 0);
        return result;
    }
}
