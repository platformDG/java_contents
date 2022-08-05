package com.dg.cafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
	
	private Long cid;
	private String categoryName;
	private String subCategoryName;
	private Date regDate;
	public Category() {
		
	}
	public Category(long cid) {
		this.cid = cid;
	}
}
