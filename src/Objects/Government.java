package Objects;

public enum Government {
    DESPOTISM,
    DIARCHY,
    NOOCRACY,
    OLIGARCHY,
    PLUTOCRACY;

    public static String Government() {
        StringBuilder nameList = new StringBuilder();
        for (var dragonType : values()) {
            nameList.append(dragonType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}