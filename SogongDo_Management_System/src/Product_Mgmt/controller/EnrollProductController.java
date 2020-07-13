package Product_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Product_Mgmt.persistance.ProductDTO;
import Product_Mgmt.persistance.ProductDAO;

@WebServlet("/Product/enroll")
public class EnrollProductController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollProduct(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollProduct(req, resp);
	}

	private void requestEnrollProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		ProductDTO products = new ProductDTO();
		products.setProduct_Name(req.getParameter("Product_Name"));
		products.setProduct_Kinds(req.getParameter("Product_Kinds"));
		products.setProduct_Price(Integer.parseInt(req.getParameter("Product_Price")));
		products.setProduct_Stock(Integer.parseInt(req.getParameter("Product_Stock")));
		     
        ProductDAO productDAO = new ProductDAO();
        String checkEnroll = Integer.toString(productDAO.enrollProduct(products));
        req.setAttribute("checkEnroll", checkEnroll); //jsp �������� �� �ѱ��
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Product_Mgmt/EnrollProductView.jsp");
        dispatcher.forward(req, resp);

	}
}

/*
��� ������ : �ڼ���
������ : �ڼ���, ����ȯ
���� ��¥: 2020-06-05
���� ���� : 2020-06-08
���� ���� : productDAO.enrollProduct(products) �� ��ȯ�� ����, req.setAttribute("checkEnroll", checkEnroll);
*/