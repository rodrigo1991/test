El programa consiste principalmente en 2 métodos; agregaNodo y encuentraNodo:

1.- agregaNodo:
Este método instancia una clase "Node", la cual posee un key (el número dado) y un leftChild y rightChild (arbol binario...) en caso de que el atributo "raiz" de tipo "Node" de la clase principal se encuente null, este método agregaNodo lo seteará y no hará nada más; en cambio si la el atributo raiz no es nulo, entra en un loop preguntando si el key entregado por parámetro es menor que el actual nodo, de ser así situa el mismo nodo actual hacia la leftChild y mientras no sea "null" continua avanzando hasta dar con un null, es ahí entonces dnde se setea a este último nodo un leftChild con el valor desde el parámetro, en caso de ser el valor del parámetro, mayor que el nodo actual, se sitúa el nodo actual hacia rightChild
2.- encuentraNodo:
Mientras el nodo actual, partiendo por la raíz, sea distinto al dado por parámetro se consulta si este valor dado parámetro es menor al nodo actual, de ser así nos situamos/avanzamos a leftChild, sino a rightChild y sumamos +1 a un contador, retornándose este mismo contador al momento de dar con el nodo consultado por parámetro, sino se encuentra ningún nodo, devolvemos -1
3.- distancia entre nodos:
dado 2 parámetros se llama 2 veces al método encuentraNodo y se suman los valores, en caso de que cualquiera de estos, no haya sido encontrado, retornamos -1
