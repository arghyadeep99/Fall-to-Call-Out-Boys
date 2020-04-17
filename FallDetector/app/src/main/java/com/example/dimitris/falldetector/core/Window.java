package com.example.dimitris.falldetector.core;

import java.util.Collections;
import java.util.LinkedList;

public class Window {
    public static final String TAG = "Window.java";

    private final int DEFAULT_SIZE = 10;
    private final float THRESHOLD =  8f;

    private final int SIZE;

    LinkedList<Float> samples;

    public Window (){
        SIZE = DEFAULT_SIZE;
        samples = new LinkedList<Float>();
    }

    public Window (int size){
        SIZE = size;
        samples = new LinkedList<Float>();
    }

    public void add(float value){
        if (!isFull()){
            samples.add(new Float(value));
            //add value
        } else {
            samples.removeFirst();
            samples.add(new Float(value));
        }
    }

    public void clear(){
        samples.clear();
    }

    public Boolean isFull(){
        return (samples.size() > SIZE);
    }

    public Boolean isFallDetected(){
        Float max = Collections.max(samples);
        Float min = Collections.min(samples);
        Float diff = Math.abs(max-min);

        // check if min value detected earlier than max
        Boolean isFall = ( samples.indexOf(max) > samples.indexOf(min) );

        return (diff>THRESHOLD && isFall);
    }



}
