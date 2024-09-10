package ru.aston.intensive2024;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *  Dumb arraylist. Without any Collection support or any List extends. 
 */
public class MarrayList<T extends Object>{

	/**
	 *  Adds an element of T type to the list tail. Expands the array if necessary.
	 *  @param newElem  - Object
	 */
	public int addElem(T newElem) {

		if (this.size == this.array.length) {
			this.expand();
		}
		
		this.array[this.size] = newElem;
		this.size++;
		return this.size;
	}	
	
	/**
	 * Delete an element at index. No trim of array.
	 * @param index 
	 * @return size of the list
	 */
	public int deleteElemAt(int index) {
		
		if (index < this.size && index >= 0) {
		
			for (int i = index; i < this.size; i++) {
				this.array[i] = this.array[i+1];
			}
		}
		
		this.size--;
		return this.size;
	}	
	
	public T get(int index) {
		if (index < this.size && index >= 0) {
			return this.array[index];
		}
		else return null;
		}
	
	public void set(int index, T value) { 
		if (index < this.size && index >= 0) {		
	        this.array[index] = value;  
	    }  	
	}
	
	/** Clears list by re-init of an array 
	 * 
	 */
	public void clearList() {
		
		this.array = (T[]) Array.newInstance(this.elementClass, this.array.length);
		this.size = 0;
	}
	
	/** Built-in sort with Arrays.sort
	 * 
	 */
	public void sort() {
		T[] sortArray = (T[]) new Object[size]; 
		
		for (int i = 0; i < size; i++) {
			sortArray[i] = this.array[i];
		}
		
		Arrays.sort(sortArray);
		System.out.println("Array sorted!");
		
		for (int i = 0; i < size; i++) {
			this.array[i] = sortArray[i];
		}		
		
	}
	
	public int size() {
		return this.size;
	}
	
	public T[] toArray() {
		return this.array;
	}
	
	private void expand() {
		T[] newArray = (T[]) Array.newInstance(elementClass, size + size);
		
		for (int i = 0; i < size; i++) {
			newArray[i] = this.array[i];
		}
		
		this.array = newArray;
	}
	
	
	
	public MarrayList(Class<T> elementClass) {
		super();
		this.elementClass = elementClass;
		this.array = (T[]) Array.newInstance(this.elementClass, DEFAULT_ARRAY_SIZE);
		this.size = 0;		
	}

	public MarrayList(Class<T> elementClass, int length) {
		super();
		this.size = 0;
		this.elementClass = elementClass;
		this.array = (T[]) Array.newInstance(elementClass, length);		
	}
		
	
	public MarrayList(T[] array) {
		super();
		this.array = array;
		this.size = array.length;
		this.elementClass = array[0].getClass();
	}


	private T[] array;
	private int size;
	private Class<? extends Object> elementClass; 
	private final int DEFAULT_ARRAY_SIZE = 10;
}
