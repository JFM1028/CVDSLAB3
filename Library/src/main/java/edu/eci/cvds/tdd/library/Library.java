package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        if (book == null) {
            return false; // Si el libro es null, retorna false.
        }
        
        books.put(book, books.getOrDefault(book, 0) + 1);
        return true; // Retorna true cuando se añade un libro exitosamente.
    }
    

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        if (user == null) {
            return null; // Si el usuario no existe, retorna null.
        }
    
        Book bookToLoan = books.keySet().stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
        if (bookToLoan == null || books.get(bookToLoan) == 0) {
            return null; // Si el libro no está disponible, retorna null.
        }
    
        boolean alreadyLoaned = loans.stream().anyMatch(loan -> loan.getUser().equals(user) && loan.getBook().getIsbn().equals(isbn) && loan.getStatus() == LoanStatus.ACTIVE);
        if (alreadyLoaned) {
            return null; // Si el usuario ya tiene un préstamo activo de este libro, retorna null.
        }
    
        Loan loan = new Loan();
        loan.setBook(bookToLoan);
        loan.setUser(user);
        loan.setLoanDate(LocalDateTime.now());
        loan.setStatus(LoanStatus.ACTIVE);
        loans.add(loan);
        books.put(bookToLoan, books.get(bookToLoan) - 1); // Decrementa la cantidad disponible del libro.
    
        return loan;
    }
    

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        if (loan == null || loan.getStatus() == LoanStatus.RETURNED) {
            return null; // Si el préstamo es nulo o ya está devuelto, retorna null.
        }
    
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
        books.put(loan.getBook(), books.get(loan.getBook()) + 1); // Incrementa la cantidad disponible del libro.
    
        return loan;
    }
    
    

    public boolean addUser(User user) {
        if (user == null) {
            return false;
        }
        return users.add(user);
    }
    
}