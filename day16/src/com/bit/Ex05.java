package com.bit;

public class Ex05 {
	// Thread클래스의 객체를 그냥쓰면 default run()이 실행되어
	// 원하는 작업하려면 run() 오버라이딩 해야함

	// ---쓰레드 생성법(run() 오버라이딩 방법) 크게4개 ---
	// 1.Thread클래스 상속해 run() 오버라이딩
	// 2.Runnable인터페이스 상속해 run() 오버라이딩 - 상속소모없음
	// 3.스레드객체 러너블을 상속하는
	// 4.그냥 스레드객체 생성해서 run만 내가원하는 대로

	// run을 새로운 스레드의 main메서드로 보면됨
	// main에 일시키고 싳은건
	// 콘솔은 쓰레드의 장점을 느끼기 힘듬 - 입출력이 1구멍이라 왔다갔다해도 결국 하나로
	// UI의 경우 입출력이 여러 곳에서 이루어져 쓰게됨
	public static void main(String[] args) {

		Thread thr = new Thread() {
			public void run() {
				Thread thr = Thread.currentThread();
				String name = thr.getName();
				System.out.println(name + " start...");
				System.out.println(name + " end...");
			}
		};

		// IO의 기본은 1바이트 스트림, 자바의 문자열 스트림은 편하라고 제공하는 기능
		// 모든 언어가 지원하지 않음 바이트 스트림을 이해하자

		// 쓰레드의 제어권
	}
}
