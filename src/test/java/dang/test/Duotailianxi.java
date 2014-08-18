package dang.test;


	 class A {
		int i = 1;
		public void print() {
			System.out.println("i=" + i);
		}
		public void print(A a) {
			a.print();
			}

}

	 class B extends A{
		int i = 2;
		public void print() {
		System.out.println("i=" + i);
	}
}

	 class C extends A {
		int i = 3;

		public void print() {
			System.out.println("i=" + i);
		}
}
	public class Duotailianxi{ //多态练习
		public static void main(String[] args) {
			A a = new A();
			a.print();
			a.print(new B());
			A b = new B();
			b.print();
			
			A c =new C();
			c.print();
			
			
			
}
}
