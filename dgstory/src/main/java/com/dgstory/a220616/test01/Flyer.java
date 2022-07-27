package com.dgstory.a220616.test01;

/**
 * -. abstract메소드의 집합, 상수(public)
 * -. 인스턴스 생성 불가
 * -. 다중 상속 지원
 * @author Administrator
 *
 */
public interface Flyer {
	public void fly(); // abstract 기본으로 포함되어있음
	public void takeOff();
	public void land();

}
