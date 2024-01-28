/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package football.tournament.of.antiparos;

public class Player {

    private int id;
    private String name;
    private String surname;
    private int goals;
    private int assists;

    public Player(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.goals = 0;
        this.assists = 0; 
        this.id = -1;
    }
    
    public Player(String name, String surname, int goals, int assists, int id){
        this.name = name;
        this.surname = surname;
        this.goals = goals;
        this.assists = assists; 
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
