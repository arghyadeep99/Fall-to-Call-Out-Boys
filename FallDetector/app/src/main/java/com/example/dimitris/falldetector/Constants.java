package com.example.dimitris.falldetector;

/**
 * Defines several constants used between {@link Accelerometer.class} and the UI.
 */
public interface Constants {

    // Message types sent from the Accelerometer Handler
    public static final int MESSAGE_CHANGED = 1;
    public static final int MESSAGE_EMERGENCY = 2;
    public static final int MESSAGE_TOAST = 3;

    // Key names received from the Accelerometer Handler
    public static final String VALUE = "value";
    public static final String TOAST = "toast";

    // Shared preferences keys
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Code = "codeKey";
    public static final String Phone = "phoneKey";
    public static final String History = "historyKey";


}
