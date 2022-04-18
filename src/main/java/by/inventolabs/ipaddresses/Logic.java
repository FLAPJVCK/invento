package by.inventolabs.ipaddresses;

public class Logic {
    private final static int MAX_IP_POWER = 3;
    private final static int MAX_LENGTH_OCTET = 8;
    private final static int FIRST_OCTET_LENGTH = 24;
    private final static int SECOND_OCTET_LENGTH = 16;
    private final static int THIRD_OCTET_LENGTH = 8;
    private final static int MAX_OCTET_VALUE = 0xFF;
    private final static String DELIMITER = ".";

    static long ipToInt(String ip) {
        String[] ipArray = ip.split("\\.");
        long result = 0;

        for (int i = MAX_IP_POWER; i >= 0; i--) {
            long octet = Long.parseLong(ipArray[MAX_IP_POWER - i]);
            result |= octet << (i * MAX_LENGTH_OCTET);
        }
        return result;
    }

    static String intToIp(long ip) {
        return (ip >> FIRST_OCTET_LENGTH) + DELIMITER
                + ((ip >> SECOND_OCTET_LENGTH) & MAX_OCTET_VALUE) + DELIMITER
                + ((ip >> THIRD_OCTET_LENGTH) & MAX_OCTET_VALUE) + DELIMITER
                + (ip & MAX_OCTET_VALUE);
    }
}
