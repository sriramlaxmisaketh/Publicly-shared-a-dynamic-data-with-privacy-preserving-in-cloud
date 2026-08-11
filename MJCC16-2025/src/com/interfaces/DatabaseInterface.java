package com.interfaces;

import java.util.List;

import com.model.UserFiles;
import com.model.UserModel;

public interface DatabaseInterface {
	public int registerUser(UserModel um);
	public UserModel loginUser(String username,String password);
	public List<UserModel> viewMembers();
		public boolean approveUser(int userid);
	public String uploadFile(int userid,String fileName);
	public List<UserFiles> userFiles(int userid);
	public List<String> groups();
	public List<UserFiles> userFiles1(int userid);
	public boolean requestFile(int userid,String filename,String status);
	public List<UserFiles> userReq(int Userid);
	public List<UserFiles> publicReq();
	public boolean approvePublic(int userid);
	}
