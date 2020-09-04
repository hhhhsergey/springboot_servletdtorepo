package com.example.demoboot.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demoboot.dto.OrdersDTO;
import com.example.demoboot.service.OrdersService;

@Controller
public class ControllerApp {

	@Autowired
	private OrdersService ordersService;

	// вывод всех сущностей из базы данных
	@GetMapping("/map")
	public String listAll(Model model) {
		List<OrdersDTO> ordersDTO = ordersService.listAll();
		model.addAttribute("listOrdersDTO", ordersDTO);
		return "index";
	}

	// поиск сущности и имитация обработки (ordersService.handleOrder меняет param3
	// на true)
	@GetMapping("/map/{orderid}")
	public String findByOrderIdAndHandle(@PathVariable long orderid, Model model) throws IOException {
		OrdersDTO ordersDTO = ordersService.findByOrderid(orderid);
		ordersService.handleOrder(ordersDTO);
		model.addAttribute("ordersDTO", ordersDTO);
		return "indexid";
	}

	// обработка ошибок
	@ExceptionHandler(Exception.class)
	public String handleNotFoundResource(Exception ex, Model model) {
		model.addAttribute("message", ex.getMessage());
		return "indexerror";
	}

}
