package com.adda.dao;

import java.util.List;
import com.adda.model.IssueRecord;

public interface IssueRecordDAO 
{

    void issueBook(IssueRecord issueRecord);

    void returnBook(int recordId);

    List<IssueRecord> getIssuedBooks();

    List<IssueRecord> getOverdueBooks();
}