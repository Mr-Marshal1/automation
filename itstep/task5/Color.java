package itstep.task5;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Color implements Serializable, Comparable {
    private List<String> colors;
    @JsonProperty("isPrimary")
    private boolean primary;
    private HashMap<String,Integer> rgb = new HashMap<String,Integer>();


    public Color(){};
    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public boolean GetIsPrimary() {
        return primary;
    }

    public void setIsPrimary(boolean primary) {
        this.primary = primary;
    }

    public HashMap<String, Integer> getRgb() {
        return rgb;
    }

    public void setRgb(HashMap<String, Integer> rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "Color{" +
                "colors=" + colors +
                ", isPrimary=" + primary +
                ", rgb=" + rgb +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Color other = (Color) o;
        return Boolean.compare(this.primary, other.primary);
    }
}