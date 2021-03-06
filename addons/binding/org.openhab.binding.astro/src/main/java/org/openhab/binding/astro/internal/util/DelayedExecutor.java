/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.astro.internal.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Schedules a task for later execution with the possibility to cancel it.
 * 
 * @author Gerhard Riegler - Initial contribution
 */
public class DelayedExecutor {
    private Timer timer;
    private TimerTask task;

    /**
     * Cancel the scheduled Task.
     */
    public void cancel() {
        if (task != null) {
            task.cancel();
            task = null;
        }
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    /**
     * Schedules a Task which starts after the specified delay.
     */
    public void schedule(TimerTask task, long delay) {
        this.task = task;
        timer = new Timer();
        timer.schedule(task, delay);
    }
}
