
package cn.xh.domain;

import java.io.Serializable;

/**
 * 图书实体类
 */
public class Book implements Serializable {
	private String book_id; // 图书ID



	private String book_name; // 图书名称
	private String book_author; // 图书作者
	private String book_press; // 出版社
	private Category category; // 图书类别
	private String filename; // 图片文件名
	private String path; // 路径
	private String book_desc; // 描述
	private double book_price; // 图书价格
	private int book_kunumber; // 库存数量
	private int book_xiaonumber; // 销售数量

	/**
	 * 默认构造函数
	 */
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_press() {
		return book_press;
	}

	public void setBook_press(String book_press) {
		this.book_press = book_press;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getBook_desc() {
		return book_desc;
	}

	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}

	public double getBook_price() {
		return book_price;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}

	public int getBook_kunumber() {
		return book_kunumber;
	}

	public void setBook_kunumber(int book_kunumber) {
		this.book_kunumber = book_kunumber;
	}

	public int getBook_xiaonumber() {
		return book_xiaonumber;
	}

	public void setBook_xiaonumber(int book_xiaonumber) {
		this.book_xiaonumber = book_xiaonumber;
	}

	/**
	 * 全参数构造函数
	 *
	 * @param book_id       图书ID
	 * @param book_name     图书名称
	 * @param book_author   图书作者
	 * @param book_press    出版社
	 * @param category      图书类别
	 * @param filename      图片文件名
	 * @param path          路径
	 * @param book_desc     描述
	 * @param book_price    图书价格
	 * @param book_kunumber 库存数量
	 * @param book_xiaonumber 销售数量
	 */
	public Book(String book_id, String book_name, String book_author, String book_press, Category category,
				String filename, String path, String book_desc, double book_price, int book_kunumber, int book_xiaonumber) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_press = book_press;
		this.category = category;
		this.filename = filename;
		this.path = path;
		this.book_desc = book_desc;
		this.book_price = book_price;
		this.book_kunumber = book_kunumber;
		this.book_xiaonumber = book_xiaonumber;
	}

	// Getters and Setters 方法
	// ...

	/**
	 * 重写toString方法
	 *
	 * @return 图书对象的字符串表示
	 */
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author
				+ ", book_press=" + book_press + ", category=" + category + ", filename=" + filename + ", path=" + path
				+ ", book_desc=" + book_desc + ", book_price=" + book_price + ", book_kunumber=" + book_kunumber
				+ ", book_xiaonumber=" + book_xiaonumber + "]";
	}

}