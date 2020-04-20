/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author green
 */
public class Information {

    private String about;
    private String sortAbout;
    private String image;

    public Information() {

    }

    public Information(String about, String sortAbout, String image) {
        this.about = about;
        this.sortAbout = sortAbout;
        this.image = image;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSortAbout() {
        return sortAbout;
    }

    public void setSortAbout(String sortAbout) {
        this.sortAbout = sortAbout;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
