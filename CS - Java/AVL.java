import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Creates an AVL tree that implements BSTInterface.
 * @author Stephanie Remy
 *
 * @param <T> generic T objects
 */
public class AVL<T extends Comparable<? super T>> implements BSTInterface<T> {

	private Node<T> root;
	private int size = 0;
	private T foundData;
	private T newData = null;

	@Override
	public void add(T data) {
    	if (data == null) {
    		throw new IllegalArgumentException("Data is empty.");
    	} else {
        	root = helperAdd(data, root);
        }
	}
	/**
	 * A private recursion method that looks through the tree to find the
	 * right location.
	 * @param node The node to compare the data to.
	 * @param data The data being added to the tree.
	 * @return the new root;
	 */
    private Node<T> helperAdd(T data, Node<T> node) {
    	if (node == null) {
            node = new Node<T>(data);
            node.setLeft(null);
            node.setRight(null);
            size++;
    	} else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(helperAdd(data, node.getLeft()));
            if (node.getLeft() != null && node.getRight() != null) {
                if ((node.getLeft().getHeight() - node.getRight().getHeight()) == 2) {
                    if (data.compareTo(node.getLeft().getData()) < 0) {
                        node = rotateLeft(node);
                    } else {
                        node = doubleLeft(node);
                    }
                }
            } else if (node.getLeft() != null && node.getRight() == null) {
            	if ((node.getLeft().getHeight() - 0) == 2) {
                    if (data.compareTo(node.getLeft().getData()) < 0) {
                        node = rotateLeft(node);
                    } else {
                        node = doubleLeft(node);
                    }
                }
            } else if (node.getRight() != null && node.getLeft() == null) {
            	if ((0 - node.getRight().getHeight()) == 2) {
                    if (data.compareTo(node.getRight().getData()) > 0) {
                        node = doubleLeft(node);
                    } else {
                        node = rotateLeft(node);
                    }
                }
            } 
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(helperAdd(data, node.getRight()));
            if (node.getLeft() != null && node.getRight() != null) {
            	if ((node.getRight().getHeight() - node.getLeft().getHeight()) == 2) {
                    if (data.compareTo(node.getRight().getData()) > 0) {
                        node = rotateRight(node);
                    } else {
                        node = doubleRight(node);
                    }
                }
            } else if (node.getLeft() != null && node.getRight() == null) {
            	if ((0 - node.getLeft().getHeight()) == 2) {
                    if (data.compareTo(node.getLeft().getData()) < 0) {
                        node = doubleRight(node);
                    } else {
                        node = rotateRight(node);
                    }
                }
            } else if (node.getRight() != null && node.getLeft() == null) {
            	if ((node.getRight().getHeight() - 0) == 2) {
                    if (data.compareTo(node.getRight().getData()) > 0) {
                        node = rotateRight(node);
                    } else {
                        node = doubleRight(node);
                    }
                }
            } 
        } else {
            System.out.println("That item is already on the list.");
        }
    	if (node.getLeft() != null && node.getRight() != null) {
            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
    	} else if (node.getLeft() != null && node.getRight() == null) {
    		node.setHeight(node.getLeft().getHeight() + 1);
            node.setBalanceFactor(node.getLeft().getHeight() - 0);
    	} else if (node.getRight() != null && node.getLeft() == null) {
    		node.setHeight(node.getRight().getHeight() + 1);
            node.setBalanceFactor(0 - node.getRight().getHeight());
    	} else {
    		node.setHeight(1);
            node.setBalanceFactor(0);
    	}
        return node;
    }
    /**
     * Return maximum of left height and right height.
     * @param int lhs height of left node
     * @param int rhs height of right node
     * @return int - the greatest integer
     */
    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }
    /**
     * Rotate tree to the left once
     * @param node where rotation starts
     * @return node after rotating
     */
    private Node<T> rotateLeft(Node<T> k2) {
        Node<T> k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        if (k2.getLeft() != null && k2.getRight() != null) {
            k2.setHeight(max(k2.getLeft().getHeight(), k2.getRight().getHeight()) + 1);
            k2.setBalanceFactor(k2.getLeft().getHeight() - k2.getRight().getHeight());
    	} else if (k2.getLeft() != null && k2.getRight() == null) {
    		k2.setHeight(k2.getLeft().getHeight() + 1);
    		k2.setBalanceFactor(k2.getLeft().getHeight() - 0);
    	} else if (k2.getRight() != null && k2.getLeft() == null) {
    		k2.setHeight(k2.getRight().getHeight() + 1);
    		k2.setBalanceFactor(0 - k2.getRight().getHeight());
    	} else {
    		k2.setHeight(1);
    		k2.setBalanceFactor(0);
    	}
        if (k1.getLeft() != null && k1.getRight() != null) {
        	k1.setHeight(max(k1.getLeft().getHeight(), k1.getRight().getHeight()) + 1);
        	k1.setBalanceFactor(k1.getLeft().getHeight() - k1.getRight().getHeight());
    	} else if (k1.getLeft() != null && k1.getRight() == null) {
    		k1.setHeight(k1.getLeft().getHeight() + 1);
    		k1.setBalanceFactor(k1.getLeft().getHeight() - 0);
    	} else if (k1.getRight() != null && k1.getLeft() == null) {
    		k1.setHeight(k1.getRight().getHeight() + 1);
    		k1.setBalanceFactor(0 - k1.getRight().getHeight());
    	} else {
    		k1.setHeight(1);
    		k1.setBalanceFactor(0);
    	}
        return k1;
    }
    /**
     * Rotate binary tree node to right.
     * @param node where rotation starts
     * @return node after rotating
     */
    private Node<T> rotateRight(Node<T> k1) {
        Node<T> k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        if (k2.getLeft() != null && k2.getRight() != null) {
            k2.setHeight(max(k2.getLeft().getHeight(), k2.getRight().getHeight()) + 1);
            k2.setBalanceFactor(k2.getLeft().getHeight() - k2.getRight().getHeight());
    	} else if (k2.getLeft() != null && k2.getRight() == null) {
    		k2.setHeight(k2.getLeft().getHeight() + 1);
    		k2.setBalanceFactor(k2.getLeft().getHeight() - 0);
    	} else if (k2.getRight() != null && k2.getLeft() == null) {
    		k2.setHeight(k2.getRight().getHeight() + 1);
    		k2.setBalanceFactor(0 - k2.getRight().getHeight());
    	} else {
    		k2.setHeight(1);
    		k2.setBalanceFactor(0);
    	}
        if (k1.getLeft() != null && k1.getRight() != null) {
        	k1.setHeight(max(k1.getLeft().getHeight(), k1.getRight().getHeight()) + 1);
        	k1.setBalanceFactor(k1.getLeft().getHeight() - k1.getRight().getHeight());
    	} else if (k1.getLeft() != null && k1.getRight() == null) {
    		k1.setHeight(k1.getLeft().getHeight() + 1);
    		k1.setBalanceFactor(k1.getLeft().getHeight() - 0);
    	} else if (k1.getRight() != null && k1.getLeft() == null) {
    		k1.setHeight(k1.getRight().getHeight() + 1);
    		k1.setBalanceFactor(0 - k1.getRight().getHeight());
    	} else {
    		k1.setHeight(1);
    		k1.setBalanceFactor(0);
    	}
        return k2;
    }
    /**
     * Double rotate binary tree node: first left
     * with its right; then node k3 with new left.
     * @param node where rotation starts
     * @return node after rotating
     */
    private Node<T> doubleLeft(Node<T> k3) {
        k3.setLeft(rotateRight(k3.getLeft()));
        return rotateLeft(k3);
    }
    /**
     * Double rotate binary tree node: first right
     * with its left; then node k1 with new right.
     * @param node where rotation starts
     * @return node after rotating
     */
    private Node<T> doubleRight(Node<T> k1) {
        k1.setRight(rotateLeft(k1.getRight()));
        return rotateRight(k1);
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
    	} else if (root.getData().compareTo(data) == 0) {
    		foundData = root.getData();
    		if (root.getLeft() != null || root.getRight() != null) {
    			root = successorMethod(root);
    			setBalanceAndHeight(root, data, 1);
    			return foundData;
    		} else {
    			root = null;
    			size = 0;
    			return foundData;
    		}
    	} else {
    		root = removeHelper(data, root);
    		return foundData;
    	}
      }
    /**
     * This method continues going down the tree where the node was
     * removed and changes the heights in that part of the branch.
     * @param node The node where the successor was
     * @return the successor node
     */
	public Node<T> downTheTree(Node<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
        	node.setHeight(1);
        	node.setBalanceFactor(0);
            return node;
        } else if (node.getLeft() == null && node.getRight() != null) {
            downTheTree(node.getRight());
            if (node.getLeft() != null && node.getRight() != null) {
	            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
	    	} else if (node.getLeft() != null && node.getRight() == null) {
	    		node.setHeight(node.getLeft().getHeight() + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - 0);
	    	} else if (node.getRight() != null && node.getLeft() == null) {
	    		node.setHeight(node.getRight().getHeight() + 1);
	            node.setBalanceFactor(0 - node.getRight().getHeight());
	    	} else {
	    		node.setHeight(1);
	            node.setBalanceFactor(0);
	    	}
            return node;
        } else if (node.getRight() == null && node.getLeft() != null) {
            downTheTree(node.getLeft());
            if (node.getLeft() != null && node.getRight() != null) {
	            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
	    	} else if (node.getLeft() != null && node.getRight() == null) {
	    		node.setHeight(node.getLeft().getHeight() + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - 0);
	    	} else if (node.getRight() != null && node.getLeft() == null) {
	    		node.setHeight(node.getRight().getHeight() + 1);
	            node.setBalanceFactor(0 - node.getRight().getHeight());
	    	} else {
	    		node.setHeight(1);
	            node.setBalanceFactor(0);
	    	}
            return node;
        } else {
            downTheTree(node.getRight());
            if (node.getLeft() != null && node.getRight() != null) {
	            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
	    	} else if (node.getLeft() != null && node.getRight() == null) {
	    		node.setHeight(node.getLeft().getHeight() + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - 0);
	    	} else if (node.getRight() != null && node.getLeft() == null) {
	    		node.setHeight(node.getRight().getHeight() + 1);
	            node.setBalanceFactor(0 - node.getRight().getHeight());
	    	} else {
	    		node.setHeight(1);
	            node.setBalanceFactor(0);
	    	}
            downTheTree(node.getLeft());
            if (node.getLeft() != null && node.getRight() != null) {
	            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
	    	} else if (node.getLeft() != null && node.getRight() == null) {
	    		node.setHeight(node.getLeft().getHeight() + 1);
	            node.setBalanceFactor(node.getLeft().getHeight() - 0);
	    	} else if (node.getRight() != null && node.getLeft() == null) {
	    		node.setHeight(node.getRight().getHeight() + 1);
	            node.setBalanceFactor(0 - node.getRight().getHeight());
	    	} else {
	    		node.setHeight(1);
	            node.setBalanceFactor(0);
	    	}
            return node;
        }
    }
	/**
	 * Goes through the tree where the node was removed and
	 * changes the right heights and balance factors.
	 * @param node root node
	 * @param data the data down the tree that was changed
	 * @param choice if it had a successor or not
	 * @return root node
	 */
	private Node<T> setBalanceAndHeight(Node<T> node, T data, int choice) {
		if (node == null || data == null) {
			return null;
		}
		if (node.getData().compareTo(data) == 0) {
			    if (choice == 2) {
				    node.setHeight(1);
				    node.setBalanceFactor(0);
				    return node;
			    } else if (choice == 1) {
			    	node = downTheTree(node);
			    	if (node.getLeft() != null && node.getRight() != null) {
			            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
			            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
			    	} else if (node.getLeft() != null && node.getRight() == null) {
			    		node.setHeight(node.getLeft().getHeight() + 1);
			            node.setBalanceFactor(node.getLeft().getHeight() - 0);
			    	} else if (node.getRight() != null && node.getLeft() == null) {
			    		node.setHeight(node.getRight().getHeight() + 1);
			            node.setBalanceFactor(0 - node.getRight().getHeight());
			    	} else {
			    		node.setHeight(1);
			            node.setBalanceFactor(0);
			    	}
			    	return node;
			    }
			    return node;
		} else if (data.compareTo(node.getData()) < 0) {
				setBalanceAndHeight(node.getLeft(), data, choice);
				if (node.getLeft() != null && node.getRight() != null) {
		            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
		            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
		    	} else if (node.getLeft() != null && node.getRight() == null) {
		    		node.setHeight(node.getLeft().getHeight() + 1);
		            node.setBalanceFactor(node.getLeft().getHeight() - 0);
		    	} else if (node.getRight() != null && node.getLeft() == null) {
		    		node.setHeight(node.getRight().getHeight() + 1);
		            node.setBalanceFactor(0 - node.getRight().getHeight());
		    	} else {
		    		node.setHeight(1);
		            node.setBalanceFactor(0);
		    	}
				return node;
		} else {
				setBalanceAndHeight(node.getRight(), data, choice);
				if (node.getLeft() != null && node.getRight() != null) {
		            node.setHeight(max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1);
		            node.setBalanceFactor(node.getLeft().getHeight() - node.getRight().getHeight());
		    	} else if (node.getLeft() != null && node.getRight() == null) {
		    		node.setHeight(node.getLeft().getHeight() + 1);
		            node.setBalanceFactor(node.getLeft().getHeight() - 0);
		    	} else if (node.getRight() != null && node.getLeft() == null) {
		    		node.setHeight(node.getRight().getHeight() + 1);
		            node.setBalanceFactor(0 - node.getRight().getHeight());
		    	} else {
		    		node.setHeight(1);
		    	}
				return node;
		}
		
	}
	/**
	 * If it is right heavy, calls the right rotating method.
	 * @param node the node needing to be rotated around
	 * @param data checking if it is double or just once
	 * @return node that was rotated
	 */
	private Node<T> rightHeavyMethod(Node<T> node, T data) {
		if (node.getLeft() != null && node.getRight() != null) {
        	if ((node.getRight().getHeight() - node.getLeft().getHeight()) == 2) {
                if (data.compareTo(node.getRight().getData()) > 0) {
                    node = rotateRight(node);
                } else {
                    node = doubleRight(node);
                }
            }
        } else if (node.getLeft() != null && node.getRight() == null) {
        	if ((0 - node.getLeft().getHeight()) == 2) {
                if (data.compareTo(node.getLeft().getData()) < 0) {
                    node = doubleRight(node);
                } else {
                    node = rotateRight(node);
                }
            }
        } else if (node.getRight() != null && node.getLeft() == null) {
        	if ((node.getRight().getHeight() - 0) == 2) {
                if (data.compareTo(node.getRight().getData()) > 0) {
                    node = rotateRight(node);
                } else {
                    node = doubleRight(node);
                }
            }
        }  
		return node;
	}
	/**
	 * If it is left heavy, calls the right rotating method.
	 * @param node the node needing to be rotated around
	 * @param data checking if it is double or just once
	 * @return node that was rotated
	 */
	private Node<T> leftHeavyMethod(Node<T> node, T data) {
		if (node.getLeft() != null && node.getRight() != null) {
            if ((node.getLeft().getHeight() - node.getRight().getHeight()) == 2) {
                if (data.compareTo(node.getLeft().getData()) < 0) {
                    node = rotateLeft(node);
                } else {
                    node = doubleLeft(node);
                }
            }
        } else if (node.getLeft() != null && node.getRight() == null) {
        	if ((node.getLeft().getHeight() - 0) == 2) {
                if (data.compareTo(node.getLeft().getData()) < 0) {
                    node = rotateLeft(node);
                } else {
                    node = doubleLeft(node);
                }
            }
        } else if (node.getRight() != null && node.getLeft() == null) {
        	if ((0 - node.getRight().getHeight()) == 2) {
                if (data.compareTo(node.getRight().getData()) > 0) {
                    node = doubleLeft(node);
                } else {
                    node = rotateLeft(node);
                }
            }
        } 
		return node;
	}
	/**
	 * Recursive method to find the successor.
	 * @param node the node being replaced
	 * @return old node with successor data
	 */
	private Node<T> successorMethod(Node<T> node) {
		Node<T> oldNode = node;
		if (node.getRight() == null && node.getLeft() == null) {
			node = null;
			return null;
		}
		if (node.getRight() == null && node.getLeft() != null) {
    		while (node.getLeft().getLeft() != null) {
	    		node = node.getLeft();
		    }
		    newData = node.getLeft().getData();
		    oldNode.setData(newData);
    		if (node.getLeft().getRight() != null) {
	    		Node<T> nodeRight = node.getLeft().getRight();
		    	node.getLeft().setRight(nodeRight.getRight());
    			node.getLeft().setLeft(nodeRight.getLeft());
	    		node.getLeft().setData(nodeRight.getData());
		    } else {
			    node.setLeft(null);
		    }
    		
		}
		if (node.getRight() != null && node.getRight().getLeft() == null) {
		    newData = node.getRight().getData();
		    oldNode.setData(newData);
    		if (node.getRight().getRight() != null) {
	    		Node<T> nodeRight = node.getRight().getRight();
		    	node.getRight().setRight(nodeRight.getRight());
    			node.getRight().setLeft(nodeRight.getLeft());
	    		node.getRight().setData(nodeRight.getData());
		    } else {
			    node.setRight(null);
		    }
		} else if (node.getRight() != null && node.getRight().getLeft() != null) {
			node = node.getRight();
    		while (node.getLeft().getLeft() != null) {
	    		node = node.getLeft();
		    }
		    newData = node.getLeft().getData();
		    oldNode.setData(newData);
    		if (node.getLeft().getRight() != null) {
	    		Node<T> nodeRight = node.getLeft().getRight();
		    	node.getLeft().setRight(nodeRight.getRight());
    			node.getLeft().setLeft(nodeRight.getLeft());
	    		node.getLeft().setData(nodeRight.getData());
		    } else {
			    node.setLeft(null);
		    }
		}
		return oldNode;
	}
	/**
	 * Helps remove the node, calls other methods to balance, find successor, and rotate.
	 * @param data being removed
	 * @param node root node
	 * @return node being checked.
	 */
	private Node<T> removeHelper(T data, Node<T> node) {
	    if (node.getLeft() != null && node.getRight() != null) {
	    	if (node.getLeft().getData().compareTo(data) == 0) {
	    		foundData = node.getLeft().getData();
	    		size--;
	    		if (node.getLeft().getLeft() != null || node.getLeft().getRight() != null) {
	    			node = successorMethod(node.getLeft());
	    			setBalanceAndHeight(root, newData, 1);
	    			node = rightHeavyMethod(node, data);
	    			return node;
	    		} else {
	    			node.setLeft(null);
	    			setBalanceAndHeight(root, node.getData(), 2);
	    			node = rightHeavyMethod(node, data);
	    			return node;
	    		}
	    	} else if (node.getRight().getData().compareTo(data) == 0) {
	    		foundData = node.getRight().getData();
	    		size--;
	    		if (node.getRight().getLeft() != null || node.getRight().getRight() != null) {
	    			node = successorMethod(node.getRight());
	    			setBalanceAndHeight(root, newData, 1);
	    			node = leftHeavyMethod(node, data);
	    			return node;
	    		} else {
	    			node.setRight(null);
	    			setBalanceAndHeight(root, node.getData(), 2);
	    			node = leftHeavyMethod(node, data);
	    			return node;
	    		}
	    	} else {
	    		if (data.compareTo(node.getLeft().getData()) < 0) {
		    		node = removeHelper(data, node.getLeft());
		    	} else {
		    		node = removeHelper(data, node.getRight());
		    	}
	    	}
	    } else if (node.getLeft() != null && node.getRight() == null) {
	    	if (node.getLeft().getData().compareTo(data) == 0) {
	    		foundData = node.getLeft().getData();
	    		size--;
	    		if (node.getLeft().getLeft() != null || node.getLeft().getRight() != null) {
	    			node = successorMethod(node.getLeft());
	    			setBalanceAndHeight(root, newData, 1);
	    			node = rightHeavyMethod(node, data);
	    			return node;
	    		} else {
	    			node.setLeft(null);
	    			setBalanceAndHeight(root, node.getData(), 2);
	    			node = rightHeavyMethod(node, data);
	    			return node;
	    		}
	    	} else {
	    		node = removeHelper(data, node.getLeft());
	    	}
	    } else if (node.getLeft() == null && node.getRight() != null) {
	    	if (node.getRight().getData().compareTo(data) == 0) {
	    		foundData = node.getRight().getData();
	    		size--;
	    		if (node.getRight().getLeft() != null || node.getRight().getRight() != null) {
	    			node = successorMethod(node.getRight());
	    			setBalanceAndHeight(root, newData, 1);
	    			node = leftHeavyMethod(node, data);
	    			return node;
	    		} else {
	    			node.setRight(null);
	    			setBalanceAndHeight(root, node.getData(), 2);
	    			node = leftHeavyMethod(node, data);
	    			return node;
	    		}
	    	} else {
	    		node = removeHelper(data, node.getRight());
	    	}
	    } else {
	    	System.out.println("That item is not in the tree.");
	    	return null;
	    }
	    return node;
	}
    /**
     * A recursive method to help contains and get.
     * Basically looks through the tree for the data desired.
     * @param node The current node that the data is being compared to.
     * @param data The data being looked for.
     * @return
     */
	private T recursionHelper(Node<T> node, T data) {
    	if (node != null) {
    	T dataTree;
    	if (node.getData().compareTo(data) == 0) {
    		dataTree = node.getData();	
    	} else if (data.compareTo(node.getData()) < 0) {
    		if (node.getLeft() == null) {
    			dataTree = null;
    		} else {
    		    dataTree = recursionHelper(node.getLeft(), data);
    		}
    	} else {
    		if (node.getRight() == null) {
    			dataTree = null;
    		} else {
    			dataTree = recursionHelper(node.getRight(), data);
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
        	T dataTree = recursionHelper(root, data);
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
        	T dataTree = recursionHelper(root, data);
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
	@Override
    public String toString() {
      if (root == null) {
    	  return "()";
      }
      return root.toString();
    }
	//DO NOT MODIFY OR USE ANY OF THE METHODS BELOW IN YOUR IMPLEMENTATION
	//These methods are for testing purposes only
	public Node<T> getRoot() {
		return root;
	}
	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
