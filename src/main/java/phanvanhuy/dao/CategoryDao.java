package phanvanhuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phanvanhuy.entity.Category;

public class CategoryDao {
	public static List<Category> queryCategory(Connection conn) throws SQLException {
        String sql = "Select *  from Category a ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Category> list = new ArrayList<Category>();
        while (rs.next()) {
            String CategoryId = rs.getString("CategoryId");
            String CategoryName = rs.getString("CategoryName");
            Category Category = new Category();
            Category.setCategoryId(CategoryName);
            Category.setCategoryName(CategoryName);
            list.add(Category);
        }
        return list;
    }

    // Tìm kiếm theo mã sản phẩm (code)
    public static Category findCategory(Connection conn, String code) throws SQLException {
        String sql = "Select *  from Category a where a.CategoryId=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            int CategoryId = rs.getInt("CategoryId");
            String CategoryName = rs.getString("CategoryName");         
            Category category = new Category(CategoryId, CategoryName);
            return category;
        }
        return null;
    }
    // Tìm kiếm theo mã sản phẩm (name)
    public static  List<Category> findCategoryByName(Connection conn, String name) throws SQLException {
        String sql = "Select *  from Category a where a.CategoryName like  '%" + name + "%'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        ResultSet rs = pstm.executeQuery();
        List<Category> list = new ArrayList<Category>();
        while (rs.next()) {
            int CategoryId = rs.getInt("CategoryId");
            String CategoryName = rs.getString("CategoryName");   
            Category category = new Category(CategoryId, CategoryName);
            list.add(category);
            return list;
        }
        return null;
    }
    // Thêm mới sản phẩm
    public static void insertCategory(Connection conn, Category Category) throws SQLException {
        String sql = "Insert into Category(CategoryId, CategoryName) values (?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, Category.getCategoryId());
        pstm.setString(2, Category.getCategoryName()); 
        pstm.executeUpdate();
    }
}
