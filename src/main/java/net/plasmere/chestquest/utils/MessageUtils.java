package net.plasmere.chestquest.utils;

import java.util.Map;

public class MessageUtils {

    private static Map<String, String> messages;
    private static boolean hasRegistered = false;

    public static String getMessage(String key) {
        if (!hasRegistered) registerMessages();
        return messages.get(key);
    }

    private static void registerMessages() {
        registerMessage("example-message", "&7Hello!");

        hasRegistered = true;
    }

    private static void registerMessage(String key, String message) {
        messages.put(key, message);
    }

}
