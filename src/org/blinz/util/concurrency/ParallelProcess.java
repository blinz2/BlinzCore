/*
 *  BlinzEngine - A library for large 2D world simultions and games.
 *  Copyright (C) 2009  Blinz <gtalent2@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 3 as
 *  published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.blinz.util.concurrency;

/**
 * Contains an update method that is executed by however many threads there are
 * processors on the system.
 *
 * If you don't know how many processors your system has run
 * "Runtime.getRuntime().availableProcessors();".
 *
 * @author Blinz
 */
public abstract class ParallelProcess {

    private TaskExecuter[] threads;
    private boolean isRunning = true;
    private ThreadGroup group;

    ParallelProcess(String threadName, int threadCount) {
        group = new ThreadGroup(threadName);
        threads = new TaskExecuter[threadCount];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new TaskExecuter(this, group);
        }
    }

    ParallelProcess(int threadCount) {
        this("Task", threadCount);
    }

    /**
     *
     * @return the number of threads dedicated to processing this TaskProcessor
     */
    final int getThreadCount() {
        return threads.length;
    }

    /**
     * Starts this Task.
     */
    void start() {
        isRunning = true;
        for (TaskExecuter t : threads) {
            t.start();
        }
    }

    /**
     * Tells the threads to stop updating after the current cycle.
     */
    void stop() {
        isRunning = false;
    }

    abstract void update();

    private class TaskExecuter extends Thread {

        private ParallelProcess task;

        TaskExecuter(ParallelProcess t, ThreadGroup group) {
            super(group, group.getName());
            task = t;
        }

        @Override
        public void run() {
            while (task.isRunning) {
                task.update();
            }
        }
    }
}
