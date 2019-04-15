/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr17library;

import providers.ReaderProvider;
import entity.Book;
import entity.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import providers.BookProvider;

/**
 *
 * @author Melnikov
 */
public class App {
    private List<Book> listBooks = new ArrayList<>();
    private List<Reader> listReaders = new ArrayList<>();
    private StoregeInFile storegeInFile;
    public App() {
       storegeInFile = new StoregeInFile();
       try {
           listBooks = storegeInFile.loadBookFromFile();
       }catch (Exception e) {
           System.out.println("Нет файла Books.txt");
       }
       
       try {
           listReaders = storegeInFile.loadReaderFromFile();
       }catch (Exception e) {
           System.out.println("Нет файла Readers.txt");
       }

    }
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Наша библиотека ----");
        String repeat = "r";
        int operation;
        do{
            System.out.println("Выберите действие:");
            System.out.println("1. Создать книгу");
            System.out.println("2. Создать читателя");
            System.out.println("3. Выдать книгу читателю");
            System.out.println("4. Читатель возвращает книгу");
            System.out.println("5. Вывести список книг");
            operation = scanner.nextInt();
            scanner.nextLine();
            switch (operation) {
                case 1:
                    BookProvider bookProvider = new BookProvider();
                    listBooks.add(bookProvider.createBook());
                    storegeInFile.saveBooks(listBooks);
                    for(int i=0; i < listBooks.size();i++){
                       System.out.println(
                            "Список книг: " 
                            + listBooks.get(i).getName()
                        ); 
                    }
                    break;
                case 2:
                    ReaderProvider readerProvider = new ReaderProvider();
                    listReaders.add(readerProvider.createReader());
                    storegeInFile.saveReaders(listReaders);
                    for(int i=0; i < listReaders.size();i++){
                       System.out.println(
                            "Список читателей: " 
                            + listReaders.get(i).getName()
                        ); 
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("Список книг: ");
                    for(int i=0;i<listBooks.size();i++){
                        System.out.println(listBooks.get(i));
                    }
                    break;    
                default:
                    System.out.println("Такое действие неподдерживается");
                    continue;
            }
            System.out.println("Для продолжения программы");
            System.out.println("введите \"r\"");
            System.out.println("Для окончания \"q\"");
            repeat = scanner.nextLine();
        }while("r".equals(repeat));
        System.out.println("Программа закрывается");
    }
    
}
