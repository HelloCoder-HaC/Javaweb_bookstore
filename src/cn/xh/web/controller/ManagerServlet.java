package cn.xh.web.controller;

import cn.xh.domain.Administrator;
import cn.xh.domain.Book;
import cn.xh.domain.Category;
import cn.xh.domain.User;
import cn.xh.service.ManagerService;
import cn.xh.service.impl.ManagerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/admin/ManagerServlet")
public class ManagerServlet extends HttpServlet {
    private ManagerService service = new ManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String op = req.getParameter("op");// �õ�������������
        // ����Ա��½
        if (op.equals("login")) {
            login(req, resp);
        }
        // �޸Ĺ���Ա����
        if (op.equals("managerInformation")) {
            managerInformation(req, resp);
        }
        // �޸Ĺ���Ա��¼����
        if (op.equals("managerPassword")) {
            managerPassword(req, resp);
        }
        // ע��
        if (op.equals("layout")) {
            layout(req, resp);
        }
        // ����鼮ǰ�Ȼ�ȡ���з���
        if (op.equals("addBookUI")) {
            addBookUI(req, resp);
        }
        // ����鼮
        if (op.equals("addBook")) {
            try {
                addBook(req, resp);
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // ����鼮����
        if (op.equals("addCategory")) {
            addCategory(req, resp);
        }
        // ��ѧ�������鼮�б�
        if (op.equals("category")) {
            getCategoryBook(req, resp);
        }
        // �༭�鼮��Ϣǰ��ȡ�鼮����Ϣ����
        if (op.equals("editBookUI")) {
            editBookUI(req, resp);
        }
        // �༭�鼮
        if (op.equals("editBook")) {
            try {
                editBook(req, resp);
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // ɾ���鼮
        if (op.equals("delBook")) {
            delBook(req, resp);
        }
        // ��ȡ�鼮�����б�
        if (op.equals("categoryList")) {
            categoryList(req, resp);
        }
        // ��÷�����Ϣ
        if (op.equals("editCategoryUI")) {
            editCategoryUI(req, resp);
        }
        // �޸��鼮������Ϣ
        if (op.equals("editCategory")) {
            editCategory(req, resp);
        }
        // ɾ���鼮����
        if (op.equals("delCategory")) {
            delCategory(req, resp);
        }
        // �û���Ϣ����
        if (op.equals("findUsers")) {
            findUsers(req, resp);
        }
        // ��ӹ�����Ա
        if (op.equals("addAdmin")) {
            addAdmin(req, resp);
        }
        // �鼮�������
        if (op.equals("sales")) {
            sales(req, resp);
        }
    }

    private void sales(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> sales = service.sales();
        req.setAttribute("sales", sales);
        req.getRequestDispatcher("/admin/sales.jsp").forward(req, resp);
    }

    private void addAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        Administrator admin = new Administrator(username, password, name, sex, tel);
        service.addAdmin(admin);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>�޸ĳɹ���</div>");
    }

    private void findUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = service.findUsers();
        HttpSession session = req.getSession();
        session.setAttribute("users", list);
        req.getRequestDispatcher("/admin/managerUsers.jsp").forward(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        Administrator admin = service.login(username, password);
        if (admin.getUsername() != null && admin.getUsername() != "") {
            req.setAttribute("message", "��½�ɹ�");
            session.setAttribute("admin", admin);
            req.getRequestDispatcher("/admin/message.jsp").forward(req, resp);
        } else {
            resp.getWriter()
                    .write("�޴��û�������ϵ����Ա����      <a href='/client/ClientServlet?op=category'>������ҳ</a>");
        }

    }

    private void managerInformation(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        service.managerInformation(username, name, sex, tel);
        HttpSession session = req.getSession();
        Administrator admin = (Administrator) session.getAttribute("admin");
        admin.setName(name);
        admin.setSex(sex);
        admin.setTel(tel);
        session.setAttribute("admin", admin);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>�޸ĳɹ���</div>");

    }

    private void managerPassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");

        service.managerPassword(username, password);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>�޸ĳɹ���</div>");
    }

    private void layout(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            session.removeAttribute("admin");
            resp.sendRedirect("/client/ClientServlet?op=category");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addBookUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categorys = service.findAllCategory();
        req.setAttribute("cs", categorys);
        req.getRequestDispatcher("/admin/addBook.jsp").forward(req, resp);

    }

    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws FileUploadException, IOException {
        // �жϱ��ǲ���multipart/form-data����
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            throw new RuntimeException("���ϴ��������󣡣�");
        }
        // ������������ ������������
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �������������
        ServletFileUpload sfu = new ServletFileUpload(factory);
        List<FileItem> items = new ArrayList<FileItem>();
        items = sfu.parseRequest(req);
        Book book = new Book();
        for (FileItem item : items) {
            if (item.isFormField()) {
                // ��ͨ�ֶΣ������ݷ�װ��book������
                processFormField(item, req, book);
            } else {
                // �ϴ��ֶΣ��ϴ�
                processUplodFiled(item, req, book);
            }
        }
        // ���鼮��Ϣ���浽���ݿ���
        service.addBook(book);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>��ӳɹ���</div>");
    }

