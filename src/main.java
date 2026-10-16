//@Hugo Nieto Ramirez
public class main {
public static void main(String[] args) {
        linkedList ll = new linkedList(10);
        ll.append(20);
        ll.append(30);
        ll.append(40);
        ll.append(50);
        ll.printList();
        System.out.println("DATOS ADICIONALES");
        ll.getHead();
        ll.getTail();
        ll.getLength();
        System.out.println("Probando REMOVE 50");
        System.out.println( ll.removeLast().value );
                System.out.println("Probando REMOVE 40");
        System.out.println( ll.removeLast().value );
                System.out.println("Probando REMOVE 30");
        System.out.println( ll.removeLast().value );
                System.out.println("Probando REMOVE 20");
        System.out.println( ll.removeLast().value );
                System.out.println("Probando REMOVE 10");
        System.out.println( ll.removeLast().value );
       
        System.out.println("Probando REMOVE vacio");
        System.out.println( ll.removeLast() );
       
        ll.append(100);
        System.out.println("IMPRIME LISTA CON 100");
        ll.printList();
        ll.append(200);
        System.out.println("IMPRIME LISTA CON 100 Y 200");
        ll.printList();
        System.out.println("Pruebas de los metodos agregados:");
        ll.append(55);
        ll.append(88);
        ll.append(78);
        ll.append(45);
        ll.append(75);
        ll.append(64);
        ll.printList();
        System.out.println("DATOS ADICIONALES");
        ll.removeFirst();//Prueba para remove first
        ll.prepend(25);//Prueba del prepend
        ll.printList();
        ll.getHead();
        ll.getTail();
        ll.getLength();
        System.out.println("Probando get");
        System.out.println(ll.get(3));
        System.out.println("Probando  set");
        System.out.println(ll.set(2, 20));
        System.out.println("Probando insert");
        System.out.println(ll.insert(1, 96));
        System.out.println("Probando remove");
        System.out.println(ll.remove(3));
        System.out.println("lista completa actualmente");
        ll.reverse();//Cambiando la direccion en donde apunta la lista
        ll.printList();
        System.out.println("Probando medio");
        System.out.println(ll.medio());
        System.out.println("Verificar si la lista se cicla");
        System.out.println(ll.ciclo());
        
        
        
        
       
    }
   
}