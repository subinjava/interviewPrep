package com.test;
// Java program to show working
// of user-defined Generic classes

// We use < > to specify Parameter type
class Test2<T> {
	// An object of type T is declared
	T obj;
	Test2(T obj) { this.obj = obj; } // constructor
	public T getObject() { return this.obj; }
}

// Driver class to test above
class Main {
	public static void main(String[] args)
	{
		// instance of Integer type
		Test2<Integer> iObj = new Test2<Integer>(15);
		System.out.println(iObj.getObject());

		// instance of String type
		Test2<String> sObj
			= new Test2<String>("GeeksForGeeks");
		System.out.println(sObj.getObject());
		//iObj = sObj; // This results an error
	}
}
