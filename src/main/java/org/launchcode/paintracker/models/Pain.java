package org.launchcode.paintracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pain {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String location;

    @NotNull
    @Size(min=3, max=15)
    private String type;

    @NotNull
    @Size(min=3, max=15)
    private String intensity;

    @NotNull
    @Size(min=8, max=10)
    private String date;

    public Pain(String location, String type, String intensity, String date) {
        this.location = location;
        this.type = type;
        this.intensity = intensity;
        this.date = date;

        public int getId(){return id;}

        public String getLocation(){return location;}

        public void setLocation( String location){this.location = location;}

        public String getType() {return type;}

        public void setType (String type){this.type = type;}

        public String getIntensity() {return intensity;}

        public void setIntensity (String intensity){this.intensity = intensity;}

        public String getDate() {return date;}

        public void setDate (String date){this.date = date;}
    }