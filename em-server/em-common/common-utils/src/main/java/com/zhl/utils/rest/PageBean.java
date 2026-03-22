package com.zhl.utils.rest;

import lombok.AllArgsConstructor;
import java.util.List;
import java.lang.Long;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageBean<T> {

	private int current;

	private int size;

	private Long total;

	private List<T> records;

}