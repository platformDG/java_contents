package com.dg.cafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {
	private long mid;
	private Category category;
	private String menuName;
	private double menuPrice;
	private String imageURL;
	private String imageName;
	private Date regDate;
}
