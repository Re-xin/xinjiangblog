package com.xinjiang.blog.queryvo;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/12 10:00
 * @description:
 */
public class TypeNums {
    private Long typeId;
    private Long nums;
    private String name;

    public TypeNums() {
    }

    public TypeNums(Long typeId, Long nums, String name) {
        this.typeId = typeId;
        this.nums = nums;
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getNums() {
        return nums;
    }

    public void setNums(Long nums) {
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeNums{" +
                "typeId=" + typeId +
                ", nums=" + nums +
                ", name='" + name + '\'' +
                '}';
    }
}
