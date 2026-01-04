package com.example.tv.osc.python;

import android.util.Log;


import java.util.Map;

public class pyLoader implements IPyLoader {

    @Override
    public void clear() {
        Log.i("PyLoader", "normal flavor: clear() 调用，但不支持 Python 功能。");
    }

    @Override
    public void setConfig(String jsonStr) {
        Log.i("PyLoader", "normal flavor: setConfig() 调用，但不支持 Python 功能。");
    }

    @Override
    public void setRecentPyKey(String pyApi) {
        Log.i("PyLoader", "normal flavor: setRecentPyKey() 调用，但不支持 Python 功能。");
    }

    @Override
    public Spider getSpider(String key, String cls, String ext) {
        Log.i("PyLoader", "normal flavor: getSpider() 调用，但不支持 Python 功能。");
        return new SpiderNull();
    }

    @Override
    public Object[] proxyInvoke(Map<String, String> params) {
        Log.i("PyLoader", "normal flavor: proxyInvoke(params) 调用，但不支持 Python 功能。");
        return null;
    }
}
