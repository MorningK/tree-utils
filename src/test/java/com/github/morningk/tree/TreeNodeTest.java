package com.github.morningk.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class TreeNodeTest {
  List<TreeNode> generateTreeNodeList() {
    List<TreeNode> treeNodeList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 50; i++) {
      Integer order = random.nextInt();
      if (treeNodeList.isEmpty() || random.nextInt(10) < 2) {
        treeNodeList.add(new Tag(random.nextLong(), "Tag" + i, null, order));
      } else {
        treeNodeList.add(
            new Tag(
                random.nextLong(),
                "Tag" + i,
                ((Tag) treeNodeList.get(random.nextInt(treeNodeList.size()))).getId(),
                order));
      }
    }
    return treeNodeList;
  }

  @Test
  public void convertTest() {
    List<TreeNode> treeNodeList = generateTreeNodeList();
    System.out.println("generateTreeNodeList finish "  + treeNodeList);
    Tree tree = Converter.convertListToTree(treeNodeList);
    System.out.println("convertListToTree finish " + tree);
    Tree orderedTree = Converter.convertListToTree(treeNodeList,
        Comparator.comparing(o -> ((Tag) o.getRoot()).getOrder()));
    System.out.println("convertListToTree finish orderedTree " + orderedTree);
  }
}
