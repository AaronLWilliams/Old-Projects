/*
 * Aaron Williams
 * COSC 3331
 * BinarySearchTreePractice
 * 
 * This program ask the user to give them a sting of only upper or lower case letters(not both).  It then will store them in a binary search tree.  It will ask
 * the user to enter a key and show the path to it with 0(left child) and 1(right child).  It then will ask the user for another key and print the characters in the reverse path.
 * Afterwards the program will output the whole tree.
 * 
 * A note to make is that if the key does not exist, the program will print the would be path to it but say it was not found.  Also if the are duplicates, the program will pick
 * the leftmost one.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTreePractice 
{
	static class Node
	{
		char letter;
		Node leftChild;
		Node rightChild;
		
		public void displayNode()
		{
			System.out.print(letter);
		}
	}//end class Node
	static class Tree
	{
		private Node root;// root of the tree
		
		public Tree()//constructor
		{
			root = null;
		}
		public Node find(char key)
		{
			Node current = root;
			while(current.letter != key)
			{
				if(key < current.letter)
					current = current.leftChild;
				else
					current = current.rightChild;
				if(current == null)
					return null;
			}
			return current;
		}
		public void insert(char id)
		{
			Node newNode = new Node();
			newNode.letter = id;
			if(root == null)
				root = newNode;
			else
			{
				Node current = root;
				Node parent;
				while(true)
				{
					parent = current;
					if(id < current.letter)
					{
						current = current.leftChild;
						if(current == null)
						{
							parent.leftChild = newNode;
							return;
						}
					}
					else
					{
						current = current.rightChild;
						if(current == null)
						{
							parent.rightChild = newNode;
							return;
						}
					}
				}
			}
		}
		
		public Node recFind(char key, Node current)// given a key, prints the path to it with 1's and 0's
		{
			if (current.letter == key)
				return current;
			if (current.leftChild == null && current.rightChild == null)
			{
				System.out.println();
				System.out.println(key + " was not found.");
				return null;
			}
			else if(key < current.letter)
			{
				System.out.print("0 ");
				recFind(key, current.leftChild);
			}
			else if(key > current.letter)
			{
				System.out.print("1 ");
				recFind(key, current.rightChild);
			}
			return current;
		}
		
		public Node recReverse(char key, Node current)// given a key, prints the reverse path with the characters
		{
			if (current.letter == key)
			{
				current.displayNode();
				return current;
			}
			if (current.leftChild == null && current.rightChild == null)
			{
				System.out.println();
				System.out.println(key + " was not found.");
				return null;
			}
			else if(key < current.letter)
				recReverse(key, current.leftChild);
			else if(key > current.letter)
				recReverse(key, current.rightChild);
			current.displayNode();
			return current;
		}
		
		public void displayTree()
		{	
			Stack globalStack = new Stack();
			globalStack.push(root);
			int nBlanks = 32;
			boolean isRowEmpty = false;
			System.out.println("..................................");
			while(isRowEmpty==false)
			{
				Stack localStack = new Stack();
				isRowEmpty = true;
				
				for(int j=0; j<nBlanks; j++)
					System.out.print(" ");
				
				while(globalStack.isEmpty()==false)
				{
					Node temp = (Node)globalStack.pop();
					if(temp != null)
					{
						System.out.print(temp.letter);
						localStack.push(temp.leftChild);
						localStack.push(temp.rightChild);
						
						if(temp.leftChild != null || temp.rightChild != null)
							isRowEmpty = false;
					}
					else
					{
						System.out.print("--");
						localStack.push(null);
						localStack.push(null);
					}
					for(int j=0; j<nBlanks*2-2; j++)
						System.out.print(' ');
				}
				System.out.println();
				nBlanks /= 2;
				while(localStack.isEmpty()==false)
					globalStack.push(localStack.pop());
			}
			System.out.println("..................................");
		}//end displayTree()
		
	}
	public static void main(String args[]) throws IOException
	{
		//obtains the input form user and stores the binary tree
		System.out.println("Please enter alphabetical letters(upper or lower case only, not both)");
		String input = getString();
		Tree binary = new Tree();
		//shows the tree
		for(int i = 0; i < input.length(); i++)
			binary.insert(input.charAt(i));
		//display a path to given key
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a key to search a path for.");
		char key = sc.next().charAt(0);
		binary.recFind(key, binary.root);
		System.out.println();
		//displays reverse path to a key
		System.out.println("Please enter a key to show the reverse path to.");
		key = sc.next().charAt(0);
		binary.recReverse(key, binary.root);
		System.out.println();
		//displays the whole tree
		binary.displayTree();
		
	}
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
