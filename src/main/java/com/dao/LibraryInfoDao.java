package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.Address;
import com.dto.BookRegDto;
import com.dto.BookTnxDto;
import com.dto.MmbrRegDto;

public class LibraryInfoDao {

	public static boolean insertMember(MmbrRegDto mmbrRegDto) {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		boolean status = false;
		String sql = "insert into Member values(?,?,?,?,?,?,?,?,?)";
		try {
			Address add = mmbrRegDto.getAddress();

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mmbrRegDto.getMemberID());
			pst.setString(2, mmbrRegDto.getMemberName());
			pst.setString(3, add.getStreetNo());
			pst.setString(4, add.getStreetName());
			pst.setString(5, add.getCity());
			pst.setString(6, add.getDistrict());
			pst.setLong(7, add.getPincode());
			pst.setString(8, Address.COUNTRY);
			pst.setString(9, mmbrRegDto.getMemberType());
			result = pst.executeUpdate();
			if (result > 0) {
				status = true;
				System.out.println(result + " row inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	public static MmbrRegDto loginMember(MmbrRegDto mmbrRegDto) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select * from Member where memberId=? and membertype=?";
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mmbrRegDto.getMemberID());
			String memberType = mmbrRegDto.getMemberType();
			pst.setString(2, memberType);
			rs = pst.executeQuery();

			if (memberType.equalsIgnoreCase("Admin")) {

				System.out.println("Invalid member,member is not admin");
			}
			while (rs.next()) {
				Address add = new Address();
				mmbrRegDto = new MmbrRegDto();
				mmbrRegDto.setMemberID(rs.getInt("memberId"));
				mmbrRegDto.setMemberName(rs.getString("memberName"));
				mmbrRegDto.setMemberType(rs.getString("membertype"));
				add.setStreetNo(rs.getString("streetNo"));
				add.setStreetName(rs.getString("streetName"));
				add.setCity(rs.getString("city"));
				add.setDistrict(rs.getString("district"));
				add.setPincode(rs.getLong("pincode"));
				mmbrRegDto.setAddress(add);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return mmbrRegDto;
	}

	public static boolean insertBook(BookRegDto bookRegDto) {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		boolean status = false;
		String sql = "insert into Book values(?,?,?,?,?,?,?)";
		try {

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, bookRegDto.getBookId());
			pst.setInt(2, bookRegDto.getBookGroupId());
			pst.setString(3, bookRegDto.getBookName());
			pst.setString(4, bookRegDto.getiSBNNo());
			pst.setString(5, bookRegDto.getAuthor());
			pst.setString(6, bookRegDto.getCategory());
			pst.setString(7, bookRegDto.getStatus());
			result = pst.executeUpdate();
			if (result > 0) {
				status = true;
				System.out.println(result + " row inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	public static List<MmbrRegDto> viewMember() {
		List<MmbrRegDto> memberList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		// boolean status=false;
		String sql = "select * from Member";
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				MmbrRegDto mmbrRegDto = new MmbrRegDto();
				Address add = new Address();
				mmbrRegDto.setMemberID(rs.getInt("memberId"));
				mmbrRegDto.setMemberName(rs.getString("memberName"));
				mmbrRegDto.setMemberType(rs.getString("membertype"));
				add.setStreetNo(rs.getString("streetNo"));
				add.setStreetName(rs.getString("streetName"));
				add.setCity(rs.getString("city"));
				add.setDistrict(rs.getString("district"));
				add.setPincode(rs.getLong("pincode"));
				mmbrRegDto.setAddress(add);
				memberList.add(mmbrRegDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return memberList;
	}

	public static List<BookRegDto> viewBookDetails() {
		List<BookRegDto> bookList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		// boolean status=false;
		String sql = "select * from Book";
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				BookRegDto bookRegDto = new BookRegDto();
				bookRegDto.setBookId(rs.getString("BookId"));
				bookRegDto.setBookGroupId(rs.getInt("BookGroupId"));
				bookRegDto.setBookName(rs.getString("BookName"));
				bookRegDto.setiSBNNo(rs.getString("ISBNNo"));
				bookRegDto.setAuthor(rs.getString("author"));
				bookRegDto.setCategory(rs.getString("category"));
				bookRegDto.setStatus(rs.getString("status"));
				bookList.add(bookRegDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return bookList;
	}

	public static List<BookTnxDto> viewBookTnx() {
		List<BookTnxDto> bookTnxList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		// boolean status=false;
		String sql = "select * from IssuedBooks";
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				BookTnxDto bookTnxDto = new BookTnxDto();
				bookTnxDto.setBookId(rs.getString("BookId"));
				bookTnxDto.setMemberId(rs.getInt("MemberId"));
				bookTnxDto.setBorrowdate(rs.getDate("Borrowdate"));
				bookTnxDto.setReturndate(rs.getDate("returndate"));
				bookTnxDto.setDuedate(rs.getDate("duedate"));
				bookTnxList.add(bookTnxDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return bookTnxList;
	}

	public static BookTnxDto retrieveTnx(BookTnxDto bookTnxDto) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "select * from IssuedBooks where bookId=?";

		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, bookTnxDto.getBookId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				bookTnxDto.setBookId(rs.getString("BookId"));
				bookTnxDto.setMemberId(rs.getInt("MemberId"));
				bookTnxDto.setBorrowdate(rs.getDate("Borrowdate"));
				bookTnxDto.setReturndate(rs.getDate("returndate"));
				bookTnxDto.setDuedate(rs.getDate("duedate"));
				System.out.println(rs.getInt("MemberId"));

				System.out.println("=======>"+bookTnxDto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return bookTnxDto;
	}

	public static boolean idCheckTnx(String bookid) {
		Connection con = null;
		PreparedStatement pst = null;
		boolean status = false;
		String sql = "select * from IssuedBooks where bookId=?";
		try {
			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, bookid);
			ResultSet rs = pst.executeQuery();
			status = rs.next();
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	public static boolean insertTnx(BookTnxDto bookTnxDto) {
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		//int result = 0;
		boolean status = false;
		String stat = "unavailable";
		String sql1 = "insert into IssuedBooks values(?,?,?,?,?)";
		String sql2 = "update book set status=? where bookid=?";
		con = JDBCConnection.getConnection();
		try {
			con.setAutoCommit(false);
			pst1 = con.prepareStatement(sql1);
			pst2 = con.prepareStatement(sql2);

			pst1.setString(1, bookTnxDto.getBookId());
			pst1.setInt(2, bookTnxDto.getMemberId());
			pst1.setDate(3, new java.sql.Date(bookTnxDto.getBorrowdate().getTime()));
			pst1.setDate(4, new java.sql.Date(bookTnxDto.getReturndate().getTime()));
			pst1.setDate(5, new java.sql.Date(bookTnxDto.getDuedate().getTime()));
			pst2.setString(1, stat);
			pst2.setString(2, bookTnxDto.getBookId());
			int tx1 = pst1.executeUpdate();
			int tx2 = pst2.executeUpdate();

			if (tx1 + tx2 == 2) {
				con.commit();
				status=true;
				System.out.println((tx1+tx2) + " success");
			} else {
				con.rollback();
				System.out.println("failed");
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("tnx failed in insert");
			} catch (Exception e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst1);
			JDBCConnection.closeStatement(pst2);

			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	public static boolean updateTnx(BookTnxDto bookTnxDto) {
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		boolean status = false;
		String sql1 = "update IssuedBooks set bookid=?, memberid=?,borrowdate=?,returndate=?,duedate=? where bookId=?";
		String sql2 = "update book set status=? where bookId=?";
		con = JDBCConnection.getConnection();

		try {

			con.setAutoCommit(false);
			pst1 = con.prepareStatement(sql1);
			pst2 = con.prepareStatement(sql2);

			pst1.setString(1, bookTnxDto.getBookId());
			pst1.setInt(2, bookTnxDto.getMemberId());
			pst1.setDate(3, new java.sql.Date(bookTnxDto.getBorrowdate().getTime()));
			pst1.setDate(4, new java.sql.Date(bookTnxDto.getReturndate().getTime()));
			pst1.setDate(5, new java.sql.Date(bookTnxDto.getDuedate().getTime()));

			pst1.setString(6, bookTnxDto.getBookId());
			String stat = "available";
			pst2.setString(1, stat);

			pst2.setString(2, bookTnxDto.getBookId());
			int tx1 = pst1.executeUpdate();
			int tx2 = pst2.executeUpdate();

			if (tx1 + tx2 == 2) {
				con.commit();
				status=true;
				System.out.println(" success");
			} else {
				con.rollback();
				System.out.println("failed");
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("tnx failed in update");
			} catch (Exception e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst1);
			JDBCConnection.closeStatement(pst2);

			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	public static boolean deleteTnx(String bookId) {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		boolean status = false;
		String sql = "delete from issuedbooks where bookid=?";

		try {

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, bookId);
			result = pst.executeUpdate();
			if (result > 0) {
				System.out.println(result + " row deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);

			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	public static boolean deleteAllBooks() {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		boolean status = false;
		String sql = "delete  * from book";

		try {

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			result = pst.executeUpdate();
			if (result > 0) {
				System.out.println(result + " all rows deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);

			JDBCConnection.closeConnection(con);
		}
		return status;
	}
	public static boolean deleteAll() {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		boolean status = false;
		String sql = "delete  * from issuedbooks";

		try {

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			result = pst.executeUpdate();
			if (result > 0) {
				System.out.println(result + " all rows deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);

			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	
	public static boolean updateBook(BookRegDto bookRegDto) {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		boolean status = false;
		String sql = "update Book set bookid=?,bookgroupid=?,bookname=?,iSBNNo=?,author=?,category=?,status=? where bookid=?";
		try {

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, bookRegDto.getBookId());
			pst.setInt(2, bookRegDto.getBookGroupId());
			pst.setString(3, bookRegDto.getBookName());
			pst.setString(4, bookRegDto.getiSBNNo());
			pst.setString(5, bookRegDto.getAuthor());
			pst.setString(6, bookRegDto.getCategory());
			pst.setString(7, bookRegDto.getStatus());
			pst.setString(8, bookRegDto.getBookId());

			result = pst.executeUpdate();
			if (result > 0) {
				status = true;
				System.out.println(result + " row updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return status;
	}

	public static boolean updateMember(MmbrRegDto mmbrRegDto) {
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		boolean status = false;
		String sql = "update  Member  set memberid=?,membername=?,streetno=?,streetname=?,city=?,district=?,pincode=?,country=?,memberType="
				+ "? where memberid=?";
		try {
			Address add = mmbrRegDto.getAddress();

			con = JDBCConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mmbrRegDto.getMemberID());
			pst.setString(2, mmbrRegDto.getMemberName());
			pst.setString(3, add.getStreetNo());
			pst.setString(4, add.getStreetName());
			pst.setString(5, add.getCity());
			pst.setString(6, add.getDistrict());
			pst.setLong(7, add.getPincode());
			pst.setString(8, Address.COUNTRY);
			pst.setString(9, mmbrRegDto.getMemberType());
			pst.setInt(10, mmbrRegDto.getMemberID());

			result = pst.executeUpdate();
			if (result > 0) {
				status = true;
				System.out.println(result + " row updated- member");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.closeStatement(pst);
			JDBCConnection.closeConnection(con);
		}
		return status;
	}
}
