# BinaryTree
A binary tree is made of nodes, where each node contains a left pointer, a right pointer, and a data element.
The root pointer points to the topmost node in the tree. The left and right pointers recursively point to smaller subtrees on either side. A null pointer represents a binary tree with no elements -- the empty tree.
The formal recursive definition is: a binary tree is either empty (represented by a null pointer), or is made of a single node, where the left and right pointers (recursive definition ahead) each point to a binary tree.
A binary search tree (BST) or ordered binary tree is a type of binary tree where the nodes are arranged in order: for each node, all elements in its left subtree are less-or-equal to the node (<=), and all the elements in its right subtree are greater than the node (>).
Basically, binary search trees are fast at insert and lookup. On average, a binary search tree algorithm can locate a node in an nn node tree in order lognlog⁡n time (log base 2). Therefore, binary search trees are good for dictionary problems where the code inserts and looks up information indexed by some key. The lognlog⁡n behavior is the average case -- it's possible for a particular tree to be much slower depending on its shape. The last tree out of major kinds of trees is a heap. A heap is a tree in which each node's children have values less than or equal to node's value. Consequently, the root node always has the largest value in the tree, which means that it's possible to find the maximum value in constant time: Simply return the root value. So, if extraction the max value needs to be fast, we should use a heap. A leaf (external) node is a node that has no children while nonleaf node is also called internal node. The number of children of a node xx in a tree TT is the same as the degree of xx. The length of the simple path from the root rr to a node xx is the depth of xx in TT. A level of a tree consists of all nodes at the same depth. The height of a node in a tree is the number of edges (hops) on the longest downward path from the node to a leaf, and the height of a tree is the height of its root. So, the height of a tree is equal to the largest depth of any node in the tree.
The height (depth) could be anywhere from ~log2nlog2n(best case, perfectly balanced) to ~nn (worst case, a chain). Another thing to point out here is the importance of the height. We may appreciate the role of the height property of BST from the answer to the following question:
What's the worst-case running time of search(or insert) operation in a binary search tree containing nn keys?
1. O(1)
2. O(log2n)
3. O(height)
4. O(n)  

The answer is (3). That's because we need to know the structure of BST, and the height gives us that information (longest root-leaf path). Note that (2) is for the bast case, and (4) is the answer for the worst case. So, in general, (3) should be the answer.









The following items are included in this Binary Search Tree example code. 
It's based on the tree in the picture above.
1. Look Up (lookUp())
One advantage of a binary search tree is that the lookup operation is fast and simple. This is particularly useful for data storage. This look up is a fast operation because we eliminate half the nodes from our search on each iteration by choosing to follow the left subtree or the right subtree. It is an Ω(logn)Ω(log⁡n) operation.

2. New Node (newTreeNode()) 
Makes the root node.

3. Insert Node (insertTreeNode())
Insertion begins as a search would begin; if the root is not equal to the value, we search the left or right subtrees as before. Eventually, we will reach an external node and add the value as its right or left child, depending on the node's value. In other words, we examine the root and recursively insert the new node to the left subtree if the new value is less than the root, or the right subtree if the new value is greater than or equal to the root.
Ω(logn)Ω(log⁡n) operations

4. Deleting a key from a binary search ( deleteKey()) 
This is a little bit tricky. We can categorize it in three groups depending its operations:
A leaf node - this is the easiest case and we just delete it.
A node that has both left and right child 
We replace the node with its predecessor.
A node that has only one child. The child replaces the parent.

5. Is The Given Tree BST? (isBST())
The code isBST() is the answer to the question: 
Given a binary tree, programmatically we need to prove it is a binary search tree.
If the given binary tree is a binary search tree, then the inorder traversal should output the elements in increasing order. 
We make use of this property of inorder traversal to check whether the given binary tree is a BST or not.

6. Size (treeSize()) 
Size of a binary tree is the total number of nodes in the tree.

