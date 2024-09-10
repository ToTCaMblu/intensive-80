package ru.aston.intensive2024;

public class Main {

	public static void main(String[] args) {
		MarrayList<String> strings = new MarrayList<String>(String.class);
		
		strings.addElem("First");
		strings.addElem("Third");		
		strings.addElem("Second");

		strings.addElem("Fourth - to delete");
		
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}

		strings.deleteElemAt(3);
		
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		
		strings.sort();
		
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		
		
		strings.clearList();
		
		strings.addElem("Sixth");
		strings.addElem("Fourth");		
		strings.addElem("Fifth");		
		strings.addElem("First");
		strings.addElem("Third");		
		strings.addElem("Second");		
		
		MarSorter.qsortArray(strings);
		
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}		
	}

}
