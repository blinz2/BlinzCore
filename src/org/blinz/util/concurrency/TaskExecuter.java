/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2009  BlinzProject <gtalent2@gmail.com>
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
 * A ParallelProcess that takes Tasks to execute in manners defined by the classes
 * the extend.
 * @author Blinz
 */
public final class TaskExecuter extends ParallelProcess {

    private TaskList list = new TaskList();
    private Barrier barrier = new Barrier();

    public TaskExecuter(int threads) {
        this("TaskExecuter", threads);
    }

    public TaskExecuter(String name, int threads) {
        super(name, threads);
        list.init(this);
        barrier.init(this);
    }

    /**
     * Adds the given Task to this TaskExecuter to be executed in the future.
     * @param task
     */
    public final void addTask(Task task) {
        list.add(task);
    }

    /**
     * Removes the given Task and it will no longer be executed in the future.
     * @param task
     */
    public final void removeTask(Task task) {
        list.remove(task);
    }

    @Override
    protected final void update() {
        list.prepare();
        barrier.enter();
        list.enter();
    }
}
