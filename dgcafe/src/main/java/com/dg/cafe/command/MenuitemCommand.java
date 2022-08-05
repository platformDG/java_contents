package com.dg.cafe.command;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MenuitemCommand {
	private long mid;
	private String categoryName;
	private String subCategoryName;	
	private String menuName;
	private double menuPrice;
	private String image;
	private Date regDate;
}
