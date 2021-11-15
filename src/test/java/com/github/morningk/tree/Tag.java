package com.github.morningk.tree;

public class Tag implements TreeNode {
  private Long id;
  private String name;
  private Long parentId;
  private Integer order;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getParentId() {
    return parentId;
  }

  public Integer getOrder() {
    return order;
  }

  public Tag(Long id, String name, Long parentId, Integer order) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.order = order;
  }

  @Override
  public String toString() {
    return "Tag{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", parentId=" + parentId +
        ", order=" + order +
        '}';
  }

  @Override
  public boolean isRoot() {
    return parentId == null;
  }

  @Override
  public boolean isParentOf(TreeNode child) {
    return child instanceof Tag && id.equals(((Tag) child).parentId);
  }
}
