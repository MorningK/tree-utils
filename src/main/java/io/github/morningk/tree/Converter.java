package io.github.morningk.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * the util used to convert List to Tree
 */
public class Converter {

  /**
   * convert given tree node list to tree
   * @param treeNodeList TreeNodeList
   * @return tree
   */
  public static Tree convertListToTree(List<TreeNode> treeNodeList) {
    return convertListToTree(treeNodeList, null);
  }

  /**
   * convert given tree node list to tree and sorted by comparator
   * @param treeNodeList TreeNodeList
   * @param comparator the comparator sort tree
   * @return sorted tree
   */
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
