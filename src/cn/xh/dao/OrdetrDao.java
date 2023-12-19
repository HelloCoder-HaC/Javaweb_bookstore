package cn.xh.dao;

import java.util.List;

import cn.xh.domain.Order;

public interface OrdetrDao {

	/**
	 * ���涩���Ļ�����Ϣ ��Ҫ���涩�������Ķ�������Ϣ
	 * 
	 * @param o
	 */
	void save(Order o);

	/**
	 * ���ݶ����Ų��Ҷ���
	 * 
	 * @param ordernum
	 * @return �����Ļ�����Ϣ
	 */
	Order findOrderByNum(String ordernum);

	/**
	 * ���ݿͻ���id��ѯ����������������������
	 * 
	 * @param id
	 * @return
	 */
	List<Order> findOrdersByUser(String userId);

	List<Order> findOrders();

	void faHuo(String ordernum);

}
