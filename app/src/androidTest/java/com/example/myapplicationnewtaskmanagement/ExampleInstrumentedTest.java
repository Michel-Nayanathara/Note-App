package com.example.myapplicationnewtaskmanagement;

import android.app.Instrumentation;
import android.content.Context;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public final class ExampleInstrumentedTest {
    @Test
    public final void useAppContext() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Context appContext = instrumentation.getTargetContext();
        Assert.assertEquals("com.example.myapplicationnewtaskmanagement", appContext.getPackageName());
    }
}
