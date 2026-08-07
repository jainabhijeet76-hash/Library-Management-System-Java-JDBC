package com.adda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.adda.dao.IssueRecordDAO;
import com.adda.model.IssueRecord;
import com.adda.utility.DBConnection;

public class IssueRecordDAOImpl implements IssueRecordDAO 
{

	@Override
	public void issueBook(IssueRecord issueRecord) 
	{

		try 
		{

			Connection con = DBConnection.getConnection();

			String query = "insert into issue_records(book_id,member_id,issue_date,return_date) values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, issueRecord.getBookId());
			ps.setInt(2, issueRecord.getMemberId());
			ps.setDate(3, java.sql.Date.valueOf(issueRecord.getIssueDate()));

			ps.setDate(4, null);

			ps.executeUpdate();

			System.out.println("Book Issued Successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void returnBook(int recordId) 
	{

		try
		{

			Connection con = DBConnection.getConnection();

			String query = "update issue_records set return_date=? where record_id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setDate(1, java.sql.Date.valueOf(LocalDate.now()));

			ps.setInt(2, recordId);

			ps.executeUpdate();

			System.out.println("Book Returned Successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<IssueRecord> getIssuedBooks()
	{

		List<IssueRecord> records = new ArrayList<>();

		try 
		{

			Connection con = DBConnection.getConnection();

			String query = "select * from issue_records where return_date is null";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				IssueRecord record = new IssueRecord();

				record.setRecordId(rs.getInt("record_id"));

				record.setBookId(rs.getInt("book_id"));

				record.setMemberId(rs.getInt("member_id"));

				record.setIssueDate(rs.getDate("issue_date").toLocalDate());

				records.add(record);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return records;
	}

	@Override
	public List<IssueRecord> getOverdueBooks() 
	{

		List<IssueRecord> records = new ArrayList<>();

		try
		{

			Connection con = DBConnection.getConnection();

			String query = "select * from issue_records where return_date is null";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				LocalDate issueDate = rs.getDate("issue_date").toLocalDate();

				if (issueDate.plusDays(14).isBefore(LocalDate.now())) {

					IssueRecord record = new IssueRecord();

					record.setRecordId(rs.getInt("record_id"));

					record.setBookId(rs.getInt("book_id"));

					record.setMemberId(rs.getInt("member_id"));

					record.setIssueDate(issueDate);

					records.add(record);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return records;
	}
}