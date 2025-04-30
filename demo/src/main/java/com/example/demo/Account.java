package com.example.demo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Account {
    String name;
    String email;
    String passwordHash;
    String tickets;




    /**
     * Hashes password
     * @param password
     * @return hash value of password
     */
    public static String hash(String password) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder retvalBuilder = new StringBuilder();
        for(byte b : hash)
        {
            retvalBuilder.append(String.format("%02x", b));
        }
        return retvalBuilder.toString();
    }




    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getpasswordHash()
    {
        return this.passwordHash;
    }

    public void setpasswordHash(String password)
    {
        try {
            this.passwordHash = hash(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    }

    public String getTickets()
    {
        return this.tickets;
    }

    public void setTickets(String tickets)
    {
        this.tickets = tickets;
    }
    
}
