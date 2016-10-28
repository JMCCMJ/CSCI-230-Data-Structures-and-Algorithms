package edu.cofc.cs.csci230;

public class MyNumber <AnyType>{
	private AnyType num;
	
	public AnyType get(){
		return num;
	}
	public void set(AnyType num){
		this.num = num;
	}
	public String toString(){
		String temp = num.toString();
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNumber<String> myNum = new MyNumber<String>();
		myNum.set("hi");
		System.out.println(myNum);

	}

}
