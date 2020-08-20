package com.roman.server.entity;
import javax.persistence.*;


@Entity
@Table(name = "soup")
public class Soup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "soupName")
    private String soupName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dayMenuId")
    private DayMenu dayMenu;

    public Soup(){

    }

    public Soup(String soupName) {
        this.soupName = soupName;
    }

    public DayMenu getDayMenu() {
        return dayMenu;
    }

    public void setDayMenu(DayMenu dayMenu) {
        this.dayMenu = dayMenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoupName() {
        return soupName;
    }

    public void setSoupName(String soupName) {
        this.soupName = soupName;
    }

    @Override
    public String toString() {
        return "Soup{" +
                "id=" + id +
                ", soupName='" + soupName + '\'' +
                ", dayMenu=" + dayMenu +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
