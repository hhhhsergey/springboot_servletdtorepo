package com.example.demoboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoboot.domain.Orders;
import com.example.demoboot.dto.OrdersDTO;
import com.example.demoboot.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private OrdersRepository ordersRepository;

	public OrdersDTO findByOrderid(long orderid) {
		OrdersDTO ordersDTO=modelMapper.map(ordersRepository.findById(orderid).get(),OrdersDTO.class);
		return ordersDTO;
	}
	
	//конвертация list<Orders> в List<OrdersDTO>
	public List<OrdersDTO> listAll() {
		return ((List<Orders>) ordersRepository.findAll()).parallelStream().map(this::convertToOrdersDTO)
				.collect(Collectors.toList());
	}

	//конвертаци Orders в OrdersDTO
	private OrdersDTO convertToOrdersDTO(Orders orders) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		OrdersDTO ordersDTO = modelMapper.map(orders, OrdersDTO.class);
		return ordersDTO;
	}
	
	//имитация обработки
	public void handleOrder(OrdersDTO ordersDTO) {
		ordersDTO.setParam3(true);
		
	}
}
