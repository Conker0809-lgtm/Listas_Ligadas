//@Hugo Nieto Ramirez
public class linkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public linkedList (int value){
        Node newNode=new Node(value);
        length=1;
        head=newNode;
        tail=newNode;
    }
    public void getHead(){
        System.out.println("Head:" + head.value);
    }
    public void getTail(){
        System.out.println("Tail:" + tail.value);
    }
    public void getLength(){
            System.out.println("Length:" + length);
    }
    //agrega un nodo a la lista
    public void append(int value){
        //Si el tamaño de la lista es 0 se agrega un Nodo con un valor como contenido
        if(length==0){
            Node newNode=new Node(value);
            length=1;
            head=newNode;
            tail=newNode;
            return;
        }
        /*Los siguientes Nodos que se vayan creando seran acomodados despues de la cola
        convirtiendose en ella y a su paso aumentando el contador del tamaño de la lista
        */
        Node newNode=new Node(value);
        tail.next=newNode;
        tail=newNode;
        length++;
    }
    //imprime la lista completa si no esta vacia
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    //remueve el ultimo nodo de la lista
    public Node removeLast(){
        /*si el tamaño de la lista es 0 regresa null pero si esta no contiene null despues del nodo 
        el metodo se va a ir recorriendo hasta llegar a la cola donde si avanza y da null el contador 
        disminuye de nuevo a la para poder remover el Nodo */
        if(length==0){
            return null;
        }
        Node temp=head;
        Node pre=head;
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }
    //Agrega un Nodo hasta la cabeza en la lista
    public void prepend(int value){
        /* Se crea un Nodo con cualquier valor dentro y directamente a la punta
        aumentado el contador del tamaño de la lista
        */
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }
    //remueve el primer Nodo de la lista
    public void removeFirst(){
        /* Primero lee si la cabeza no esta vacia, si lo esta imprime un mensaje 
        y si no lo esta remueve el nodo que estaba a la cabeza
        */
        if(head == null){
            System.out.println("La lista ya esta vacia. ");
            return;
        }
        head = head.next;
    }
    //Obtiene el nodo desaseado segun el indice que se le indica
    public int get(int index){
        /*Verifica si el indice no es menor que 0 o si el indice indicado esta 
        fuera del rango pemitido, si lo es lanza un exception con un mensaje,
        si no el metodo toma el nodo segun el indice indicado
        */
        if(index < 0){
            throw new IndexOutOfBoundsException("Indice negativo no permitido");
          
        }
        Node act = head;
        int cont = 0;
        while(act != null){
            if(cont == index){
                return act.value;
            }
            act = act.next;
            cont++;
        }
        throw new IndexOutOfBoundsException("Indice fuera de rango" + index);
    }
    //Este metod cabia el contenido del nodo seleccionado por el idice
    public boolean set(int index, int value){
        /* Verifica si el indice indicado no esta fuera de los limites
        permitidos del tamaño de la lista para despues poder cambiar 
        el valor del Nodo indicado
        */
        if(index < 0 || index >= length){
            return false;
        }
        Node act = head;
        for(int i = 0; i < index; i++){
            act = act.next;
        }
        act.value = value;
        return true;
    }
    //Agrega un nuevo nodo a la lista en cualquier posicion seleccionada
    public boolean insert(int index, int value){
        /* Verifica si el indice no exede el limite permitido del tamaño de la lista
        para despues agregar un nuevo Nodo segun la posicion indicada
        */
        if(index < 0 || index >= length){
            return false;
        }
        Node newNode = new Node(value);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }else{
            Node act = head;
            for(int i = 0; i < index - 1; i++){
                act = act.next;
            }
            newNode.next = act.next;
            act.next = newNode;
        }
        length++;
        return true;
    }
    //remueve cualquier nodo segun el indice indicado
    public int remove(int index) {
     if (head == null) {
         throw new IndexOutOfBoundsException("La lista está vacía");
     }

     if (index < 0) {
         throw new IndexOutOfBoundsException("Índice inválido: " + index);
     }

     // Caso especial: eliminar la cabeza
     if (index == 0) {
         int valor = head.value;
         head = head.next;
         length--;
         return valor;
     }

     // Buscar el nodo anterior al que queremos eliminar
     Node act = head;
     int cont = 0;

     while (act != null && cont < index - 1) {
         act = act.next;
         cont++;
     }

     // Verificar que el índice exista
     if (act == null || act.next == null) {
         throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
     }

     // Guardar el valor y eliminar el nodo
     int valor = act.next.value;
     act.next = act.next.next;
     length--;

     return valor;
    }
   //Cambia el sentido de la direccion de la lista
    public void reverse(){
        /*Se declara las variables de los apuntadores del anterior, 
        actual y siguiente Nodo en el que se encuentran*/
        Node before = null;
        Node actually = head;
        Node next = null;
        /*Si el actual es dirente a null entonces va a ir avanzando mientra va
        va cambiando su direccion
        */
        while(actually != null){
            next = actually.next;
            actually.next = before;
            before = actually;
            actually = next;
        }
        head = before;
    }
    //Obtiene el nodo de en medio
    public int medio() {
        Node nodoMedio = medioRec(head, head);
    
        if (nodoMedio == null) {
            return -1; 
        }
        return nodoMedio.value;
    }

    private Node medioRec(Node lento, Node rapido) {
        if (rapido == null || rapido.next == null) {
            return lento;
        }
        return medioRec(lento.next, rapido.next.next);
    }
    //verifica si la lista se cicla o no
    public boolean ciclo() {
        if (head == null) return false;
        Node lento = head;
        Node rapido = head;
        while (rapido != null && rapido.next != null) {
            lento = lento.next;           // avanza 1
            rapido = rapido.next.next;    // avanza 2
            if (lento == rapido) {        // se encontraron → hay ciclo
                return true;
        }
    }
        return false; // llegaron al final sin encontrarse → no hay ciclo
    }
}