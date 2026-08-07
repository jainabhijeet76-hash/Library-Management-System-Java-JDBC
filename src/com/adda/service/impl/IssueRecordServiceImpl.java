package com.adda.service.impl;

import java.util.List;

import com.adda.dao.BookDAO;
import com.adda.dao.IssueRecordDAO;
import com.adda.dao.MemberDAO;

import com.adda.dao.impl.BookDAOImpl;
import com.adda.dao.impl.IssueRecordDAOImpl;
import com.adda.dao.impl.MemberDAOImpl;

import com.adda.model.Book;
import com.adda.model.IssueRecord;
import com.adda.model.Member;

import com.adda.service.IssueRecordService;

public class IssueRecordServiceImpl implements IssueRecordService {

	private IssueRecordDAO issueDAO = new IssueRecordDAOImpl();

	private BookDAO bookDAO = new BookDAOImpl();

	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public void issueBook(IssueRecord issueRecord) {

		Book book = bookDAO.getBookById(issueRecord.getBookId());

		Member member = memberDAO.getMemberById(issueRecord.getMemberId());

		if (book == null) {

			System.out.println("Book Not Found");

			return;
		}

		if (member == null) {

			System.out.println("Member Not Found");

			return;
		}

		if (book.getCopiesAvailable() <= 0) {

			System.out.println("Book Not Available");

			return;
		}

		issueDAO.issueBook(issueRecord);

		book.setCopiesAvailable(book.getCopiesAvailable() - 1);

		bookDAO.updateBook(book);

		System.out.println("Book Issued Successfully");
	}

	@Override
	public void returnBook(int recordId) {

		IssueRecord record = issueDAO.getIssueRecordById(recordId);

		if (record == null) {

			System.out.println("Issue Record Not Found");

			return;
		}

		if (record.getReturnDate() != null) {

			System.out.println("Book Already Returned");

			return;
		}

		Book book = bookDAO.getBookById(record.getBookId());

		if (book == null) {

			System.out.println("Book Not Found");

			return;
		}

		issueDAO.returnBook(recordId);

		book.setCopiesAvailable(book.getCopiesAvailable() + 1);

		bookDAO.updateBook(book);

		System.out.println("Book Returned Successfully");
	}

	@Override
	public List<IssueRecord> getIssuedBooks() {

		return issueDAO.getIssuedBooks();
	}

	@Override
	public List<IssueRecord> getOverdueBooks() {

		return issueDAO.getOverdueBooks();
	}
}