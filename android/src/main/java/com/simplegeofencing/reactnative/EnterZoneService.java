package com.simplegeofencing.reactnative;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;

public class EnterZoneService extends HeadlessJsTaskService {
    @Override
    protected @Nullable
    HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras == null){
            extras = new Bundle();
        }
        Log.i("MonitorUpdate: extras", "remainingTime: " + extras.getInt("remainingTime"));
        return new HeadlessJsTaskConfig(
                "enterZone",
                Arguments.fromBundle(extras),
                extras.getInt("duration", 50000000), // timeout for the task
                true // optional: defines whether or not  the task is allowed in foreground. Default is false
        );

    }
}
