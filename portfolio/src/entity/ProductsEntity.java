package entity;

/**
 * 实体类，对应表中products
 * Created by p on 2017/6/6.
 */
public class ProductsEntity {
    private int id;
    private String link;
    private Double minMoney;
    private String title;
    private Double earn;
    private Long dateStart;
    private Long dateEnd;
    private Long dateEarn;
    private Integer days;
    private Double surplusValue;
    private Integer risk;
    private Boolean guaranteed;
    private Boolean save;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Double getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(Double minMoney) {
        this.minMoney = minMoney;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getEarn() {
        return earn;
    }

    public void setEarn(Double earn) {
        this.earn = earn;
    }

    public Long getDateStart() {
        return dateStart;
    }

    public void setDateStart(Long dateStart) {
        this.dateStart = dateStart;
    }

    public Long getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Long dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getDateEarn() {
        return dateEarn;
    }

    public void setDateEarn(Long dateEarn) {
        this.dateEarn = dateEarn;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getSurplusValue() {
        return surplusValue;
    }

    public void setSurplusValue(Double surplusValue) {
        this.surplusValue = surplusValue;
    }

    public Integer getRisk() {
        return risk;
    }

    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    public Boolean getGuaranteed() {
        return guaranteed;
    }

    public void setGuaranteed(Boolean guaranteed) {
        this.guaranteed = guaranteed;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (minMoney != null ? !minMoney.equals(that.minMoney) : that.minMoney != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (earn != null ? !earn.equals(that.earn) : that.earn != null) return false;
        if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        if (dateEarn != null ? !dateEarn.equals(that.dateEarn) : that.dateEarn != null) return false;
        if (days != null ? !days.equals(that.days) : that.days != null) return false;
        if (surplusValue != null ? !surplusValue.equals(that.surplusValue) : that.surplusValue != null) return false;
        if (risk != null ? !risk.equals(that.risk) : that.risk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (minMoney != null ? minMoney.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (earn != null ? earn.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (dateEarn != null ? dateEarn.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (surplusValue != null ? surplusValue.hashCode() : 0);
        result = 31 * result + (risk != null ? risk.hashCode() : 0);
        return result;
    }
}
