package com.dg.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dg.cafe.command.CategoryCommand;
import com.dg.cafe.domain.Category;
import com.dg.cafe.service.CategoryServiceImpl;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	/**
	 * 카테고리 추가 화면 출력
	 * 
	 * 액션 : categoryService에서 카테고리 목록가져와서 JSP에 전달.
	 * 추후 리팩토리 예상 : 메인카테고리 클릭시 서브카테고리 나올 수 있도록 하고 싶음.  
	 */
	@GetMapping("/admin/category")
	public String categoryInputForm(Model model) {
		List<Category> list = categoryService.findAllCategory(); 
		model.addAttribute("list", list);
		model.addAttribute("category", new CategoryCommand());
		return "admin/category";
	}
	/**
	 * 카테고리 추가 화면에서 추가버튼 클릭시 POST방식으로 전달
	 * 
	 * 액션 : Command클래스를 생성해서 JSP페이지에서 값을 받아옴
	 * 		 categoryService를 통해 작성한 카테고리 추가함.
	 * 추후 리팩토리 예상 : X  
	 */
	@PostMapping("/admin/category")
	public String categoryInput(@ModelAttribute("category") CategoryCommand categoryCommand,
			Model model) {
		List<Category> list = null;
		//유효성 검증
		if(categoryCommand.getCategoryName().length() != 0) {
			categoryService.addCategory(categoryCommand); 
			list = categoryService.findAllCategory(); 
			model.addAttribute("list", list);
			model.addAttribute("category", new CategoryCommand());
			model.addAttribute("psuh", "success");
			model.addAttribute("msg", "등록을 성공하였습니다.");
		}
		else {
			list = categoryService.findAllCategory(); 
			model.addAttribute("list", list);
			model.addAttribute("psuh", "err");
			model.addAttribute("msg", "등록에 실패 하였습니다.");
		}
		return "admin/category";
	}
}
