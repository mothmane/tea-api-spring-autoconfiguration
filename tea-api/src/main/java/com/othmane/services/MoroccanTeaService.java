package com.othmane.services;


import com.othmane.services.exceptions.InvalidTeaCombinationException;

public class MoroccanTeaService implements TeaService {

    private String type = "Green";

    private Temperature temperature = Temperature.HOT;

    // Not Used but it's a moroccan tea
    private boolean ne3na3 = true;

    public MoroccanTeaService() {
    }

    public MoroccanTeaService(String type, Temperature temperature) {
        this.checkValues(type,temperature);
        this.type = type;
        this.temperature = temperature;
    }

    public void checkValues(String type, Temperature temperature){

        if("Black".equalsIgnoreCase(type) && Temperature.COLD==temperature){
            throw new InvalidTeaCombinationException(type,temperature);
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setNe3na3(boolean ne3na3) {
        this.ne3na3 = ne3na3;
    }

    public String drink() {
        return "i'm drinking this beautifull " + type + " moroccan " + temperature + " tea";
    }


}
