// IBookManager.aidl
package com.example.server;

// Declare any non-default types here with import statements
import com.example.server.Book;
interface IBookManager {
   List<Book> getBookList();
   void addBook(in Book book);
}
