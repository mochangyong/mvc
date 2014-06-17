package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.naver.model.BoardBean;

public class BoardDAO {
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	DataSource ds = null;
	
	public BoardDAO(){
		
		try{
		Context ctx = new InitialContext();
		ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public int insertBoard(BoardBean b) {
			int re =-1;
			try{
				con=ds.getConnection();
				sql ="insert into board (board_no,board_name,board_title, "
						+ "board_cont , board_pwd, board_date) values(board_no_seq.nextval, "
						+ "?,?,?,?,sysdate)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, b.getBoard_name());
				pstmt.setString(2, b.getBoard_title());
				pstmt.setString(3, b.getBoard_cont());
				pstmt.setString(4, b.getBoard_pwd());

				re=pstmt.executeUpdate();
				
				
				pstmt.close(); con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
		return re;
	}

	public int getCount() {
		int count =0;
		
		try{
			con=ds.getConnection();
			sql="select count(board_no) from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt(1);
			}
			
			rs.close(); pstmt.close(); con.close();
			}catch(Exception e){
				e.printStackTrace();
			
		}
		
		
		return count;
	}

	public List<BoardBean> getList() {
			List<BoardBean> blist = new ArrayList<BoardBean>();
		try{
			con=ds.getConnection();
			sql="select * from board order by board_no desc ";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				BoardBean b= new BoardBean();
				b.setBoard_no(rs.getInt("board_no"));
				b.setBoard_name(rs.getString("board_name"));
				b.setBoard_title(rs.getString("board_title"));
				b.setBoard_hit(rs.getInt("board_hit"));
				b.setBoard_date(rs.getString("board_date"));
				
				blist.add(b);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return blist;
	}

	public void updatehit(int board_no) {

		try{
			con=ds.getConnection();
			sql="update board set board_hit=board_hit+1 "
					+ "where board_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,board_no);
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public BoardBean getBoardCont(int board_no) {
		BoardBean b=null;
			
		try{
			con=ds.getConnection();
			sql="select board_no , board_name, board_title, "
					+ "board_cont, board_pwd, board_hit "
					+ "from board where board_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				b=new BoardBean();
			  b.setBoard_no(rs.getInt(1));
			  b.setBoard_name(rs.getString(2));
			  b.setBoard_title(rs.getString(3));
			  b.setBoard_cont(rs.getString(4));
			  b.setBoard_pwd(rs.getString(5));
			  b.setBoard_hit(rs.getInt(6));
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	public int editBoard(BoardBean eb) {
		int re=-1;
		try{
			con=ds.getConnection();
			sql="update board set board_name=?, board_title=?, "
					+ "board_cont=?  where board_no=? ";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, eb.getBoard_name());
			pstmt.setString(2, eb.getBoard_title());
			pstmt.setString(3, eb.getBoard_cont());
			pstmt.setInt(4, eb.getBoard_no());
			re=pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		return re;
	}

	public int Delboard(int board_no) {
		int re=-1;
		try{
			con=ds.getConnection();
			sql="delete from board where board_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,board_no);
			re=pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return re;
	}

}
