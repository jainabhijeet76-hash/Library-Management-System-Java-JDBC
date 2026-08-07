package com.adda.menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.adda.model.Book;
import com.adda.model.Member;
import com.adda.model.IssueRecord;

import com.adda.service.BookService;
import com.adda.service.MemberService;
import com.adda.service.IssueRecordService;

import com.adda.service.impl.BookServiceImpl;
import com.adda.service.impl.MemberServiceImpl;
import com.adda.service.impl.IssueRecordServiceImpl;

public class LibraryMenu 
{

	private Scanner sc = new Scanner(System.in);

	private BookService bookService = new BookServiceImpl();

	private MemberService memberService = new MemberServiceImpl();

	private IssueRecordService issueService = new IssueRecordServiceImpl();

	public void start() 
	{

		while (true) 
		{

			System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

			System.out.println("1. Add Book");
			System.out.println("2. View Books");
			System.out.println("3. Update Book");
			System.out.println("4. Delete Book");

			System.out.println("5. Add Member");
			System.out.println("6. View Members");

			System.out.println("7. Issue Book");
			System.out.println("8. Return Book");

			System.out.println("9. View Issued Books");
			System.out.println("10. View Overdue Books");

			System.out.println("11. Exit");

			System.out.print("Enter Choice : ");

			int choice = sc.nextInt();

			switch (choice) 
			{

			case 1:
				addBook();
				break;

			case 2:
				viewBooks();
				break;

			case 3:
				updateBook();
				break;

			case 4:
				deleteBook();
				break;

			case 5:
				addMember();
				break;

			case 6:
				viewMembers();
				break;

			case 7:
				issueBook();
				break;

			case 8:
				returnBook();
				break;

			case 9:
				viewIssuedBooks();
				break;

			case 10:
				viewOverdueBooks();
				break;

			case 11:
				System.out.println("Thank You");
				System.exit(0);

			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	private void addBook() 
	{

		System.out.print("Book Id : ");
		int id = sc.nextInt();

		sc.nextLine();

		System.out.print("Title : ");
		String title = sc.nextLine();

		System.out.print("Author : ");
		String author = sc.nextLine();

		System.out.print("Publisher : ");
		String publisher = sc.nextLine();

		System.out.print("Total Copies : ");
		int totalCopies = sc.nextInt();

		Book book = new Book(id, title, author, publisher, totalCopies, totalCopies);

		bookService.addBook(book);
	}

	private void viewBooks() 
	{

		List<Book> books = bookService.getAllBooks();

		for (Book book : books) {

			System.out.println(book);
		}
	}

	private void updateBook() 
	{

		System.out.print("Book Id : ");
		int id = sc.nextInt();

		sc.nextLine();

		System.out.print("New Title : ");
		String title = sc.nextLine();

		System.out.print("New Author : ");
		String author = sc.nextLine();

		System.out.print("New Publisher : ");
		String publisher = sc.nextLine();

		System.out.print("Total Copies : ");
		int totalCopies = sc.nextInt();

		System.out.print("Available Copies : ");
		int availableCopies = sc.nextInt();

		Book book = new Book(id, title, author, publisher, totalCopies, availableCopies);

		bookService.updateBook(book);
	}

	private void deleteBook()
	{

		System.out.print("Book Id : ");

		int id = sc.nextInt();

		bookService.deleteBook(id);
	}

	private void addMember()
	{

		System.out.print("Member Id : ");
		int id = sc.nextInt();

		sc.nextLine();

		System.out.print("Name : ");
		String name = sc.nextLine();

		System.out.print("Email : ");
		String email = sc.nextLine();

		System.out.print("Phone : ");
		String phone = sc.nextLine();

		Member member = new Member(id, name, email, phone);

		memberService.addMember(member);
	}

	private void viewMembers() 
	{

		List<Member> members = memberService.getAllMembers();

		for (Member member : members) {

			System.out.println(member);
		}
	}

	private void issueBook() 
	{

		System.out.print("Book Id : ");
		int bookId = sc.nextInt();

		System.out.print("Member Id : ");
		int memberId = sc.nextInt();

		IssueRecord record = new IssueRecord(0, bookId, memberId, LocalDate.now(), null);

		issueService.issueBook(record);
	}

	private void returnBook()
	{

		System.out.print("Record Id : ");

		int recordId = sc.nextInt();

		issueService.returnBook(recordId);
	}

	private void viewIssuedBooks()
	{

		List<IssueRecord> records = issueService.getIssuedBooks();

		for (IssueRecord record : records) {

			System.out.println("Record Id : " + record.getRecordId() + " Book Id : " + record.getBookId()
					+ " Member Id : " + record.getMemberId());
		}
	}

	private void viewOverdueBooks()
	{

		List<IssueRecord> records = issueService.getOverdueBooks();

		for (IssueRecord record : records) {

			System.out.println("Overdue Record : " + record.getRecordId());
		}
	}
}