/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blinz.util.concurrency;

/**
 * A ParallelProcess that takes Tasks to execute in manners defined by the classes
 * the extend.
 * @author Blinz
 */
public final class TaskExecuter extends ParallelProcess {

    private TaskList list = new TaskList();

    public TaskExecuter(int threads) {
        this("TaskExecuter", threads);
    }

    public TaskExecuter(String name, int threads) {
        super(name, threads);
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
    final void update() {
        list.run();
    }
}
