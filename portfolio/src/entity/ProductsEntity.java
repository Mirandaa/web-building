package entity;

import javax.persistence.*;

/**
 * Created by p on 2017/5/24.
 */
@Entity
@Table(name = "products", schema = "portfolio", catalog = "")
public class ProductsEntity {
    private String id;
    private String link;
    private Double minMoney;
    private String title;
    private Double earn;
    private String dateStart;
    private String dateEnd;
    private String dateEarn;
    private Integer days;
    private Double surplusValue;

    @Id
    @Column(name = "id", nullable = false, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "link", nullable = true, length = 100)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "min_money", nullable = true, precision = 0)
    public Double getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(Double minMoney) {
        this.minMoney = minMoney;
    }

    @Basic
    @Column(name = "title", nullable = true, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "earn", nullable = true, precision = 0)
    public Double getEarn() {
        return earn;
    }

    public void setEarn(Double earn) {
        this.earn = earn;
    }

    @Basic
    @Column(name = "date_start", nullable = true, length = 20)
    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "date_end", nullable = true, length = 20)
    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Basic
    @Column(name = "date_earn", nullable = true, length = 20)
    public String getDateEarn() {
        return dateEarn;
    }

    public void setDateEarn(String dateEarn) {
        this.dateEarn = dateEarn;
    }

    @Basic
    @Column(name = "days", nullable = true)
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Basic
    @Column(name = "surplus_value", nullable = true, precision = 0)
    public Double getSurplusValue() {
        return surplusValue;
    }

    public void setSurplusValue(Double surplusValue) {
        this.surplusValue = surplusValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity entity = (ProductsEntity) o;

        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (link != null ? !link.equals(entity.link) : entity.link != null) return false;
        if (minMoney != null ? !minMoney.equals(entity.minMoney) : entity.minMoney != null) return false;
        if (title != null ? !title.equals(entity.title) : entity.title != null) return false;
        if (earn != null ? !earn.equals(entity.earn) : entity.earn != null) return false;
        if (dateStart != null ? !dateStart.equals(entity.dateStart) : entity.dateStart != null) return false;
        if (dateEnd != null ? !dateEnd.equals(entity.dateEnd) : entity.dateEnd != null) return false;
        if (dateEarn != null ? !dateEarn.equals(entity.dateEarn) : entity.dateEarn != null) return false;
        if (days != null ? !days.equals(entity.days) : entity.days != null) return false;
        if (surplusValue != null ? !surplusValue.equals(entity.surplusValue) : entity.surplusValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (minMoney != null ? minMoney.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (earn != null ? earn.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (dateEarn != null ? dateEarn.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (surplusValue != null ? surplusValue.hashCode() : 0);
        return result;
    }
}
