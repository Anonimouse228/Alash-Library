## Design Decisions
The project is designed to simulate a library system. The system consists of four classes: Book, EBook, Library, and Transaction. Book and EBook classes are used to store information about physical books and e-books. Library class is used to store books and e-books, and to track checked-out items. Transaction class is used to store information about transactions.

## Class Relationships
- Book class has three attributes: title, author, and isbn. It also has a method displayBookInfo() which displays details of the book. And a method getIsbn() to get the isbn and use it to search through books.
- EBook class inherits from Book class and has an additional attribute fileSizeInMB. It overrides the displayBookInfo() method to include information specific to e-books.
- Library class has four attributes: books, ebooks, checkedOutBooks, and checkedOutEBooks. books and ebooks are lists used to store physical books and e-books. checkedOutBooks and checkedOutEBooks are lists used to track checked-out physical books and e-books. It has methods: addBook(Book book), addEBook(EBook ebook), checkOutBook(Book book), checkOutEBook(EBook ebook), displayCheckedOutBooks(), displayAllBooks(), and displayTransactionHistory() and displayTransactionHistory(int n)
- Transaction class has four attributes: transactionId, timestamp, action, and item. transactionId is a unique identifier for each transaction. timestamp is the date and time of the transaction. action is a description of the action (for example "Check Out Book", "Add EBook"). item is the book or e-book involved in the transaction.

## How to Use the System
The system can be used through a simple console-based user interface. The following options are available:
1: Display all books
2: Display last N books
3: Add a book
4: Find a book by a isbn
5: Find a book
6: Log out
7: (ADMIN COMMAND)See users
8: (ADMIN COMMAND)See last n users

Validation checks implemented to ensure that users cannot check out more items than the library has in stock.

## Challenges that I faced
I had some struggles

## Conclusion
This project provides a simple simulation of a library system. It can be used as a starting point for more complex library systems. The code is well-documented and easy to understand.
