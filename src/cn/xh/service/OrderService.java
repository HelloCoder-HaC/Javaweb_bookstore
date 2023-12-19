package cn.xh.service;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Or;

import cn.xh.domain.Order;
import cn.xh.domain.Orderitem;
import cn.xh.domain.User;

public interface OrderService {
	/**
	 * ���ɶ���
	 * 
	 * @param o
	 */
	void genOrder(Order o);

	/**
	 * ���ݶ����Ų�ѯ����
	 * 
	 * @param ordernum
	 * @return
	 */
	Order findOrderByNum(String ordernum);

	/**
	 * ��ѯ�ͻ��Ķ���
	 * 
	 * @param user
	 * @return
	 */
	List<Order> findUserOrders(User user);

	List<Order> findOrders();

	void faHuo(String ordernum);
}
