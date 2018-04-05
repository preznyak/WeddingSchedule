package hu.preznyak.weddingschedule.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Wedding entity class.
 *
 * @author Preznyák László
 * @version 1.0
 */

@Entity(name = "wedding")
@Table
public class Wedding {

    /**
     * The id of the {@link Wedding}.
     *
     */
    @GeneratedValue
    @Id
    private long id;

    /**
     * The name of the bride.
     */
    @Column
    private String brideName;

    /**
     * The name of the groom.
     */
    @Column
    private String groomName;

    /**
     * Date of the {@link Wedding}.
     */
    @Column
    private LocalDate date;

    /**
     * Locale of the {@link Wedding}.
     */
    @Column
    private String locale;

    /**
     * The name of the booked band for the {@link Wedding}.
     */
    @Column
    private String bandName;

    /**
     * The name of the booked foto&video service for the {@link Wedding}.
     */
    @Column
    private String fotoVideo;

    /**
     * {@link Contract} made with the software user.
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Contract.class, orphanRemoval=true)
    private Contract contract;

    /**
     * No-arg constructor for the {@link Wedding}.
     */
    public Wedding() {
    }

    /**
     * Constructor for the {@link Wedding} with paramters.
     * @param brideName the name of the bride.
     * @param groomName the name of the groom.
     * @param date date of the {@link Wedding}.
     * @param locale locale of the {@link Wedding}.
     * @param bandName the name of the booked band.
     * @param fotoVideo the name of the booked fotovideo service.
     * @param contract {@link Contract} with the user.
     */
    public Wedding(String brideName, String groomName, LocalDate date, String locale, String bandName, String fotoVideo, Contract contract) {
        this.brideName = brideName;
        this.groomName = groomName;
        this.date = date;
        this.locale = locale;
        this.bandName = bandName;
        this.fotoVideo = fotoVideo;
        this.contract = contract;
    }

    /**
     * Getter method for the id.
     * @return long the id of the {@link Wedding}.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for the id.
     * @param id The id of the {@link Wedding}.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for the bride's name.
     * @return String The name of the bride.
     */
    public String getBrideName() {
        return brideName;
    }

    /**
     * Setter method for the bride's name.
     * @param brideName The name of the bride.
     */
    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    /**
     * Getter method for the groom's name.
     * @return String The name of the groom.
     */
    public String getGroomName() {
        return groomName;
    }

    /**
     * Setter method for the groom's name.
     * @param groomName The name of the groom.
     */
    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    /**
     * Getter method for the date of the {@link Wedding}.
     * @return LocalDate The date of the {@link Wedding}.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setter method for the date of the {@link Wedding}.
     * @param date The date of the {@link Wedding}.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Locale of the {@link Wedding}.
     * @return String The locale of the {@link Wedding}.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Setter for the locale.
     * @param locale The locale of the {@link Wedding}.
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Getter method the band name.
     * @return String The name of the band.
     */
    public String getBandName() {
        return bandName;
    }

    /**
     * Setter method for the name of the band.
     * @param bandName The name of the band.
     */
    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    /**
     * Getter method for the fotovideo.
     * @return String The name of the fotovideo.
     */
    public String getFotoVideo() {
        return fotoVideo;
    }

    /**
     * Setter method for the fotovideo.
     * @param fotoVideo Tha name of the fotovideo service.
     */
    public void setFotoVideo(String fotoVideo) {
        this.fotoVideo = fotoVideo;
    }

    /**
     * Getter method for the {@link Contract}.
     * @return Contract the {@link Contract} associated with the {@link Wedding}.
     */
    public Contract getContract() {
        return contract;
    }

    /**
     * Setter method for the {@link Contract}.
     * @param contract the {@link Contract} associated with the {@link Wedding}.
     */
    public void setContract(Contract contract) {
        this.contract = contract;
    }

    /**
     * toString method for the {@link Wedding} object.
     * @return String The string format of a {@link Wedding} object.
     */
    @Override
    public String toString() {
        return "Wedding{" +
                "id=" + id +
                ", brideName='" + brideName + '\'' +
                ", groomName='" + groomName + '\'' +
                ", date=" + date +
                ", locale='" + locale + '\'' +
                ", bandName='" + bandName + '\'' +
                ", fotoVideo='" + fotoVideo + '\'' +
                ", contract=" + contract +
                '}';
    }
}
