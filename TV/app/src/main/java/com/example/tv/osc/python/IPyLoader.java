package com.example.tv.osc.python;

import java.util.Map;

public interface IPyLoader {
    void clear();
    void setConfig(String jsonStr);
    void setRecentPyKey(String pyApi);
    Spider getSpider(String key, String cls, String ext);
    Object[] proxyInvoke(Map<String, String> params);
}