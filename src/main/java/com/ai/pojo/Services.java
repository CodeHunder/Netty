package com.ai.pojo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

interface Service {
}

interface Provider {
    Service newService();
}

/**
 * @Author ZINING
 * @Date 2017/12/2 12:02
 */
public class Services {
    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) throw new IllegalArgumentException("No provider registered with name:" + name);
        return p.newService();
    }

    public static void main(String[] args) {

    }

}
