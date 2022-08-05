package com.dg.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.cafe.domain.Cart;
import com.dg.cafe.domain.Category;
import com.dg.cafe.domain.MenuItem;
import com.dg.cafe.domain.OrderList;
import com.dg.cafe.service.CartServiceImpl;
import com.dg.cafe.service.CategoryServiceImpl;
import com.dg.cafe.service.MenuItemServiceImpl;


@Controller
public class OrderController {
	
	@Autowired
	MenuItemServiceImpl menuItemService;
	
	@Autowired
	CategoryServiceImpl categoryService;

	@Autowired
	CartServiceImpl cartService;
	
	/**
	 * 메소드 기능 : 주문화면 출력
	 * 
	 * 학습
	 * 	-. @PathVariable을 처음 사용 해봄.
	 * 
	 * 액션 
	 * 	-. 카테고리 목록, 메뉴목록, 카트 목록을 가져와서 JSP에 전달
	 *	-. 메뉴 선택 후 카테고리를 이동할 수 있기 때문에 카트목록로 전달한다.
	 * 
	 * 추후 리팩토리 예상
	 * 	-. 메인카테고리/ 서브카테고리 구분지어서 메뉴을 출력하는것도 해볼 수 있을듯.
	 */
	@GetMapping("/order/orderlist/{category}")
	public String orderPage(Model model, @PathVariable String category) {
		List<Category> clist = categoryService.findAllCategory();
		List<MenuItem> mlist = null;
		Cart cart = cartService.getCart();
		
		if (category.equals("all")) {
			mlist = menuItemService.FindAllMenuItem();
		}
		else {
			mlist = menuItemService.FindMenuItemByCid(Long.valueOf(category));
		}
		model.addAttribute("menuitem", mlist);
		model.addAttribute("category", clist);
		model.addAttribute("cart", cart.getLineItemList());
		model.addAttribute("cartprice", cartService.getCart().getTotalPrice());
		return "order/orderlist";
	}
	
	/**
	 * 메소드 기능 : 주문화면에서 메뉴 선택시 메뉴아이템 키값을 전달 받아서 LineItem 생성 후 화면에 출력
	 * 
	 * 액션 
	 * 	-. JSP에서 a태그에서 POST 방식으로 전달하기 위해서 javascript를 활용했음.
	 *	-. 메뉴아이템 키값 mid를 화면으로부터 전달 받아서 LineItem을 추가함.
	 * 
	 * 추후 리팩토리 예상
	 * 	-. 리다이렉트를 활용해보는것도 괜찮을 듯.
	 * 	-. GET방식으로 해서 URL을 좀더 다르게 해서 값을 전달해도 괜찮았을 듯.
	 */
	@PostMapping("/order/orderlist/{category}")
	public String order(Model model, @PathVariable String category, @RequestParam long mid) {
		MenuItem menuItem = menuItemService.getMenuItemByMid(mid);
		cartService.addLineItem(menuItem, 1);
		Cart cart = cartService.getCart();

		List<Category> clist = categoryService.findAllCategory();
		List<MenuItem> mlist = null;
		if (category.equals("all")) {
			mlist = menuItemService.FindAllMenuItem();
		}
		else {
			mlist = menuItemService.FindMenuItemByCid(Long.valueOf(category));
		}
		model.addAttribute("menuitem", mlist);
		model.addAttribute("category", clist);
		model.addAttribute("cart", cart.getLineItemList());
		model.addAttribute("cartprice", cartService.getCart().getTotalPrice());
		return "order/orderlist";
	}
	
