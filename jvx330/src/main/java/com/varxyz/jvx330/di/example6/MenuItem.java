package com.varxyz.jvx330.di.example6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor

public class MenuItem {
	private String menuName;
	private int menuPrice;
	
	public MenuItem() {
		
	}
	
	public String toString() {
		String str;
		if(menuName.length() == 4) {
			str = "\n┌───────────────────────┐"
				+ "\n│메뉴이름 : " + menuName +"\t\t│"
				+ "\n│메뉴가격 : " + menuPrice+"\t\t│"
				+"\n└───────────────────────┘";
		}
		else{
			str = "\n┌───────────────────────┐"
				+ "\n│메뉴이름 : " + menuName +"\t│"
				+ "\n│메뉴가격 : " + menuPrice+"\t\t│"
				+"\n└───────────────────────┘";
			
		}
		return  str;
	}
}
