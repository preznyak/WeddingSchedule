package hu.preznyak.weddingschedule.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "wedding")
@Table
public class Wedding {

    @GeneratedValue
    @Id
    private long id;

    @Column
    private String brideName;

    @Column
    private String groomName;

    @Column
    private LocalDate date;

    @Column
    private String locale;

    @Column
    private String bandName;

    @Column
    private String fotoVideo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Contract.class, orphanRemoval=true)
    private Contract contract;

    public Wedding() {
    }

    public Wedding(String brideName, String groomName, LocalDate date, String locale, String bandName, String fotoVideo, Contract contract) {
        this.brideName = brideName;
        this.groomName = groomName;
        this.date = date;
        this.locale = locale;
        this.bandName = bandName;
        this.fotoVideo = fotoVideo;
        this.contract = contract;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getGroomName() {
        return groomName;
    }

    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getFotoVideo() {
        return fotoVideo;
    }

    public void setFotoVideo(String fotoVideo) {
        this.fotoVideo = fotoVideo;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

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
