/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class BookProvider {
    private Scanner scanner = new Scanner(System.in);
    public Book createBook() {
        Book book = new Book();
        System.out.println("-------Создание книги--------");
        System.out.print("Идентификатор книги: ");
        book.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Название книги: ");
        book.setName(scanner.nextLine());
        System.out.print("Автор книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("ISBN книги: ");
        book.setIsbn(scanner.nextLine());
        System.out.print("Год издания книги: ");
        book.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        return book;
    }
    
}
