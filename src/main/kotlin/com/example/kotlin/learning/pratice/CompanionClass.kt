package com.example.kotlin.learning.pratice

class Book private constructor(val id : Int, val name : String) {

    // private class 나 method를 읽을 수 있도록 하는 companion object, Java의 static
    // private constructor으로 생성하는 class는 companion object 없이 객체를 생성할 수 없다.
    companion object BookFactory : IdProvider{ // 이름 생략 가능 (BookFactory), 이름을 넣는 순간 객체 생성시 Companion 선언 대신 생성한 이름으로 사용
        val myBook = "new book"
        fun create() = Book(getId(), myBook)

        override fun getId(): Int {
            return 55;
        }
    }

}

interface IdProvider {
    fun getId() : Int;
}

fun main(){
    val book = Book.create(); // Book.Companion.create 로 사용가능, Companion이 생략 가능하다.
    println("${book.id} ${book.name}")

    val bookId = Book.BookFactory.getId();
    println("$bookId")
}