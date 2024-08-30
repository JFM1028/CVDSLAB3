package edu.eci.cvds.tdd.library;
import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private User user;
    private Book book;

    @BeforeEach
    public void setUp() {
        library = new Library();
        user = new User();
        user.setId("user1");
        user.setName("John Doe");
        book = new Book("Title", "Author", "12345");
        library.addUser(user);
    }

    @Test
    public void testAddBook() {
        assertTrue(library.addBook(book));
        assertFalse(library.addBook(null)); // Adding null should return false
    }

    @Test
    public void testLoanABook() {
        library.addBook(book);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertNotNull(loan);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());

        // Test loaning the same book again
        Loan secondLoan = library.loanABook(user.getId(), book.getIsbn());
        assertNull(secondLoan); // The book should already be loaned
    }

    @Test
    public void testReturnLoan() {
        library.addBook(book);
        Loan loan = library.loanABook(user.getId(), book.getIsbn());
        assertNotNull(loan);
        
        Loan returnedLoan = library.returnLoan(loan);
        assertNotNull(returnedLoan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertNotNull(returnedLoan.getReturnDate());

        // Try returning the same loan again
        Loan returnedLoanAgain = library.returnLoan(loan);
        assertNull(returnedLoanAgain); // Should be null as the loan is already returned
    }

    @Test
    public void testAddUser() {
        User newUser = new User();
        newUser.setId("user2");
        newUser.setName("Jane Doe");
        assertTrue(library.addUser(newUser));
        assertFalse(library.addUser(null)); // Adding null should return false
    }
}
