package com.dg.cafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderList {
	private long oid;
	private String orderName;
	private double orderPrice;
	private Date regDate;
}
