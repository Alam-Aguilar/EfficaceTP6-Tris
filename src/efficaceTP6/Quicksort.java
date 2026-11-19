package efficaceTP6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Quicksort<K extends Comparable<K>>{

	
//	Implementation de base
	
//	1. Pour mieux comprendre comment fonctionne le partitionnement, d´erouler l’algorithme pas
//	`a pas (walkthrough) sur un tableau de quelques valeurs d’exemple. Pour ¸ca, on pourra
//	repr´esenter le contenu du tableau `a trier `a chaque ´etape.
//	2. Impl´ementer une m´ethode de partitionnement, puis impl´ementer le Quicksort.
	
	public static <K> void qSort(Queue<K> s, Comparator<K> comp) {
		
		int n = s.size();
		
		if(n < 2) return;
		
		K pivot = s.peek();
		
		Queue<K> g = new LinkedList<K>();
		Queue<K> l = new LinkedList<K>();
		Queue<K> e = new LinkedList<K>();
		
		while(!s.isEmpty()) {
			K element = s.poll(); //s.deQueue(); 

            int c = comp.compare(pivot, element);

            if (c > 0) {
                l.add(element); //l.enQueue(element); 
            } else if (c < 0) {
                g.add(element); //g.enQueue(element); 
            } else {
                e.add(element);
            }
		}
		
		qSort(l, comp);
		qSort(g, comp);

		while(!l.isEmpty()) {
			s.add(l.poll());	
		}
		while(!e.isEmpty()) {
			s.add(e.poll());	
		}
		while(!g.isEmpty()) {
			s.add(g.poll());	
		}		
		
	}
	
	
	public static void main(String args[])
    {
		

	Queue<Integer> array = new LinkedList<>();
	
	Comparator<Integer> comp = Comparator.naturalOrder();
	
	array.add(5);
	array.add(2);
	array.add(1);
	array.add(4);
	array.add(3);
	
	qSort(array, comp);
	
	System.out.println(array); // array trie => [1, 2, 3, 4, 5]
		
    }

}


//
////ArrayList<Integer> array = new ArrayList<Integer>();
////
////array.add(5);
////array.add(2);
////array.add(1);
////array.add(4);
////array.add(3);
//
//ArrayList<Integer> arrayHigher;
//ArrayList<Integer> arrayLower;
//ArrayList<Integer> arrayPivot;
//Integer pivot;
//
//if(array.size() > 1) {
//	pivot = array.getLast();
//} else return;
//
//for(Integer element : array) {
//	if(element < pivot) {
//		arrayLower.add(element);
//	} else if(element > pivot) {
//		arrayHigher.add(element);
//	} else {
//		arrayPivot.add(element);
//	}
//}

