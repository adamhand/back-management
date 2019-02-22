package com.commons;

public interface Constant {
    String IPADDRESS = "127.0.0.1";
    int PORT = 5672;
    String VIRTUALHOST = "/";
    String USERNAME = "root";
    String PASSWORD = "root";
    String QUEUE_NAMES = "adamhand.order.add";
    String EXCHANGE_NAMES = "adamhand.order";
    String ROUTING_KEY = "add";
    int CONSUMER_NUMBER = 5;
    int MAX_CONSUMER_NUMBER = 10;

    String CONTENT_TYPE_TEXT = "text/plain";
    String CONTENT_TYPE_JSON = "application/json";
    String CONTENT_TYPE_IMAGE = "image/jpg";

    double LIMITE_RATE = 1000;

    String BOOK_ID_1 = "1";
    String BOOK_ID_2 = "2";
    String BOOK_ID_3 = "3";
    String BOOK_ID_4 = "4";
    String BOOK_ID_5 = "5";
    String BOOK_ID_6 = "6";
    String BOOK_ID_7 = "7";
    String BOOK_ID_8 = "8";
    String BOOK_ID_9 = "9";
    String BOOK_ID_10 = "10";
    String BOOK_STOCK_INIT = "10000";
}
