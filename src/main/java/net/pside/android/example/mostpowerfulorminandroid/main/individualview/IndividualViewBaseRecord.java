/*
 * IndividualViewBaseRecord.java
 *
 * GENERATED FILE - DO NOT EDIT
 * CHECKSTYLE:OFF
 * 
 */



package net.pside.android.example.mostpowerfulorminandroid.main.individualview;

import org.dbtools.android.domain.AndroidBaseRecord;
import android.database.Cursor;
import android.content.ContentValues;


@SuppressWarnings("all")
public abstract class IndividualViewBaseRecord extends AndroidBaseRecord {

    public static final String DATABASE = "main";
    public static final String TABLE = "INDIVIDUAL_VIEW";
    public static final String FULL_TABLE = "main.INDIVIDUAL_VIEW";
    public static final String C_ID = "id";
    public static final String FULL_C_ID = "INDIVIDUAL_VIEW.id";
    private long id = 0;
    public static final String C_NAME = "NAME";
    public static final String FULL_C_NAME = "INDIVIDUAL_VIEW.NAME";
    private String name = "";
    public static final String[] ALL_KEYS = new String[] {
        C_ID,
        C_NAME};

    public IndividualViewBaseRecord() {
    }

    public static long getId(Cursor cursor) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(C_ID));
    }

    public static String getName(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(C_NAME));
    }

    @Override
    public String getIdColumnName() {
        return null;
    }

    @Override
    public long getPrimaryKeyId() {
        return 0;
    }

    @Override
    public void setPrimaryKeyId(long id) {
    }

    @Override
    public String[] getAllKeys() {
        return ALL_KEYS.clone();
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(C_ID, id);
        values.put(C_NAME, name);
        return values;
    }

    @Override
    public Object[] getValues() {
        Object[] values = new Object[]{
            id,
            name,
        };
        return values;
    }

    public void setContent(ContentValues values) {
        id = values.getAsLong(C_ID);
        name = values.getAsString(C_NAME);
    }

    @Override
    public void setContent(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndexOrThrow(C_ID));
        name = cursor.getString(cursor.getColumnIndexOrThrow(C_NAME));
    }

    public boolean isNewRecord() {
        return getPrimaryKeyId() <= 0;
    }

    public long getId() {
        return id;
    }

    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }


}