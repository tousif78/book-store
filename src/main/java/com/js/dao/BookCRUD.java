package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Book;

public class BookCRUD {
	final static String path="com.mysql.cj.jdbc.Driver";
	final static String address="jdbc:mysql://localhost:3306/book_store?user=root&password=root";
	public int insertBook(Book b) {
		Connection c=null;
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("insert into Book values(?,?,?,?,?)");
			ps.setInt(1, b.getBook_ID());
			ps.setString(2, b.getBook_Name());
			ps.setString(3, b.getAuthor_Name());
			ps.setInt(4, b.getNumberOfPages());
			ps.setDouble(5, b.getPrice());
			return ps.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;		
	}
	public int DeleteBook(int id) {
		Connection c=null;
		 try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("delete from book where Book_ID=?");
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0; 
	}
	
	public int UpdateBook(int id,Book b) {
		Connection c=null;
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("update Book set Book_Name=?,Author_Name=? where Book_ID=?");
			ps.setString(1, b.getAuthor_Name());
			ps.setString(2, b.getBook_Name());
			ps.setInt(3, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public Book getBookById(int id) {
		Connection c=null;
		Book b = null;
		try {
			Class.forName(path);
			c =DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("select * from Book where Book_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				b= new Book();
				b.setBook_ID(rs.getInt(1));
				b.setBook_Name(rs.getString(2));
				b.setAuthor_Name(rs.getString(3));
				b.setNumberOfPages(rs.getInt(4));
				b.setPrice(rs.getDouble(5));
				return b;
			}else {
				return b;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    finally {
	    	try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		return b;
	}
	public ArrayList<Book> getAllBooks(){
		Connection c=null;
		ArrayList<Book> al=new ArrayList<Book>();
		try {
			Class.forName(path);
		    c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("Select * from Book");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Book b=new Book();
				b.setBook_ID(rs.getInt(1));
				b.setBook_Name(rs.getString(2));
				b.setAuthor_Name(rs.getString(3));
				b.setNumberOfPages(rs.getInt(4));
				b.setPrice(rs.getDouble(5));
				al.add(b);
			}
			return al;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
	    	try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean batchExecution(ArrayList<Book> Books) {
		Connection c=null;
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("insert into book values(?,?,?,?,?)");
			for(Book b:Books) {
				ps.setInt(1,b.getBook_ID());
				ps.setString(2, b.getBook_Name());
				ps.setString(3, b.getAuthor_Name());
				ps.setInt(4,b.getNumberOfPages() );
				ps.setDouble(5, b.getPrice());
				ps.addBatch();
			}
			ps.executeBatch();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
