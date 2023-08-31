package com.utc.java;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.time.Duration;

public class TimestampConverter {
    public static void main(String[] args) {

    	String userDefinedTimestampStr = "2023-08-30T09:24:22Z";
        Instant userDefinedTimestamp = Instant.parse(userDefinedTimestampStr);
        Instant currentTimestamp = Instant.now();
        long timeDifferenceMilliseconds = Duration.between(userDefinedTimestamp, currentTimestamp).toMillis();

        String formattedDuration = convertToDaysHoursMinutesSeconds(timeDifferenceMilliseconds);
        
        System.out.println("Formatted Duration: " + formattedDuration);
        System.out.println("UTC time of given millisecond is: "+milliToUTCTimestamp(1690017862734L));
    }

    private static String convertToDaysHoursMinutesSeconds(long milliseconds) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60;
        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds) % 24;
        long days = TimeUnit.MILLISECONDS.toDays(milliseconds);

        StringBuilder formattedDuration = new StringBuilder();
        
        if (days > 0) {
            formattedDuration.append(days).append(" days, ");
        }
        if (hours > 0 || days > 0) {
            formattedDuration.append(hours).append(" hours, ");
        }
        if (minutes > 0 || hours > 0 || days > 0) {
            formattedDuration.append(minutes).append(" minutes, ");
        }
        formattedDuration.append(seconds).append(" seconds");

        return formattedDuration.toString();
    }
    
    private static String milliToUTCTimestamp(long milliseconds) {
    	Instant instant=Instant.ofEpochMilli(milliseconds);
    	return instant.toString();
    }
}