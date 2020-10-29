package com.henrybooks.repository;

import com.henrybooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO book " +
            "VALUES (:bcode, :title, :pcode, :type, :paperback)", nativeQuery = true)
    int createOne(@Param("bcode") String bcode, @Param("title") String title,
                  @Param("pcode") String pcode, @Param("type") String type,
                  @Param("paperback") String paperback);

    @Query(value = "SELECT\n" +
            "   b.title,\n" +
            "   SUM(i.OnHand),\n" +
            "   br.bnum,\n" +
            "   br.bname,\n" +
            "   br.bloc,\n" +
            "   p.publisherCode,\n" +
            "   p.publisherName,\n" +
            "   p.city,\n" +
            "   a.authorLast,\n" +
            "   a.authorFirst\n" +
            "FROM\n" +
            "   publisher p INNER JOIN\n" +
            "   book b ON b.publisherCode = p.publisherCode INNER JOIN\n" +
            "   wrote w ON w.bookCode = b.bookCode INNER JOIN\n" +
            "   author a ON a.authorNum = w.authorNum INNER JOIN\n" +
            "   inventory i ON i.BookCode = b.bookCode INNER JOIN\n" +
            "   (SELECT\n" +
            "       bk.bookCode bkCode,\n" +
            "       br.branchNum bnum,\n" +
            "       br.branchName bname,\n" +
            "       br.branchLocation bloc\n" +
            "   FROM\n" +
            "       book bk INNER JOIN\n" +
            "       inventory i ON i.BookCode = bk.bookCode INNER JOIN\n" +
            "       branch br ON br.branchNum = i.BranchNum\n" +
            "   WHERE\n" +
            "       bk.title = 'The Stranger'\n" +
            "   GROUP BY\n" +
            "       br.branchNum) br ON br.bkCode = b.bookCode\n" +
            "GROUP BY\n" +
            "   br.bnum;",
            nativeQuery = true)
    List getBookStatsByTitle(@Param("title") String title);

    @Modifying
    @Transactional
    @Query(value = "UPDATE book " +
            "SET title = :title, publisherCode = :pcode, type = :type, paperback = :paperback " +
            "WHERE bookCode = :bcode", nativeQuery = true)
    int updateOne(@Param("bcode") String bcode, @Param("title") String title,
                   @Param("pcode") String pcode, @Param("type") String type,
                   @Param("paperback") String paperback);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book " +
            "WHERE book.bookCode = :id", nativeQuery = true)
    void deleteOne(@Param("id") String id);
}
