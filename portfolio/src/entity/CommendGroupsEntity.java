package entity;

/**
 * 实体类，对应表中commend_groups
 * Created by p on 2017/5/31.
 */
public class CommendGroupsEntity {
    private int commendId;
    private String userName;
    private Integer groupId;
    private String content;

    public int getCommendId() {
        return commendId;
    }

    public void setCommendId(int commendId) {
        this.commendId = commendId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommendGroupsEntity that = (CommendGroupsEntity) o;

        if (commendId != that.commendId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commendId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
