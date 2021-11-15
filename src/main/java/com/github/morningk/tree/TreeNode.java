package com.github.morningk.tree;

public interface TreeNode {
  boolean isRoot();
  boolean isParentOf(TreeNode child);
}
