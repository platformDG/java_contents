package com.dg.cafe.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.dg.cafe.domain.Category;
import com.dg.cafe.domain.MenuItem;
import com.dg.cafe.service.CategoryServiceImpl;
import com.dg.cafe.service.MenuItemServiceImpl;


@Controller
public class MenuItemController {
	
	@Autowired
	MenuItemServiceImpl menuItemService;
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	/**
	 * 메뉴아이템 추가 화면 출력
	 * 
	 * 액션 : menuItemService에서 등록된 메뉴목록 가져와서 JSP에 전달. 
	 * 		categoryService에서 카테고리 목록가져와서 JSP에 전달.
	 * 추후 리팩토리 예상 : 메인카테고리 클릭시 서브카테고리 나올 수 있도록 하고 싶음.  
	 */
	@GetMapping("/admin/menuitem")
	public String menuItemInputForm(Model model) throws SQLException, UnsupportedEncodingException {
		List<MenuItem> mlist = menuItemService.FindAllMenuItem();
		List<Category> clist = categoryService.findAllCategory();
		model.addAttribute("menuitem", mlist);
		model.addAttribute("category", clist);
		return "admin/menuitem";
	}
	
	/**
	 * 메뉴아이템 추가 화면에서 추가버튼 클릭시 POST방식으로 전달
	 * 
	 * 액션 : menuItemService에서 등록된 메뉴목록 가져와서 JSP에 전달. 
	 * 		categoryService에서 카테고리 목록가져와서 JSP에 전달.
	 * 
	 * 문제점 : 파일처리 때문에 JSP에서 "multipart/form-data"로 전달하는데 Command 클래스, 
	 *        @RequestParam이 적용이 되지 않음. 따라서 서블릿의 기초 방식으로  HttpServletRequest 처리했음.
	 *        CommonsMultipartResolver 빈 등록을 해서 처리할 수있다는데. 어디에 빈등록을 해줘야 하는지 모르겠음.
	 * 추후 리팩토리 예상 : 추후에 Bean 등록해서 처리 해봐야 겠음.
	 */
	@PostMapping("/admin/menuitem")
	public String menuItemInput(HttpServletRequest request, Model model, 
									@RequestPart("file") MultipartFile file) {	
		String categoryName = request.getParameter("categoryName");
		String subCategoryName = request.getParameter("subCategoryName");
		String menuItemName = request.getParameter("menuItem");
		String price = request.getParameter("menuPrice");
		double menuPrice;
		
		List<MenuItem> mlist = null;
		List<Category> clist = null;
		
		boolean chk = false;
		
		if (!isValid(categoryName, subCategoryName, menuItemName, price)) {
			mlist = menuItemService.FindAllMenuItem();
			clist = categoryService.findAllCategory();
			model.addAttribute("menuitem", mlist);
			model.addAttribute("category", clist);
			model.addAttribute("psuh", "err");
			model.addAttribute("msg", "등록에 실패 하였습니다.");
			return "admin/menuitem";
		}
		else {
			menuPrice = Double.valueOf(request.getParameter("menuPrice"));
		}
		
		chk = menuItemService.addMenuItem(categoryName, subCategoryName, 
												menuItemName, menuPrice , file);
		if (chk == true) {
			mlist = menuItemService.FindAllMenuItem();
			clist = categoryService.findAllCategory();
			model.addAttribute("menuitem", mlist);
			model.addAttribute("category", clist);
			model.addAttribute("psuh", "success");
			model.addAttribute("msg", "등록을 성공하였습니다.");
		}
		else {
			mlist = menuItemService.FindAllMenuItem();
			clist = categoryService.findAllCategory();
			model.addAttribute("menuitem", mlist);
			model.addAttribute("category", clist);
			model.addAttribute("psuh", "err");
			model.addAttribute("msg", "등록에 실패 하였습니다.");
		}
		return "admin/menuitem";
	}
	public boolean isValid(String cName, String scName, String mItem, String menuPrice){
		if(cName == null || cName.length() == 0) {
			return false;
		}
		if(scName == null || scName.length() == 0) {
			return false;
		}
		if(mItem == null || mItem.length() == 0) {
			return false;
		}
		if(menuPrice == null || menuPrice.length() == 0) {
			return false;
		}
		return true;
	}
	
//	@Bean
//	   public CommonsMultipartResolver multipartResolver() {
//	      CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//	      resolver.setDefaultEncoding("utf-8");
//	      return resolver;
//	   }
	
}
