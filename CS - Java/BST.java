import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * This class creates the public methods needed for 
 * a Binary Search Tree, which is a binary tree that utilizes
 * the property that everything to the left of a given node
 * will be less than it, and all nodes to the right greater
 * than it.
 *
 * 
 * @author Stephanie Remy
 * @param <T extends Comparable <? super T>>
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {

	private Node<T> root;
	private int size = 0; 

	@Override
    public String toString() {
      if (root == null) {
    	  return "()";
      }
      return root.toString();
    }
	@Override
    public void add(T data) {
    	if (data == null) {
    		throw new IllegalArgumentException("Data is empty.");
    	} else if (root == null || root.getData() == null) {
        	root = new Node<T>(data);
        	root.setLeft(null);
        	root.setRight(null);
        	size++;
        } else {
        	helperAdd(root, data);
        	
        }
      }
	/**
	 * A private recursion method that looks through the tree to find the
	 * right location.
	 * @param node The node to compare the data to.
	 * @param data The data being added to the tree.
	 */
    private void helperAdd(Node<T> node, T data) {
    	if (data.compareTo(node.getData()) < 0) {
    		if (node.getLeft() == null || node.getLeft().getData() == null) {
    			Node<T> newNode = new Node<T>(data);
    			newNode.setLeft(null);
    			newNode.setRight(null);
    			size++;
    			node.setLeft(newNode);
    		} else {
    			node = node.getLeft();
    			helperAdd(node, data);
    		}
    	} else if (data.compareTo(node.getData()) > 0) {
    		if (node.getRight() == null || node.getRight().getData() == null) {
    			Node<T> newNode = new Node<T>(data);
    			newNode.setLeft(null);
    			newNode.setRight(null);
    			size++;
    			node.setRight(newNode);
    		} else {
    			node = node.getRight();
    			helperAdd(node, data);
    		}
    	} else {
    		System.out.println("The list already contains the data.");
    	}
    }
    @Override
    public void addAll(Collection<T> c) {
    	if (c == null) {
    		throw new IllegalArgumentException("Data is null.");
    	}
        for (T data: c) {
        	if (data == null) {
        		throw new IllegalArgumentException("Data is empty.");
        	}
        	add(data);
        }
      }
    @Override
    public T remove(T data) {
    	if (data == null) {
    		throw new IllegalArgumentException("Data is empty.");
    	} else {
    		T dataTree = recursionHelper(root, data, 1);
    		return dataTree;
    	}
      }
    /**
     * Finds the successor of the node and sets the node's
     * data to the data of the successor. Then if the successor has
     * a child, the child replaces the successor; otherwise it
     * calls setParentNode.
     * @param node The node that the data is being replaced.
     */
    private void successorMethod(Node<T> node) {
    	Node<T> oldNode = node;
    	boolean wentRight = false;
    	int wentLeft = 0;
		if (node.getRight() != null && node.getRight().getData() != null) {
			node = node.getRight();
			wentRight = true;
		}
		while (node.getLeft() != null && node.getLeft().getData() != null) {
			node = node.getLeft();
			wentLeft++;
		}
		T data = node.getData();
		oldNode.setData(data);
		if (node.getRight() != null) {
			Node<T> nodeRight = node.getRight();
			node.setRight(nodeRight.getRight());
			node.setLeft(nodeRight.getLeft());
			node.setData(nodeRight.getData());
		} else {
			setParentNode(oldNode, wentLeft, wentRight);
		}
    }
    /**
     * Sets the parent node of the successor to point to null.
     * @param node The original replaced node.
     * @param wentLeft Integer of many times it went left.
     * @param wentRight Boolean if it went right or not.
     */
    private void setParentNode(Node<T> node, int wentLeft, boolean wentRight) {
    	if (wentRight && (wentLeft == 0)) {
    		node.setRight(null);
    	} else if (wentRight && (wentLeft > 0)) {
			node = node.getRight();
		    for (int i = 0; i < (wentLeft - 1); i++) {
			    node = node.getLeft();
		    }
		    node.setLeft(null);
		} else {
		    for (int i = 0; i < (wentLeft - 1); i++) {
			    node = node.getLeft();
		    }
		    node.setLeft(null);
		}
		
    }
    /**
     * If the node being removed has no successors, this method is called.
     * Finds the parent node and points it to null for the removed node.
     * @param curr Takes in a node to compare to the data.
     * @param data The data that was removed.
     */
    private void findParentNode(Node<T> curr, T data) {
    	if (root.getData().compareTo(data) == 0) {
    		root = null;
    	} else {
    		if (data.compareTo(curr.getData()) < 0) {
    			if (curr.getLeft() != null) {
    				if (curr.getLeft().getData().compareTo(data) == 0) {
    					curr.setLeft(null);
    				} else {
        		        findParentNode(curr.getLeft(), data);
    				}
    			}
        	} else {
        		if (curr.getRight() != null) {
        			if (curr.getRight().getData().compareTo(data) == 0) {
        				curr.setRight(null);
        			} else {
        		        findParentNode(curr.getRight(), data);
        			}
    			}
        	}
    	}
    }
    /**
     * A recursive method to help remove, contains, and get.
     * Basically looks through the tree for the data desired.
     * @param node The current node that the data is being compared to.
     * @param data The data being looked for.
     * @param choice Tells the method if it is going to remove, or just look for data.
     * @return
     */
    private T recursionHelper(Node<T> node, T data, int choice) {
    	if (node != null) {
    	T dataTree;
    	if (node.getData().compareTo(data) == 0) {
    		dataTree = node.getData();
    		if (choice == 1) {
    			size--;
    			if (node.getRight() == null && node.getLeft() == null) {
    			    findParentNode(root, data);
    			} else {
    				successorMethod(node);
    			}
    		}
    	} else if (data.compareTo(node.getData()) < 0) {
    		if (node.getLeft() == null) {
    			dataTree = null;
    		} else {
    		    dataTree = recursionHelper(node.getLeft(), data, choice);
    		}
    	} else {
    		if (node.getRight() == null) {
    			dataTree = null;
    		} else {
    			dataTree = recursionHelper(node.getRight(), data, choice);
    		}
    	}
    	return dataTree;
    	} else {
    		return null;
    	}
    }
    @Override
    public T get(T data) {
        if (data == null) {
        	throw new IllegalArgumentException("Data is empty.");
        } else {
        	T dataTree = recursionHelper(root, data, 2);
        	return dataTree;
        }
      }
    @Override
    public boolean contains(T data) {
        if (data == null) {
        	throw new IllegalArgumentException("Data is empty.");
        } else {
        	if (root == null) {
        		return false;
        	}
        	T dataTree = recursionHelper(root, data, 2);
        	return (dataTree != null);
        }
      }
    @Override
    public List<T> preOrder() {
    	List<T> list = new ArrayList<T>();
    	if (root == null) {
    		return list;
    	}
    	preOrderHelper(list, root);
    	return list;
    }
    /**
     * Recursive method that helps make the tree in preOrder.
     * @param list The list being added to.
     * @param node The current node being checked.
     */
    private void preOrderHelper(List<T> list, Node<T> node) {
    	if (node != null) {
    		list.add(node.getData());
    		if (node.getLeft() != null) {
    			preOrderHelper(list, node.getLeft());
    		}
    		if (node.getRight() != null) {
    			preOrderHelper(list, node.getRight());
    		}
    	}
    }
    @Override
    public List<T> inOrder() {
    	List<T> list = new ArrayList<T>();
    	if (root == null) {
    		return list;
    	}
    	inOrderHelper(list, root);
    	return list;
      }
    /**
     * Recursive method that helps make the tree inOrder.
     * @param list The list being added to.
     * @param node The current node being checked.
     */
    private void inOrderHelper(List<T> list, Node<T> node) {
    	if (node != null) {
    		if (node.getLeft() != null) {
    			inOrderHelper(list, node.getLeft());
    		}
        	list.add(node.getData());
    		if (node.getRight() != null) {
    			inOrderHelper(list, node.getRight());
            }
    	}
    }
    @Override
    public List<T> postOrder() {
    	List<T> list = new ArrayList<T>();
    	if (root == null) {
    		return list;
    	}
    	postOrderHelper(list, root);
    	return list;
      }
    /**
     * Recursive method that helps make the tree in postOrder.
     * @param list The list being added to.
     * @param node The current node being checked.
     */
    private void postOrderHelper(List<T> list, Node<T> node) {
    	if (node != null) {
        	if (node.getLeft() != null) {
  	            postOrderHelper(list, node.getLeft());
            }
    	    if (node.getRight() != null) {
          	    postOrderHelper(list, node.getRight());
            }
            list.add(node.getData());
    	}
    }
    @Override
    public List<T> levelOrder() {
    	List<T> list = new ArrayList<T>();
    	if (root == null) {
    		return list;
    	} else {
    		Queue<Node<T>> queue = new LinkedList<Node<T>>();
        	queue.add(root);
            while (!queue.isEmpty()) {
        		Node<T> curr = queue.poll();
        		list.add(curr.getData());
        		if (curr.getLeft() != null) {
        			queue.add(curr.getLeft());
        		}
        		if (curr.getRight() != null) {
        			queue.add(curr.getRight());
        		}
        	}
        	return list;
        }
    }
    @Override
    public boolean isEmpty() {
        return (size == 0);
      }
    
    @Override
    public int size() {
        return this.size;
      }
    @Override
    public void clear() {
        root = null;
        size = 0;
      }
}
