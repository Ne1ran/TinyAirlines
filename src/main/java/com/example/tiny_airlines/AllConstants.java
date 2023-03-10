package com.example.tiny_airlines;

public class AllConstants {

    public static class PassengerConsts {
        public static final String TABLE = "passenger";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PASSPORT = "passport_data";
        public static final String AGE = "age";
        public static final String PHONE = "phone_num";
        public static final String GENDER = "gender";
        public static final String DATE_OF_BIRTH = "date_of_birth";
        public static final String COUNTRY = "country";
        public static final String FLIGHT_ID = "flight_id";

    }

    public static class PlaneConsts {
        public static final String TABLE = "plane";
        public static final String ID = "id";
        public static final String MODEL = "model";
        public static final String TYPE = "type";
        public static final String CAPACITY = "capacity";
        public static final String PILOT = "pilot_name";

    }

    public static class FlightConsts {
        public static final String TABLE = "flight";
        public static final String ID = "id";
        public static final String PLANE_ID = "plane_id";
        public static final String START_DATE = "start_date";
        public static final String START_TIME = "start_time";
        public static final String LAND_DATE = "land_date";
        public static final String LAND_TIME = "land_time";
        public static final String START_LOCATION = "start_location";
        public static final String LAND_LOCATION = "land_location";
        public static final String TRACK = "start_track";
    }
    public static class AdminConsts{
        public static final String TABLE = "administrator";
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
        public static final String NAME = "name";
        public static final String PHONE_NUM = "phone_num";
    }
}
