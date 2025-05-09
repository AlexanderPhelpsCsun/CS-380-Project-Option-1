/**
 * Class Name: Traveler
 * Date: April 14, 2025
 * Programmer: Valerie Chavez
 *
 * Description:
 * This class models a traveler in the flight reservation system. Each traveler has
 * a unique ID, name, email, and phone number. This class is used to create, store,
 * and retrieve traveler information from the database using Java and JDBC.
 *
 * Important Methods:
 * - Constructors: Used to create new traveler objects.
 * - Getters and Setters: Allow access and modification of traveler fields.
 *
 * Data Structures:
 * - Basic member variables representing traveler fields.
 *
 * Algorithms Used:
 * - None; this class is purely for data modeling.
 *
 * @author Valerie Chavez
 */
public class Traveler {
    // === Properties ===
    private int travelerID;
    private String name;
    private String email;
    private String phone;

    // === Constructors ===

    /**
     * Default constructor.
     */
    public Traveler() {}

    /**
     * Parameterized constructor to initialize a traveler.
     *
     * @param travelerID the unique ID of the traveler (optional when inserting new records)
     * @param name the name of the traveler
     * @param email the traveler's email address
     * @param phone the traveler's phone number
     */
    public Traveler(int travelerID, String name, String email, String phone) {
        this.travelerID = travelerID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // === Getter and Setter Methods ===

    /**
     * Gets the traveler's ID.
     *
     * @return the traveler's ID
     */
    public int getTravelerID() {
        return travelerID;
    }

    /**
     * Sets the traveler's ID.
     *
     * @param travelerID the traveler's ID to set
     */
    public void setTravelerID(int travelerID) {
        this.travelerID = travelerID;
    }

    /**
     * Gets the traveler's name.
     *
     * @return the traveler's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the traveler's name.
     *
     * @param name the traveler's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the traveler's email.
     *
     * @return the traveler's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the traveler's email.
     *
     * @param email the traveler's email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the traveler's phone number.
     *
     * @return the traveler's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the traveler's phone number.
     *
     * @param phone the traveler's phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // === Optional: Display Method ===

    /**
     * Prints traveler details in a readable format.
     */
    public void printTravelerInfo() {
        System.out.println("Traveler ID: " + travelerID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}
