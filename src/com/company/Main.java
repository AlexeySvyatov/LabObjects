package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Reader people = new Reader();
        System.out.print("ФИО: ");
        Reader.fio = input.nextLine();
        System.out.print("Номер читательского билета: ");
        people.rnum = input.nextInt();
        System.out.print("Факультет: ");
        people.fac = input.nextLine();
        input.nextLine();
        System.out.print("Дата рождения: ");
        people.date = input.nextLine();
        System.out.print("Номер телефона: ");
        people.phone = input.nextLine();
        System.out.println("Чтобы взять книгу нужно ввести любой символ, а чтобы сдать нажмите enter");
        String action = input.nextLine();

        if (action.isEmpty()) {
            System.out.println("Количество книг, которые нужно вернуть: ");
            int quant = input.nextInt();
            String[] booknames = new String[quant];
            String temp = null;
            System.out.println("Название книг/книги: ");
            for (int i = 0; i < quant; i++) {
                System.out.printf("Нужно ввести %s книг: ", quant - i);
                if (i == 0) {
                    input.nextLine();
                }
                temp = input.nextLine();
                booknames[i] = temp;
                if (temp.isEmpty()) {
                    break;
                }}

            assert temp != null;
            if (temp.isEmpty()) {
                Reader.returnBook(quant);
            } else {
                Reader.returnBook(quant, booknames);
            }

        } else {

            System.out.println("Количество книг, которые взяли ");
            int quant = input.nextInt();
            String[] booknames = new String[quant];
            String temp = null;
            System.out.println("Книгу/книги (не обезательно): ");
            for (int i = 0; i < quant; i++) {
                System.out.printf("Нужно ввести %s книг: ", quant - i);
                if (i == 0) {
                    input.nextLine();
                }
                temp = input.nextLine();
                booknames[i] = temp;
                if (temp.isEmpty()) {
                    break;
                }}

            assert temp != null;
            if (temp.isEmpty()) {
                Reader.takeBook(quant);
            } else {
                Reader.takeBook(quant, booknames);
            }}}

    static class Reader{
        private static Object fio;
        int age;
        int rnum;
        String fac;
        String date;
        String phone;

        public static void takeBook(int num) {
            System.out.printf("%s взял(а) книг %d ", fio, num);
        }

        public static void takeBook(int num, String[] books) {
            if (books.length > 1) {
                System.out.printf("%s взял(а) книги: ", fio);
                for (int i = 0; i < books.length; i++) {
                    if (i == books.length - 1){
                        System.out.print(books[i] + "");
                    } else {
                        System.out.print(books[i] + ", ");
                    }}} else {
                System.out.printf("%s взял(а) книгу: %s", fio, books[0]);
            }}

        public static void returnBook(int num) {
            System.out.printf("%s вернул(а) книг %d ", fio, num);
        }

        public static void returnBook(int num, String[] books) {
            if (books.length > 1) {
                System.out.printf("%s вернул(а) книги: ", fio);
                for (int i = 0; i < books.length; i++) {
                    if (i == books.length - 1){
                        System.out.print(books[i] + "");
                    }else{
                        System.out.print(books[i] + ", ");
                    }}
            }else{
                System.out.printf("%s вернул(а) книгу: %s", fio, books[0]);
            }}}}