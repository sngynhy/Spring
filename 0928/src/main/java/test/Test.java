package test;

public class Test {
	int a;
	public Test() {
		System.out.println("기본생성자 호출!");
	}
	
	public void print() {
		System.out.println("안녕!");
	}
	
	public void initFunc() {
		System.out.println("멤버변수 초기화해주는 함수");
		a = 100;
	}
}
