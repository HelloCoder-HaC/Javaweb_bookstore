package cn.xh.web.formbean;

import java.io.Serializable;

import cn.xh.domain.Book;

//������
public class CartItem implements Serializable {
	private Book book;
	private int quantity;// ��������
	private float money;// ����С��

	public CartItem(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMoney() {
		return book.getBook_price() * quantity;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Book getBook() {
		return book;
	}

}
