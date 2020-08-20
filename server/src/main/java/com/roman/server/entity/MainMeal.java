package com.roman.server.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;


@Entity
@Table(name = "mainmeal")
public class MainMeal {


    @OneToOne(mappedBy = "mainMeal")
    @JsonBackReference
    private DayMenu dayMenu;

    public DayMenu getDayMenu() {
        return dayMenu;
    }

    public void setDayMenu(DayMenu dayMenu) {
        this.dayMenu = dayMenu;
    }

    public MainMeal(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mealName")
    private String mealName;

    public MainMeal(String mealName) {
        this.mealName = mealName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "MainMeal{" +
                "dayMenu=" + dayMenu +
                ", id=" + id +
                ", mealName='" + mealName + '\'' +
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
