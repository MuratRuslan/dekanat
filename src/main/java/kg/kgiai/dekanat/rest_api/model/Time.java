package kg.kgiai.dekanat.rest_api.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum Time {
    first, second, third, fourth, fifth, sixth, seventh, eighth, zero;

    @Override
    public String toString() {
        switch (this) {
            case first: return "8:00";
            case second: return "9:30";
            case third: return "11:00";
            case fourth: return "12:30";
            case fifth: return "14:00";
            case sixth: return "15:30";
            case seventh: return "17:00";
            case eighth: return "18:30";
            default: return  "00:00";
        }
    }

    public Date getTime() {
        try {
            DateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.parse(this.toString());
        }catch (ParseException e) {
        }
        return new Date();
    }

    public Time getTime(Date time) {
        for(Time t : values()) {
            if(time.equals(t.getTime())) {
                return t;
            }
        }
        return null;
    }
}