	/**
	 * 메소드 기능 : 주문화면서 메뉴 선택시 LineItem에 생성 되는거 그거 삭제버튼 클릭 했을때의 처리
	 * 
	 * 학습
	 * 	-. URL에 구분자를 넣어서 처리 해봄 
	 * 	-. @PathVariable을 두개 사용 해봄
	 * 	-. redirect 활용 해봄 : 기본페이지로 다시 보내기 때문에 기존페이지에서 사용한 Model을 그대로 사용 가능 한 듯. 
	 * 
	 * 액션 
	 * 	-. 화면으로 부터 메뉴아이템명을 전달 받아서 LineItem에 메뉴아이템명과 같은 것을 삭제처리함.
	 */
	@GetMapping("/order/orderlist/{category}/delete/{param}")
	public String deleteChange(Model model, @PathVariable String category, @PathVariable String param) {
		cartService.deleteLineItem(param);
		Cart cart = cartService.getCart();

		List<Category> clist = categoryService.findAllCategory();
		List<MenuItem> mlist = null;
		if (category.equals("all")) {
			mlist = menuItemService.FindAllMenuItem();
		}
		else {
			mlist = menuItemService.FindMenuItemByCid(Long.valueOf(category));
		}
		model.addAttribute("menuitem", mlist);
		model.addAttribute("category", clist);
		model.addAttribute("cart", cart.getLineItemList());
		model.addAttribute("cartprice", cartService.getCart().getTotalPrice());
		return "redirect:/order/orderlist/"+category;
	}
	
	/**
	 * 메소드 기능 : 계산완료 했을때 처리 해주는 기능
	 * 
	 * 학습
	 * 	-.RedirectAttributes을 사용 해봄 : Return 했을때 새로음 model값을 넣고 싶을때 사용한다. model과 사용법이 흡사함.
	 * 
	 * 액션 
	 * 	-. 주문목록을 DB에 저장 후 주문리스트를 가지고 온 후, 기존 Cart는 초기화 한다.
	 */
	@GetMapping("/order/orderlist/{category}/success")
	public String successChange(Model model, @PathVariable String category, RedirectAttributes red) {
		cartService.addOrderList();
		cartService.getCart().deleteCart();
		OrderList orderList = cartService.getOrderList();
		List<Category> clist = categoryService.findAllCategory();
		List<MenuItem> mlist = null;
		if (category.equals("all")) {
			mlist = menuItemService.FindAllMenuItem();
		}
		else {
			mlist = menuItemService.FindMenuItemByCid(Long.valueOf(category));
		}
		red.addFlashAttribute("menuitem", mlist);
		red.addFlashAttribute("category", clist);
		red.addFlashAttribute("orderList", orderList);
		red.addFlashAttribute("cartprice", 0);
		return "redirect:/order/orderlist/"+category;
	}
	
	/**
	 * 메소드 기능 : 주문 도중 취소버튼 클릭했을 때 주문목록 화면을 초기화 시켜준다.
	 * 
	 * 학습
	 * 	-.RedirectAttributes을 사용 해봄 : Return 했을때 새로음 model값을 넣고 싶을때 사용한다. model과 사용법이 흡사함.
	 * 
	 * 액션 
	 * 	-. Cart에 접근하여서 기존에 들어간 내용을 초기화 작업을 하고 총금액을 0원으로 초기화 시켜준다.
	 */
	@GetMapping("/order/orderlist/{category}/cancel")
	public String cancel(Model model, @PathVariable String category, RedirectAttributes red) {
		Cart cart = cartService.getCart();
		cart.deleteCart();
		
		List<Category> clist = categoryService.findAllCategory();
		List<MenuItem> mlist = null;
		if (category.equals("all")) {
			mlist = menuItemService.FindAllMenuItem();
		}
		else {
			mlist = menuItemService.FindMenuItemByCid(Long.valueOf(category));
		}
		model.addAttribute("menuitem", mlist);
		model.addAttribute("category", clist);
		red.addFlashAttribute("cartprice", 0);
		return "redirect:/order/orderlist/"+category;
	}
	
	@GetMapping("/order/orderlist/{category}/{btn}/{param}")
	public String amountChange(Model model, @PathVariable String category,  
						@PathVariable String btn, @PathVariable String param, RedirectAttributes red) {
		cartService.changeAmount(param, btn);
		Cart cart = cartService.getCart();
		List<Category> clist = categoryService.findAllCategory();
		List<MenuItem> mlist = null;
		if (category.equals("all")) {
			mlist = menuItemService.FindAllMenuItem();
		}
		else {
			mlist = menuItemService.FindMenuItemByCid(Long.valueOf(category));
		}
		model.addAttribute("menuitem", mlist);
		model.addAttribute("category", clist);
		red.addFlashAttribute("cart", cart.getLineItemList());
		red.addFlashAttribute("cartprice", cartService.getCart().getTotalPrice());
		return "redirect:/order/orderlist/"+category;
	}
}
