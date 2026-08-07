package com.adda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adda.dao.MemberDAO;
import com.adda.model.Member;
import com.adda.utility.DBConnection;

public class MemberDAOImpl implements MemberDAO 
{

	@Override
	public void addMember(Member member) 
	{

		try 
		{

			Connection con = DBConnection.getConnection();

			String query = "insert into members values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, member.getMemberId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Member Added Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMember(Member member)
	{

		try 
		{

			Connection con = DBConnection.getConnection();

			String query = "update members set name=?,email=?,phone=? where member_id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPhone());
			ps.setInt(4, member.getMemberId());

			ps.executeUpdate();

			System.out.println("Member Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMember(int memberId) 
	{

		try 
		{

			Connection con = DBConnection.getConnection();

			String query = "delete from members where member_id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, memberId);

			ps.executeUpdate();

			System.out.println("Member Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Member getMemberById(int memberId) 
	{

		Member member = null;

		try 
		{

			Connection con = DBConnection.getConnection();

			String query = "select * from members where member_id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, memberId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				member = new Member();

				member.setMemberId(rs.getInt("member_id"));

				member.setName(rs.getString("name"));

				member.setEmail(rs.getString("email"));

				member.setPhone(rs.getString("phone"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public List<Member> getAllMembers() 
	{

		List<Member> members = new ArrayList<>();

		try 
		{

			Connection con = DBConnection.getConnection();

			String query = "select * from members";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Member member = new Member();

				member.setMemberId(rs.getInt("member_id"));

				member.setName(rs.getString("name"));

				member.setEmail(rs.getString("email"));

				member.setPhone(rs.getString("phone"));

				members.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return members;
	}
}