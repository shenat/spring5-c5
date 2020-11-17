package com.sat.data.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.sat.bean.Order;
import com.sat.bean.User;

public interface OrderRepository extends CrudRepository<Order, Long>{
	
	//根据用户查找Order并根据placedAt倒序
	//pageable是spring的一个根据页号和每页数量显示子集
	List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
