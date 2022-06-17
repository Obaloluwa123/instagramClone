package com.codepath.oobal.Instagram;

import android.util.Log;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;

    //@Parcel
    @ParseClassName("Post")
    public class Post extends ParseObject {
        public static final String KEY_DESCRIPTION = "Description";
        public static final String KEY_IMAGE = "Image";
        public static final String KEY_USER = "User";
        public static final String KEY_CREATED_AT = "createdAt";



        public Post(){}

        public String getDescription(){

            return getString(KEY_DESCRIPTION);
        }

        public void setDescription(String description){

            put(KEY_DESCRIPTION, description);
        }

        public ParseFile getImage(){

            return getParseFile(KEY_IMAGE);
        }

        public void setImage(ParseFile image){

            put(KEY_IMAGE, image);
        }

        public ParseUser getUser(){

            return getParseUser(KEY_USER);
        }

        public void setUser(ParseUser user){

            put(KEY_USER, user);
        }

        public  String calculateTimeAgo() {

            int SECOND_MILLIS = 1000;
            int MINUTE_MILLIS = 60 * SECOND_MILLIS;
            int HOUR_MILLIS = 60 * MINUTE_MILLIS;
            int DAY_MILLIS = 24 * HOUR_MILLIS;

            try {
                Date createdAt=getCreatedAt();
                long time = createdAt.getTime();
                long now = System.currentTimeMillis();

                final long diff = now - time;
                if (diff < MINUTE_MILLIS) {
                    return "just now";
                } else if (diff < 2 * MINUTE_MILLIS) {
                    return "a minute ago";
                } else if (diff < 50 * MINUTE_MILLIS) {
                    return diff / MINUTE_MILLIS + " m";
                } else if (diff < 90 * MINUTE_MILLIS) {
                    return "an hour ago";
                } else if (diff < 24 * HOUR_MILLIS) {
                    return diff / HOUR_MILLIS + " hour";
                } else if (diff < 48 * HOUR_MILLIS) {
                    return "yesterday";
                } else {
                    return diff / DAY_MILLIS + " days ago";
                }
            } catch (Exception e) {
                Log.i("Error:", "getRelativeTimeAgo failed", e);
                e.printStackTrace();
            }

            return "";
        }

    }

