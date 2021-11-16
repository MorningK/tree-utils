package com.github.morningk.tree;

/**
 * Type of TreeNode
 */
public interface TreeNode {

  /**
   * determine is this TreeNode a tree root
   * @return true if this TreeNode is a tree root
   */
  boolean isRoot();

  /**
   * determine this TreeNode is the parent of the given TreeNode
   * @param child the given TreeNode
   * @return true if the TreeNode is the parent of the given TreeNode
   */
  boolean isParentOf(TreeNode child);
}
