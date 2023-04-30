package javarecall;

public class Blocks {
	{
		System.out.println("outer  instance");
		{
			System.out.println("inner  instance");
		}
	}
	{System.out.println("outer 2 instance");}
static {System.out.println("static outer 1");
{}
}
	public static void main(String[] args) {
		new Blocks();
	}
}
