package kg.kgiai.dekanat.rest_api.model;

public enum  Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public String getName() {
        switch (this) {
            case MONDAY: return "ПОНЕДЕЛЬНИК";
            case TUESDAY: return "Вторник".toUpperCase();
            case WEDNESDAY: return "Среда".toUpperCase();
            case THURSDAY: return "Четверг".toUpperCase();
            case FRIDAY: return "Пятница".toUpperCase();
            case SATURDAY: return "Суббота".toUpperCase();
            default: return "Воскресенье".toUpperCase();
        }
    }

    public String[] getAll() {
        String[] res = new String[Weekday.values().length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Weekday.values()[i].getName();
        }
        return res;
    }
}
