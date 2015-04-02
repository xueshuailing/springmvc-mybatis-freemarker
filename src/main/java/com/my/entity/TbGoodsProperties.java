package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbGoodsProperties extends Entity{
    /***/
    private String name;
    /**是否多选 0--否 1--是*/
    private String isMany;
    /***/
    private String parentId;
    /**是否公共属性 0--否 1--是*/
    private String isPublic;
		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
		public String getIsMany() {
        return isMany;
    }

    public void setIsMany(String isMany) {
        this.isMany = isMany;
    }
		public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
		public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }
}