7. Maximum/Minimum Depth (maxDepth()/minDepth()) 
The number of nodes along the longest/shortest path from the root node down to the farthest leaf node. The maxDepth of the empty tree is 0.

8. Is balanced? (isBalanced()) 
A balanced binary tree is commonly defined as a binary tree in which the height of the two subtrees of every node never differ by more than 1.
In this example, I used maxDepth(node)-minDepth(node) <= 1

9. Minimum/Maximum Value (minTree()/maxTree())

10. In Order Successor/Predecessor (succesorInOrder()/predecessorInOrder()) 
A node which has the next higher/lower key. 

* Successor 
A node's successor is the one with the next largest value in the tree. In other words, if all keys are distinct, the successor of a node xx is the node with the smallest key greater than x.keyx.key. The structure of binary search tree allows us to determine the successor of a node without ever comparing the keys.
For example, given the tree in the picture above, the successor of B is C, the successor of E is F, and the successor of I is None. Finding the successor involves two distinct cases. 
(a) If a node has a right child, then the successor is the minimum of the minor tree. For example, to find the successor of B, we know it has a right hand child, D, so we take its minimum, C. 
(b) If a node has no right child, as in the case with E, we need to search back up the tree until we find the first right-hand turn. In other words, we keep looking up the tree until we find a node that is the left child, and then use its parent. In our example, we move up the tree moving left from E to D, and then left again to B, and finally we make a right-hand turn to F.
The following pseudo code returns the successor of a node xx in a binary search tree if it exists, or NULL if xx has the largest key in the tree:
```
SuccessorInOrder(x)
    if x.right != NULL;
        return minTree(x);
    y = x.p
    while x!= NULL && x == y.right
        x = y;
        y = x.p;
    return y;
 ```
As described earlier, we broke the code into two cases. If the right subtree of node xx is not empty, then the successor of xx is just the leftmost node in xx's right subtree. So, we just call minTree(x). However, if the right subtree of node xx is empty, to find yy, we simply go up the tree from xx until we see a node that is the left child of its parent.

* Predecessor 
For example, given the tree in the picture above, the predecessor of B is A, the predecessor of E is D, and the predecessor of I is H. 
The algorithm for finding the predecessor is , in essence, the inverse of what we use for the successor, and it also involves two similar cases. 
(a) If a node has a left child, then we take subtree's maximum, i.e. right-most child of its left subtree.
(b) If a node has no left child, we walk up the tree until we find a left-hand turn. In other words, follow the parent pointer until we get the key which is smaller than its own value.

11. LCA (Lowest Common Ancestor) - (lowestCommonAncestor()) 
For the picture above, 
The lowest common ancestor of A and C is B
The lowest common ancestor of E and H is F
The lowest common ancestor of D and E is B
The lowest common ancestor of G and I is F
The lowest common ancestor of H and I is G

12. Clear (Delete Node) 
Ω(logn)Ω(log⁡n) operations











13. In Order print (printTreeInOrder())
As the name suggests, it prints the values in a binary search tree in sorted order.
Inorder traversal performs the operation first on the node's left descendants, then on the node itself, and finally on its right descendants. In other words, the left subtree is visited first, then the node itself, and then the node's right subtree.
If xx is the root of an nn-node subtree, then the call printTreeInOrder(x) takes Θ(n)Θ(n) time In fact, it prints out exactly one node per one recursive call.
```
        if x != NULL
           printTreeInOrder(x.left);
           print x.key;
           printTreeInOrder(x.right);
```     
Also called Inorder tree walk.

14. Pre Order print (printTreePreOrder())
Preorder traversal involves walking around the tree in a counterclockwise manner starting at the root. It first visits the root node, then each of the subtree. 
Sticking close to the edge, and printing out the nodes as we encounter them. For the tree shown above, the result is F B A D C E G I H. 
Traversal operation performed first on the node itself, then on its left descendants, and finally on its right descendants. In other words, a node is always visited before any of its children.
Also called Preorder tree walk.

