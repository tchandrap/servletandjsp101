package com.mitrais.bootcamp.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mitrais.bootcamp.java.beans.*;
import com.mitrais.bootcamp.java.utils.DBType;
import com.mysql.cj.exceptions.StatementIsClosedException;

public class ApplicationDao {
	List<Product> products = new ArrayList<>();
	
	public List<Product> searchProducts(String searchString){
		String sql = "select * from products where product_name like '%"+searchString+"%'";
		
		try (Connection con = DBConnection.getConnectionDatabase(DBType.MYSQL);
			 Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(sql)
			){
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductImgPath(rs.getString("image_path"));
				product.setProductName(rs.getString("product_name"));
				products.add(product);
			}
			
		} catch (SQLException e) {
			DBConnection.processException(e);
		}
		
		return products;
	}
	
}
