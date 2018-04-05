package hu.preznyak.weddingschedule.entity;

import javax.persistence.*;

/**
 * Contract entity class.
 *
 * @author Preznyák László
 * @version 1.0
 */

@Entity(name = "contract")
@Table
public class Contract {

    /**
     * The id of the {@link Contract}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The price for the {@link Contract}.
     */
    @Column(nullable = false)
    private double price;

    /**
     * The deposit for the {@link Contract}.
     */
    @Column
    private double deposit;

    /**
     * No-arg constructor for the {@link Contract}.
     */
    public Contract() {
    }

    /**
     * Contstructor with parameters for {@link Contract}.
     * @param price the price for the {@link Contract}.
     * @param deposit the deposit for the {@link Contract}.
     */
    public Contract(double price, double deposit) {
        this.price = price;
        this.deposit = deposit;
    }

    /**
     * Getter method for the id.
     * @return long The id of the {@link Contract}.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for the id.
     * @param id The id of the {@link Contract}.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getter method for the price.
     * @return double The covenanted price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for the price.
     * @param  price The covenanted price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter method for the deposit.
     * @return double The covenanted deposit.
     */
    public double getDeposit() {
        return deposit;
    }

    /**
     * Setter method for the deposit.
     * @param deposit The covenanted deposit.
     */
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    /**
     * toString method for the {@link Contract}.
     * @return String format of a {@link Contract} object.
     */
    @Override
    public String toString() {
        return "Price=" + price +
                ", deposit=" + deposit;
    }
}