15. Post Oder print (printTreePostOrder())
Postorder traversal performs the operation first on the node's left descendants, then on the node's right descendants, and finally on the node itself. In other words, all of a node's children are visited before the node itself.
For the picture above, it will be - A C E D B H I G F.
Also called Postorder tree walk.

16. Reverse Oder print (printTreeReverseOrder())
Reversing the traverse of the printTreeInOrder().
This will print - I H G F E D C B A.

17. Converting Binary Search Tree into an Array (TreeToArray()) 
How do you put a Binary Search Tree in an array in an efficient manner. 
Hint :: If the node is stored at the ith position and its children are at 2i and 2i+1(I mean level order wise). It's not the most efficient way.

18. Paths from the root to leaves (pathFinder()) 
Given a binary tree, print out all of its root-to-leaf paths, one per line. Uses a recursive helper to do the work.

19. Find n-th maximum node (NthMax()) 
How do we find out the fifth maximum element in a Binary Search Tree in efficient manner? 
Note: We should not use any extra space. i.e., sorting Binary Search Tree and storing the results in an array and listing out the fifth element.

20. Is Sub Tree? (isSubTree())

21. Mirror Tree (mirror()) 
Change a tree so that the roles of the left and right hand pointers are swapped at every node.

22. Make a new tree with minimal depth from a sorted array (createMinimalBST(())

23. Get the level for a given node element (getLevel(root, elm, 0))

24. Separate elements depending on the level (even/odd) (level_even_odd(root);)
This function utilizes BFS, and can be used to calculate the sum of element at even levels or odd levels.
For example, given a binary tree. Write a function that takes only root node as argument and returns (sum of values at odd height)-(sum of values at even height).

25. Traversing level-order: Breadth-first traversal 
It's nice when we have a tree with ordering properties such as a BST or a heap. Often we're given a tree that isn't BST or a heap. For instance, we may have a tree that is a representation of a family tree or a company job hierarchy. We have to use different techniques to retrieve data from this kind of tree. One common class of problems involves searching for a particular node. There are two very common search algorithms.
One way to search a tree is to do a breadth-first search (BFS). In a BFS we start with the root, move left to right across the second level, then move left to right across the third level, and so on. We continue the search until either we have examined all of the nodes or we find the node we are searching for. The time to find a node is O(n), so this type of search is best avoided for large trees. A BFS also uses a large amount of memory because it is necessary to track the child nodes for all nodes on a given level while searching that level.
BreadthFirstTraversal() 

26. Printing elements at the same level
* BreadthFirst_LevelElement_Print(root, levVec) 
It is used to print all elements at the same level (depth). The parameters are root and 2D vector levVec. The vector has the depth information and being used to set the size of the first index which is index for level. While traversing with Breadth First approach, each node will be pushed into the vector after finding the level of the element using getLevel() function. So, it looks like this for the tree diagram above.
Level at 0: F
Level at 1: B G
Level at 2: A D I
Level at 3: C E H
                 

* levelPrint(root, elm, level) 
Prints all nodes at the same level.
This is simpler than BreadthFirst_LevelElement_Print(). 
It takes 2D vector (elm) with the same size of level (= MaxDepth+1) and fills elements as we traverse (preOrder).
27. Depth-First Search 
Another common way to search for a node is by using a depth-first search (DFS). A depth-first search follows one branch of the tree down as many levels as possible until the target node is found or the end is reached. When the search can't go down any farther, it is continued at the nearest ancestor with unexplored children. DFS has much lower memory requirements than BFS because it is not necessary to store all of the child pointers at each level. In addition, DFS has the advantage that it doesn't examine any single level last (BFS examines the lower level last). This is useful if we suspect that the node we are searching for will be in the lower levels. In this case, a DFS would usually find the target node more quickly than a BFS.
InOrder(), PreOrder(), PostOrder()
