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
        String inputNumber = "";
        Long id = null;
        boolean flag = true;
        do{
           System.out.print("Идентификатор книги: ");
           inputNumber = scanner.nextLine();
           try {
              id=new Long(inputNumber);
              flag = false;
           }catch (Exception e){
               System.out.println("Ошибка ввода!");
           }
        }while(flag);
        book.setId(id);
        System.out.print("Название книги: ");
        book.setName(scanner.nextLine());
        System.out.print("Автор книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("ISBN книги: ");
        book.setIsbn(scanner.nextLine());
        int year=0;
        flag=true;
        do{
           System.out.print("Год издания книги: ");
           inputNumber = scanner.nextLine();
           try {
              year=new Integer(inputNumber);
              flag = false;
           }catch (Exception e){
               System.out.println("Ошибка ввода!");
           }
        }while(flag);
        book.setPublishedYear(year);
        return book;
    }
    
}
