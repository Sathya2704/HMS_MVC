package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.botree.bean.HmsUser;
import com.botree.constants.HmsQueryConstants;
import com.botree.util.HmsUtil;

public class HmsLoginDao {

public HmsUser getUser(HmsUser user) {
		
		Connection conn = HmsUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HmsUser u = null;
		
		try {
			pstmt = conn.prepareStatement(HmsQueryConstants.LOGIN_SQL); 
			pstmt.setString(1, user.username());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				u = new HmsUser(user.username(), rs.getString("password")); 
			}
			
		}catch(Exception e) {
			
		}
		return u;
	}
}
