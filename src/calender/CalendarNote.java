/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calender;

import java.util.Date;

public class CalendarNote {
    private String creatorName;  // Ubah ke name
    private String taggedName;   // Ubah ke name
    private Date date;
    private String note;

    public CalendarNote( String creatorName, String taggedName, Date date, String note) {
        this.creatorName = creatorName;
        this.taggedName = taggedName;
        this.date = date;
        this.note = note;
    }

    // Getter dan Setter
    

    public String getCreatorName() {
        return creatorName;
    }

    public String getTaggedName() {
        return taggedName;
    }

    public Date getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }
}

