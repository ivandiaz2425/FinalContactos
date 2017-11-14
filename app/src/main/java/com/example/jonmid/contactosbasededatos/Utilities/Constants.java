package com.example.jonmid.contactosbasededatos.Utilities;

/**
 * Created by jonmid on 26/10/17.
 */

public class Constants {
    public static final String TABLA_NAME_USERS = "users";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_PHONE = "phone";
    public static final String TABLA_FIELD_EMAIL = "email";
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE "+ TABLA_NAME_USERS+" ("+
                TABLA_FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NAME+" TEXT, "+
                    TABLA_FIELD_PHONE+" TEXT, "+
                    TABLA_FIELD_EMAIL+" TEXT)";

    public static final String TABLA_NAME_COMMENTS = "comments";
    public static final String TABLA_FIELD_IDC = "id";
    public static final String TABLA_FIELD_TITLE = "title";
    public static final String TABLA_FIELD_COMMENT = "comment";
    public static final String TABLA_FIELD_IDUSER = "id_user";
    public static final String CREATE_TABLE_COMMENTS =
            "CREATE TABLE "+ TABLA_NAME_COMMENTS+" ("+
                    TABLA_FIELD_IDC+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_TITLE+" TEXT, "+
                    TABLA_FIELD_COMMENT+" TEXT, "+
                    TABLA_FIELD_IDUSER+" INTEGER)";
}
