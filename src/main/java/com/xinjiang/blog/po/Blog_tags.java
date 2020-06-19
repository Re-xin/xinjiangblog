package com.xinjiang.blog.po;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/30 5:00
 * @description:
 */
public class Blog_tags {
    private Long tagId;

    private Long blogId;

    public Blog_tags(Long tagId, Long blogId) {
        this.tagId = tagId;
        this.blogId = blogId;
    }

    public Blog_tags() {
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "Blog_tags{" +
                "tagId=" + tagId +
                ", blogId=" + blogId +
                '}';
    }
}
