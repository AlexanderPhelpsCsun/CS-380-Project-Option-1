package com.example.demo;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Account {
    String name;
    String email;
    String password;
    String passwordHash;
    String tickets;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Hashes password
     * @param password
     * @return hash value of password
     */
    public static String hash(String password) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
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
    

    public static Account login(String email, String password)
    {
        Account stored = database.findAccount(email);
        if(stored == null)
        {
            return null;
        }
        try {
            String inputHash = hash(password);
            if(inputHash.equals(stored.getpasswordHash()))
            {
                return stored;
            }
        } catch (NoSuchAlgorithmException e) {
            // handle error
            System.out.println("Hashing failed: " + e.getMessage());
        }
        return null;
    }

    


}
