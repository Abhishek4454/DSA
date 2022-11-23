package com.coding.OOPS;


public class ComplexNumbers {
	private int real;
	private int imaginary;
	
	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginary() {
		return imaginary;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

	public ComplexNumbers(int real,int imaginary) {
		this.real=real;
		this.imaginary=imaginary;
	}
	
	public void add(ComplexNumbers c) {
		this.setReal(this.getReal()+c.getReal());
		this.setImaginary(this.getImaginary()+c.getImaginary());
	}
	
	public void show() {
		System.out.println(this.getReal());
		System.out.println(this.getImaginary());
        if(this.getImaginary()>0)
		System.out.println(this.getReal()+" + i"+this.getImaginary());
         if(this.getImaginary()<0) {
          this.setImaginary(0-this.getImaginary());
    	  System.out.println(this.getReal()+" - i"+this.getImaginary());
        }

	}
	
	public static void main(String[] args) {
		ComplexNumbers c1= new ComplexNumbers(4, 5);
		ComplexNumbers c2= new ComplexNumbers(1, 2);
		//c1.add(c2);
		
		//c1.show();
		c1.multiply(c2);
		c1.show();
		
        
	}
	 public void multiply(ComplexNumbers c2) {
	       int real= this.getReal()*c2.getReal()-this.getImaginary()*c2.getImaginary();
	       int imaginary=this.getReal()*c2.getImaginary()+this.getImaginary()*c2.getReal();
	       this.setReal(real);
	        this.setImaginary(imaginary);
		}

	
}