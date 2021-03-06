package io.github.morningk.tree;

import java.util.List;

/**
 * Type of Tree
 * contain a TreeNode root and its subTrees children
 */
public class Tree {
  private TreeNode root;
  private List<Tree> children;

  public Tree() {
  }

  public Tree(TreeNode root) {
    this.root = root;
  }

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  public List<Tree> getChildren() {
    return children;
  }

  public void setChildren(List<Tree> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "Tree{" +
        "root=" + root +
        ", children=" + children +
        '}';
  }
}
