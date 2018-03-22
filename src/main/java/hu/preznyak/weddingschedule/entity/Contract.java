package hu.preznyak.weddingschedule.entity;

import javax.persistence.*;

@Entity(name = "contract")
@Table
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private double price;

    @Column
    private double deposit;

    public Contract() {
    }

    public Contract(double price, double deposit) {
        this.price = price;
        this.deposit = deposit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", price=" + price +
                ", deposit=" + deposit +
                '}';
    }
}
