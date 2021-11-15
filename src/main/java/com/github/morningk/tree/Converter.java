package com.github.morningk.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Converter {
  public static Tree convertListToTree(List<TreeNode> treeNodeList) {
    return convertListToTree(treeNodeList, null);
  }

  public static Tree convertListToTree(List<TreeNode> treeNodeList, Comparator<Tree> comparator) {
    Tree tree = new Tree();
    if (treeNodeList == null || treeNodeList.isEmpty()) {
      return tree;
    }
    List<Tree> children = new ArrayList<>();
    for (TreeNode treeNode : treeNodeList) {
      if (treeNode.isRoot()) {
        Tree subTree = buildTree(treeNode, treeNodeList, comparator);
        children.add(subTree);
      }
    }
    if (comparator != null) {
      children.sort(comparator);
    }
    tree.setChildren(children);
    return tree;
  }

  private static Tree buildTree(TreeNode root, List<TreeNode> treeNodeList,
      Comparator<Tree> comparator) {
    Tree tree = new Tree(root);
    List<Tree> subTree = new ArrayList<>();
    for (TreeNode treeNode: treeNodeList) {
      if (root.isParentOf(treeNode)) {
        subTree.add(buildTree(treeNode, treeNodeList, comparator));
      }
    }
    if (comparator != null) {
      subTree.sort(comparator);
    }
    tree.setChildren(subTree);
    return tree;
  }
}
