# tree-utils
a java util convert list to tree 

## Interface TreeNode
```
public interface TreeNode {
  boolean isRoot();
  boolean isParentOf(TreeNode child);
}
```

## Class Tree
```
public class Tree {
  private TreeNode root;
  private List<Tree> children;
}
```

## Converter
``` 
public static Tree convertListToTree(List<TreeNode> treeNodeList);
public static Tree convertListToTree(List<TreeNode> treeNodeList, Comparator<Tree> comparator);
```
## Usage

### Adding dependency
using Maven
```
<!-- https://mvnrepository.com/artifact/io.github.morningk/tree-utils -->
<dependency>
    <groupId>io.github.morningk</groupId>
    <artifactId>tree-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```
using Gradle
```
// https://mvnrepository.com/artifact/io.github.morningk/tree-utils
implementation 'io.github.morningk:tree-utils:1.0.0'
```
### example
``` 
public class Tag implements TreeNode {
  private Long id;
  private String name;
  private Long parentId;
  private Integer order;
  
  @Override
  public boolean isRoot() {
    return parentId == null;
  }

  @Override
  public boolean isParentOf(TreeNode child) {
    return child instanceof Tag && id.equals(((Tag) child).parentId);
  }
}

Tree tree = Converter.convertListToTree(treeNodeList);
Tree orderedTree = Converter.convertListToTree(treeNodeList,
        Comparator.comparing(o -> ((Tag) o.getRoot()).getOrder()));
```
