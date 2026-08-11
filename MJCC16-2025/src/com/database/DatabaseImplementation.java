package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.controller.GFG2;
import com.interfaces.DatabaseInterface;
import com.interfaces.GroupInterface;
import com.model.UserFiles;
import com.model.UserModel;
import com.util.RandomGenerator;

import java.util.stream.Collectors;


public class DatabaseImplementation implements DatabaseInterface,GroupInterface {

	@Override
	public int registerUser(UserModel um) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			Connection con=DbConnection.getConnection();
			String sql="insert into register values(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			int num=RandomGenerator.generate();
			ps.setInt(1, num);
			ps.setString(2, um.getName());
			ps.setString(3, um.getEmail());
			ps.setString(4, um.getPassword());
			ps.setString(5, um.getDob());
			ps.setString(6, um.getGroup());
			ps.setString(7, um.getGender());
			ps.setString(8, um.getPnumber());
			ps.setString(9, um.getAddress());
			ps.setString(10,um.getStatus());
			 
			 i=ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}

	@Override
	public UserModel loginUser(String username, String password) {
		UserModel um=null;
		try {
			Connection con=DbConnection.getConnection();
			String sql="SELECT * FROM register WHERE email='"+username+"' AND PASSWORD='"+password+"'AND status='approved'";
		//	String sql="SELECT * FROM register WHERE email='"+username+"' and password ='"+password+"'";
			System.out.println(sql);
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			while(r.next()){
				um=new UserModel();
				um.setUserid(r.getInt(1));
				um.setName(r.getString(2));
				um.setEmail(r.getString(3));
				um.setPassword(r.getString(4));
				um.setDob(r.getString(5));
				um.setGroup(r.getString(6));
				um.setGender(r.getString(7));
				um.setPnumber(r.getString(8));
				um.setAddress(r.getString(9));
		}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return um;
	}

	@Override
	public boolean insertGroup(String name, String size) {
		System.out.println("user details"+name+size);
		
		int i=0;
		boolean f = false;
		try {
			Connection con=DbConnection.getConnection();
			String sql1="select * from grouptable where groupname='"+name+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql1);
			if(rs.next()){
				f=false;
			}else{
				String sql="insert into grouptable values(?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, size);
				i=ps.executeUpdate();
	if(i==0){
		f=false;
	}else{
		f=true;
	}
			}
			}catch(Exception e){
		e.printStackTrace();
	}
		
		return f;

}

	@Override
	public List<UserModel> viewMembers() {
		Connection con;
		List<UserModel> al=new ArrayList();
		try {
			con = DbConnection.getConnection();
		
		String sql1="select * from register where status='pending'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql1);
		
		while(rs.next()){
			UserModel um=new UserModel();
			um.setUserid(rs.getInt(1));
			um.setEmail(rs.getString(3));
			um.setGroup(rs.getString(6));
			al.add(um);
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public boolean approveUser(int userid) {
		boolean f=false;
		Connection con;
		
		try {
			con = DbConnection.getConnection();
			String sql1="update register set status='approved' where userid="+userid;
			Statement st=con.createStatement();
			int i=st.executeUpdate(sql1);
			if(i==0){
				f=false;
			}else{
				f=true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public String uploadFile(int userid,String fileName) {
		boolean f=false;
		Connection con;
		String privatekey=RandomeString.getSaltString();
		try {
			con = DbConnection.getConnection();
			String sql1="insert into upload values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql1);
			ps.setInt(1, userid);
			ps.setString(2,fileName+".txt");
			ps.setString(3,privatekey);
			GFG2 gfg2=new GFG2();
			ps.setString(4,gfg2.getHash(fileName));
			
			int i=ps.executeUpdate();
			if(i==-1){
				f=false;
			}else{
				f=true;
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
		if(f)
		   return "success";
		else
			return "fail";
	}

	@Override
	public List<UserFiles> userFiles(int userid) {
		// TODO Auto-generated method stub
		ArrayList<UserFiles> al=new ArrayList<UserFiles>();
		Connection con;
	
		try {
			con = DbConnection.getConnection();
			String sql="SELECT * FROM upload WHERE userid='"+userid+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				UserFiles uf=new UserFiles();
				uf.setUserid(rs.getInt(1));
				uf.setFileName(rs.getString(2));
				al.add(uf);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return al;
	}

	@Override
	public List<String> groups() {
	Connection con;
	
	ArrayList<String> al=new ArrayList<String>();
	try{
		con=DbConnection.getConnection();
		String sql="select groupname from grouptable";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			al.add(rs.getString(1));
		}
		
		}catch(Exception e){
		e.printStackTrace();
	}
	
		return al;
	}

	@Override
	public List<UserFiles> userFiles1(int userid) {
		List<UserFiles> al=new ArrayList<UserFiles>();
		List<UserFiles> al1=new ArrayList<UserFiles>();
		Connection con;
	
		try {
			con = DbConnection.getConnection();
			String sql="SELECT * FROM upload WHERE NOT userid='"+userid+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				UserFiles uf=new UserFiles();
				uf.setUserid(rs.getInt(1));
				uf.setFileName(rs.getString(2));
				al.add(uf);
				
				}
			
			String sql1="select * from rtable where userid='"+userid+"'";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			while(rs1.next()){
				/*UserFiles uf=new UserFiles();
				uf.setUserid(rs1.getInt(1));
				uf.setFileName(rs1.getString(2));*/
			   for(int i=0;i<al.size();i++){
				  UserFiles uf1=al.get(i);
				  if(uf1.getFileName().equalsIgnoreCase(rs1.getString(2))){
					  al.remove(i);
				  }
			   }
				
				}
			
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return al;
	}

	@Override
	public boolean requestFile(int userid, String filename, String status) {
		boolean f=false;
		Connection con;
		//String privatekey=RandomeString.getSaltString();
		try {
			con = DbConnection.getConnection();
			String sql1="insert into rtable values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql1);
			ps.setInt(1, userid);
			ps.setString(2,filename);
			ps.setString(3,"pending");
			
			int i=ps.executeUpdate();
			if(i==-1){
				f=false;
			}else{
				f=true;
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
		return f;
		
	}

	@Override
	public List<UserFiles> userReq(int userid) {
		// TODO Auto-generated method stub
		ArrayList<UserFiles> al=new ArrayList<UserFiles>();
		Connection con;
	try {
			con = DbConnection.getConnection();
			String sql="SELECT * FROM rtable WHERE userid='"+userid+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				UserFiles uf=new UserFiles();
				uf.setUserid(rs.getInt(1));
				uf.setFileName(rs.getString(2));
				uf.setStatus(rs.getString(3));
				al.add(uf);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return al;
	}

	@Override
	public List<UserFiles> publicReq() {
		// TODO Auto-generated method stub
		ArrayList<UserFiles> al=new ArrayList<UserFiles>();
		Connection con;
	try {
			con = DbConnection.getConnection();
			String sql="SELECT * FROM rtable where status='pending'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				UserFiles uf=new UserFiles();
				uf.setUserid(rs.getInt(1));
				uf.setFileName(rs.getString(2));
				uf.setStatus(rs.getString(3));
				al.add(uf);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return al;
	}

	@Override
	public boolean approvePublic(int userid) {
		Connection con;
		boolean f=false;
		try {
				con = DbConnection.getConnection();
				String sql="update rtable set status='approved' where userid="+userid;
				Statement st=con.createStatement();
				int i=st.executeUpdate(sql);
				if(i!=-1){
					f=false;
				}else{
					f=true;
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	
	
	public List<String> getGroups() {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<>();
		Connection con;
	try {
			con = DbConnection.getConnection();
			String sql="SELECT * FROM grouptable";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				al.add(rs.getString(1));
				
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return al;
	}
}
