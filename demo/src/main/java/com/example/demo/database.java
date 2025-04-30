package com.example.demo;
import java.util.List;
import java.util.ArrayList;


public class database {

        static List<Flight> flights = Flight.getAvailableFlights();
        static List<Account> Accounts = new ArrayList<>();

        public static void addAccount(Account account) {
            Accounts.add(account);
        }
}
