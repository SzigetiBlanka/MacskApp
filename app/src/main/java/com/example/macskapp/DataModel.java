package com.example.macskapp;

public class DataModel {

        String name;
        String type;
        String description;
        String contact;

        public DataModel(String name, String type, String description, String contact ) {
            this.name=name;
            this.type=type;
            this.description=description;
            this.contact=contact;

        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getDescription() {
            return description;
        }

        public String getContact() {
            return contact;
        }

    }
