package com.shera.internexttv.model;

public class CategoryDTO {

    private String category_id;
    private String category_name;
    private Long parent_id;

    public String getCategoryId() {
        return category_id;
    }

    public void setCategoryId(String categoryId) {
        this.category_id = categoryId;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String categoryName) {
        this.category_name = categoryName;
    }

    public Long getParentId() {
        return parent_id;
    }

    public void setParentId(Long parentId) {
        this.parent_id = parentId;
    }
}
