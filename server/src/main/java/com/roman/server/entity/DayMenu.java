package com.roman.server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.roman.server.util.DayEnum;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "daymenu")
public class
DayMenu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daymenu_id")
    private int id;


    @Column(name = "menuName",nullable = false)
    private String menuName;


    @Enumerated(EnumType.STRING)
    private DayEnum day;


    @Column(name = "price")
    private float price;


    @Column(name = "weight")
    private int weight;


    @Column(name = "glutenFree",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean glutenFree;


    @Column(name = "isVegan",nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isVegan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_meal_id")
    @JsonManagedReference
    private MainMeal mainMeal;

    public MainMeal getMainMeal() {
        return mainMeal;
    }

    public void setMainMeal(MainMeal mainMeal) {
        this.mainMeal = mainMeal;
    }

    @OneToMany(
            mappedBy = "dayMenu",
            cascade = {CascadeType.ALL},
            orphanRemoval = true)
    private List<Soup> soupList = new ArrayList<>();


    public DayMenu(){

    }


    public DayMenu(String menuName, DayEnum day, float price, int weight, boolean glutenFree, boolean isVegan) {
        this.menuName = menuName;
        this.day = day;
        this.price = price;
        this.weight = weight;
        this.glutenFree = glutenFree;
        this.isVegan = isVegan;
    }


    public void addSoup(Soup soup){
        if(soupList == null){
            soupList = new ArrayList<>();
        }
        soupList.add(soup);

        soup.setDayMenu(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public DayEnum getDay() {
        return day;
    }

    public void setDay(DayEnum day) {
        this.day = day;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public List<Soup> getSoupList() {
        return soupList;
    }

    public void setSoupList(List<Soup> soupList) {
        this.soupList = soupList;
    }


    @Override
    public String toString() {
        return "DayMenu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", day=" + day +
                ", price=" + price +
                ", weight=" + weight +
                ", glutenFree=" + glutenFree +
                ", isVegan=" + isVegan +
                ", mainMeal=" + mainMeal +
                '}';
    }
}
