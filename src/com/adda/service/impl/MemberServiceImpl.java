package com.adda.service.impl;

import java.util.List;

import com.adda.dao.MemberDAO;
import com.adda.dao.impl.MemberDAOImpl;
import com.adda.model.Member;
import com.adda.service.MemberService;

public class MemberServiceImpl implements MemberService 
{

	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public void addMember(Member member) 
	{

		if (member.getName() == null || member.getName().trim().isEmpty()) 
		{

			System.out.println("Member Name Cannot Be Empty");

			return;
		}

		memberDAO.addMember(member);
	}

	@Override
	public void updateMember(Member member)
	{

		Member existingMember = memberDAO.getMemberById(member.getMemberId());

		if (existingMember == null) 
		{

			System.out.println("Member Not Found");

			return;
		}

		memberDAO.updateMember(member);
	}

	@Override
	public void deleteMember(int memberId) 
	{

		Member member = memberDAO.getMemberById(memberId);

		if (member == null)
		{

			System.out.println("Member Not Found");

			return;
		}

		memberDAO.deleteMember(memberId);
	}

	@Override
	public Member getMemberById(int memberId) 
	{

		return memberDAO.getMemberById(memberId);
	}

	@Override
	public List<Member> getAllMembers() 
	{

		return memberDAO.getAllMembers();
	}
}