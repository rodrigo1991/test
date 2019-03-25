package ejecutable.ejecutable;

import java.util.Scanner;

public class BinaryTree {

	private Node root;

	public static void main(String[] args) {
		
		System.out.println("ingrese números separados por coma...");

		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		System.out.println(inputString);

		BinaryTree theTree = new BinaryTree();
		
		String[] data = inputString.split(",");

		for(int x = 0; x<data.length; x++) {
			theTree.addNode(Integer.valueOf(data[x]));
		}
		

		// Different ways to traverse binary trees

		// theTree.inOrderTraverseTree(theTree.root);

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\nNode with the key 4");

		System.out.println(theTree.findNode(4));

	}

	public void addNode(int key) {

		// Create a new Node and initialize it

		Node newNode = new Node(key);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.getKey()) {

					// Switch focus to the left child

					focusNode = focusNode.getLeftChild();

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.setLeftChild(newNode);
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.getRightChild();

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.setRightChild(newNode);
						return; // All Done

					}

				}

			}
		}

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.getLeftChild());

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.getRightChild());

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.getLeftChild());
			preorderTraverseTree(focusNode.getRightChild());

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.getLeftChild());
			postOrderTraverseTree(focusNode.getRightChild());

			System.out.println(focusNode);

		}

	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (focusNode.getKey() != key) {

			// If we should search to the left

			if (key < focusNode.getKey()) {

				// Shift the focus Node to the left child

				focusNode = focusNode.getLeftChild();

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.getRightChild();

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}

}
