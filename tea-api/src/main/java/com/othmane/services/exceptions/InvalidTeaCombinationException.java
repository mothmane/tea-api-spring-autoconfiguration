package com.othmane.services.exceptions;

import com.othmane.services.Temperature;

public class InvalidTeaCombinationException extends  RuntimeException {
    private String type;
    private Temperature temperature;

    public InvalidTeaCombinationException(String type, Temperature temperature){
        this.type=type;
        this.temperature=temperature;
    }

    public String getType() {
        return type;
    }

    public Temperature getTemperature() {
        return temperature;
    }

}
