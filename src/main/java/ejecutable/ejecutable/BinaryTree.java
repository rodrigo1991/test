package ejecutable.ejecutable;

import java.util.Scanner;

public class BinaryTree {

	private Node raiz;
	private static BinaryTree theTree;

	public static void main(String[] args) {		
		
		//4,3,16,10,7,20,12

		
		theTree = new BinaryTree();
		
		while(true) {
			
			Scanner scanner = null;
			String inputString = null;
			
			System.out.println("ingrese opción...");
			System.out.println("1 ingresar números");
			System.out.println("2 Busque distancia entre la raíz y un nodo en particular");
			System.out.println("3 Busque la distancia entre dos nodos");
			System.out.println("-1 Para salir dep programa");
			scanner = new Scanner(System.in);
			String opcion = scanner.nextLine();
			
			switch (opcion) {
			case "1":
				System.out.println("ingrese números separados por coma...");
				
				scanner = new Scanner(System.in);
				inputString = scanner.nextLine();
				
				String[] data = inputString.split(",");
		
				for(int x = 0; x<data.length; x++) {
					theTree.addNode(Integer.parseInt(data[x]));
				}
				break;

			case "2":
				
				System.out.println("ingrese nodo a buscar...");
				scanner = new Scanner(System.in);
				inputString = scanner.nextLine();
				
				int distancia = theTree.findNode(Integer.parseInt(inputString));
				System.out.println("La distancia es: "+ distancia);

				break;

			case "3":

				System.out.println("ingrese primer nodo a buscar...");
				scanner = new Scanner(System.in);
				inputString = scanner.nextLine();				
				int primera = theTree.findNode(Integer.parseInt(inputString));
				
				System.out.println("ingrese segundo nodo a buscar...");
				scanner = new Scanner(System.in);
				inputString = scanner.nextLine();
				int dist = theTree.findNode(Integer.parseInt(inputString));
				System.out.println("Distancia total es: "+ calculaDistancia(primera, dist));
				
				break;
				
			case "-1":
				System.exit(0);

			default:
				break;
			}
		}

	}

	private static int calculaDistancia(int distancia, int dist) {
		
		if(distancia<0 || dist<0) {
			return -1;
		}
		return distancia+dist;
	}

	public void addNode(int key) {

		// Crea un nuevo nodo y lo inicializa

		Node newNode = new Node(key);

		// si no hay ninguna raíz este se convierte en la raíz

		if (raiz == null) {

			raiz = newNode;

		} else {

			Node focusNode = raiz;

			Node parent;

			while (true) {

				parent = focusNode;

				//valida si el nuevo nodo debe ir a la izquierda

				if (key < focusNode.getKey()) {

					// setea el nodo actual usado a la izquierda

					focusNode = focusNode.getLeftChild();					

					if (focusNode == null) {


						parent.setLeftChild(newNode);
						return; 

					}

				} else { 

					focusNode = focusNode.getRightChild();


					if (focusNode == null) {


						parent.setRightChild(newNode);
						return;

					}

				}

			}
		}

	}

	public int findNode(int key) {

		int x=0;
		Node focusNode = raiz;

		while (focusNode.getKey() != key) {


			if (key < focusNode.getKey()) {

				focusNode = focusNode.getLeftChild();

			} else {

				focusNode = focusNode.getRightChild();
			}

			if (focusNode == null) {
				return -1;
			}
			
			x++;

		}

		return x;

	}

}
