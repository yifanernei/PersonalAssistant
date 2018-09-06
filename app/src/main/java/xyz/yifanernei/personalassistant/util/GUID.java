package xyz.yifanernei.personalassistant.util;

import java.util.UUID;

public class GUID {
    static public String generant()
    {
        return UUID.randomUUID().toString();
    }
}
