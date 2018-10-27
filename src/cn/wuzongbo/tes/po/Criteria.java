package cn.wuzongbo.tes.po;

public class Criteria {
    private Integer id;

    private Integer parentId;

    private String criteriaName;

    private Byte level;

    private Byte weight;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName == null ? null : criteriaName.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getWeight() {
        return weight;
    }

    public void setWeight(Byte weight) {
        this.weight = weight;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}