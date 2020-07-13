package Product_Mgmt.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductSellDAO {
	private DataSource ds;

	public ProductSellDAO() {
		try {
			Context context = new InitialContext();  //������ �ҽ� �ʱ�ȭ
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");// jdbc/MySQL ���ҽ� �̸�
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�����ִ� �Լ�
	public ArrayList<ProductSellDTO> displayProductSell() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sogongdo.product_sell;";
		ArrayList<ProductSellDTO> productSells = new ArrayList<ProductSellDTO>();
		
		try {
			conn = ds.getConnection(); //������ �ҽ��� ����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {//���� ���� �ؼ� ���� �ѱ��.
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String sell_ID = rs.getString("Sell_ID");
				String product_ID =rs.getString("Product_ID");
				int quantity = rs.getInt("Quantity");
				int price = rs.getInt("Price");
				LocalDateTime sell_Date = rs.getTimestamp("Sell_Date").toLocalDateTime();
				String seller = rs.getString("Seller");

				ProductSellDTO psDTO = new ProductSellDTO(sell_ID, product_ID, quantity,price,sell_Date,seller);
				productSells.add(psDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (conn != null) conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return productSells;
	}
	
}

/*
��� ������ : �ڼ���
������ : �ڼ���, ����ȯ
���� ��¥: 2020-06-05
*/