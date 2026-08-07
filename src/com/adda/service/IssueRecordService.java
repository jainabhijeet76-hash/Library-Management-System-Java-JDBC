package com.adda.service;

import java.util.List;
import com.adda.model.IssueRecord;

public interface IssueRecordService 
{

    void issueBook(IssueRecord issueRecord);

    void returnBook(int recordId);

    List<IssueRecord> getIssuedBooks();

    List<IssueRecord> getOverdueBooks();
}