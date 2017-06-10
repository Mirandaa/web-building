package entity;

import java.io.Serializable;

/**
 * 实体类，对应数据库中relation_product_group
 * Created by p on 2017/5/31.
 */
public class RelationProductGroupEntity implements Serializable{
    private int groupId;
    private int productId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelationProductGroupEntity that = (RelationProductGroupEntity) o;

        if (groupId != that.groupId) return false;
        if (productId != that.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + productId;
        return result;
    }
}