    // �����ļ��ϴ�
    private void processUplodFiled(FileItem item, HttpServletRequest req, Book book) {
        try {
            // ���·������Ҫ����web-inf��
            // 01.��ȡ����ļ�����ʵĿ¼
            String dirImages = getServletContext().getRealPath("/images");
//            String dirImages = getServletContext().getRealPath("/img");
            // 02. ͨ��io���ļ�
            // 03. �����ļ��� ���û��ϴ�ͼƬ�� ͼƬ�������ظ���
            String FieldName = item.getFieldName();// ������nameֵ
            String name = item.getName();
            String fileType = name.substring(name.lastIndexOf(".") + 1);
            String fileName = UUID.randomUUID().toString();// �����ò��ظ����ļ���
            // �����ļ�����
			Date time = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strTime = simpleDateFormat.format(time);
            // path����filename
            String path = strTime +File.separator + "books";// ��ŵ�book�����е�·��
//            String path = "books";// ��ŵ�book������
            String filename = fileName + "." + fileType;
            // fileDir��ͼƬ���մ�����fileDir
            File fileDir = new File(dirImages, path + File.separator + filename);
            // InputStream inputStream = item.getInputStream(); ������ ������ ͨ�����ķ�ʽ
            // �� �ϴ����ļ����ص� �ڴ��� ���������
            File parentDir = new File(dirImages, path);// ��Ŀ¼
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            book.setFilename(filename);
            book.setPath(path);

            InputStream inputStream = item.getInputStream();
            FileOutputStream fos = new FileOutputStream(fileDir);
            int len = 0;
            while ((len = inputStream.read()) != -1) {
                fos.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // ��Fielditem�е����ݷ�װ��book��
    private void processFormField(FileItem item, HttpServletRequest req, Book book) {
        try {
            // itemÿһ��item�������һ�������
            // 01. ��ȡinput������ name ��ֵ ���ݹ淶 ����� ��name��ȡֵ�� �� javabean �е� ������һ��
            String inputName = item.getFieldName();
            String inputValue = item.getString("UTF-8");
            if (inputName.equals("categoryid")) {// ���൥������
                // ��ȡ��ѡ��ķ����id���������idȡ���������Ϣ
                String categoryid = item.getString();
                System.out.println("categoryid=" + categoryid);
                Category category = service.findCategoryById(categoryid);
                System.out.println(category);
                book.setCategory(category);
            } else {
                BeanUtils.setProperty(book, inputName, inputValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ����鼮����
    private void addCategory(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Category category = new Category();
            BeanUtils.populate(category, req.getParameterMap());
            service.addCategory(category);// ������ӷ���
            resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                    + "/img/duigou.png'/>��ӳɹ���</div>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getCategoryBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = service.getCategoryBook(req.getParameter("cid"));// ��ѧ�������鼮
        List<Category> categoryList = service.findAllCategory();// ����
        req.setAttribute("books", books);
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/admin/booksList.jsp").forward(req, resp);
    }

    private void editBookUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String book_id = req.getParameter("book_id");
        Book book = findBookById(book_id);
        List<Category> category = service.findAllCategory();
        HashMap map = new HashMap();
        map.put("book", book);
        map.put("category", category);
        req.setAttribute("map", map);
        req.getRequestDispatcher("/admin/editBook.jsp").forward(req, resp);
    }

    private void editBook(HttpServletRequest req, HttpServletResponse resp) throws FileUploadException, IOException {
        String book_id = req.getParameter("book_id");
        String book_name = req.getParameter("book_name");
        String book_author = req.getParameter("book_author");
        String book_press = req.getParameter("book_press");
        String book_desc = req.getParameter("book_desc");
        double book_price = Double.parseDouble(req.getParameter("book_price"));
        String book_kunumber = req.getParameter("book_kunumber");
        service.editBook(book_id, book_name, book_author, book_press, book_desc, book_price, book_kunumber);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>�޸ĳɹ���</div>");
    }

    private void delBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String book_id = req.getParameter("book_id");
        service.delBook(book_id);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>ɾ���ɹ���</div>");
    }

    private void categoryList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = service.findAllCategory();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/admin/categorysList.jsp").forward(req, resp);
    }

    private void editCategoryUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = service.findCategoryById(req.getParameter("category_id"));
        req.setAttribute("category", category);
        req.getRequestDispatcher("/admin/editCategory.jsp").forward(req, resp);
    }

    private void editCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Category category = new Category(req.getParameter("category_id"), req.getParameter("category_name"),
                req.getParameter("category_desc"));
        service.editCategory(category);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>�޸ĳɹ���</div>");
    }

    private void delCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String category_id = req.getParameter("category_id");
        service.delCategory(category_id);
        resp.getWriter().write("<div style='text-align: center;margin-top: 260px'><img src='" + req.getContextPath()
                + "/img/duigou.png'/>ɾ���ɹ���</div>");
    }

    // ͨ���鼮id�ҵ��鼮��Ϣ
    private Book findBookById(String book_id) {
        return service.findBookById(book_id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
