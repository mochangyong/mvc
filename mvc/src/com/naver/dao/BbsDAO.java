package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.naver.model.BbsBean;



public class BbsDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	String sql = null;
			
	public BbsDAO(){
		
		try{
		Context ctxt = new InitialContext();
		ds=(DataSource)ctxt.lookup("java:comp/env/jdbc/xe");
		}catch(Exception e){
			e.printStackTrace();
			
			
		}
		
	}

	public int insertb(BbsBean b) {
		int re =-1;
		
		try{
			con= ds.getConnection();
			sql="insert into bbs (bbs_no, bbs_name, bbs_title, bbs_cont, "
					+ "bbs_pwd, bbs_date) values(bbs_no_seq.nextval, "
					+ "?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, b.getBbs_name());
			pstmt.setString(2, b.getBbs_title());
			pstmt.setString(3, b.getBbs_cont());
			pstmt.setString(4, b.getBbs_pwd());
			
			re=pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return re;
	}

	public List<BbsBean> getBbsList() {
		
		List<BbsBean> blist= new ArrayList<BbsBean>();
		
		try{
			con=ds.getConnection();
			sql="select * from bbs order by bbs_no desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				BbsBean b = new BbsBean();
				
				b.setBbs_no(rs.getInt("bbs_no"));
				b.setBbs_name(rs.getString("bbs_name"));
				b.setBbs_title(rs.getString("bbs_title"));
				b.setBbs_hit(rs.getInt("bbs_hit"));
				b.setBbs_date(rs.getString("bbs_date"));
				
				blist.add(b);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return blist;
	}

	public int getcount() {
		int count=0;
		try{
			con=ds.getConnection();
			sql ="select count(bbs_no) from bbs ";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}

	public void updatehit(int bbs_no) {
			
			try{
				con=ds.getConnection();
				sql="update bbs set bbs_hit = bbs_hit+1 where bbs_no =?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, bbs_no);
				pstmt.executeUpdate();
				
				pstmt.close(); con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	public BbsBean getbbsCont(int bbs_no) {
		BbsBean b = null;
		try{
			con=ds.getConnection();
			sql="select bbs_no, bbs_name , bbs_title, bbs_cont, bbs_pwd, bbs_hit from bbs where bbs_no=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bbs_no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				b= new BbsBean();
				b.setBbs_no(rs.getInt("bbs_no"));
			b.setBbs_name(rs.getString("bbs_name"));
			b.setBbs_title(rs.getString("bbs_title"));
			b.setBbs_cont(rs.getString("bbs_cont"));
			b.setBbs_pwd(rs.getString("bbs_pwd"));
			b.setBbs_hit(rs.getInt("bbs_hit"));
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return b;
	}

	public int Editbbs(BbsBean eb) {
		int re = -1;
		try{
			con=ds.getConnection();
			sql="update bbs set bbs_name =? , bbs_title=?, bbs_cont=?  "
					+ "where bbs_no = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, eb.getBbs_name());
			pstmt.setString(2, eb.getBbs_title());
			pstmt.setString(3, eb.getBbs_cont());
			pstmt.setInt(4, eb.getBbs_no());
			re=pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return re;
	}

	public int Delbbs(int bbs_no) {
		int re=-1;
		try{
			con=ds.getConnection();
			sql ="delete from bbs where bbs_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bbs_no);
			re=pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return re;
	}


	
			
			
			
}
