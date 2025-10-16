package Ch45_ex10;

import java.util.Objects;

class Book
{
    String isbn;
    String title;
    String author;

    public Book(String isbn, String title, String author)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "Book{isbn='" + isbn + "', title='" + title + "', author='" + author + "'}";
    }

    @Override

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(isbn);
    }
}

public class ObjectContractVerification
{
    public static void main(String[] args)
    {
        Book b1 = new Book("978-1234567890", "Java Basics", "Alice");
        Book b2 = new Book("978-1234567890", "Advanced Java", "Bob");
        Book b3 = new Book("978-0987654321", "Python 101", "Carol");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        System.out.println();

        System.out.println("b1 == b2 ? " + (b1 == b2));
        System.out.println("b1.equals(b2) ? " + b1.equals(b2));
        System.out.println("b1.equals(b3) ? " + b1.equals(b3));
    }
}

