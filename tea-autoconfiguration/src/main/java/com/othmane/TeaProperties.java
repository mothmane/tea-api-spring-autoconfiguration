package com.othmane;

import com.othmane.services.Temperature;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tea.api")
public class TeaProperties {
    /**
     * this property define the type of tea
     */
    private String type="green";
    private Temperature temperature=Temperature.HOT;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
