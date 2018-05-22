package com.mitrais.bootcamp.java.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitrais.bootcamp.java.beans.Product;
import com.mitrais.bootcamp.java.dao.ApplicationDao;

public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchStr = req.getParameter("search");
		ApplicationDao dao = new ApplicationDao();
		List<Product> products = dao.searchProducts(searchStr);
	}
		
}
