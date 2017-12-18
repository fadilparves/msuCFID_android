package com.example.fadil.msucfid;

/**
 * Created by fadil on 17/12/2017.
 */

public class PersonalNote {
    int _id;
    String title, body, content_id;

    public PersonalNote(){

    }

    public PersonalNote(int i, String string, String cursorString){}

    public PersonalNote(int id, String title, String body, String content_id) {
        this._id = id;
        this.title = title;
        this.body = body;
        this.content_id = content_id;
    }

    public PersonalNote(String title, String body, String content_id){
        this.title = title;
        this.body = body;
        this.content_id = content_id;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }
}
