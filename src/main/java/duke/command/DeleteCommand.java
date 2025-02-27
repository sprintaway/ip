package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * An extension of the Command class, DeleteCommand, used to delete tasks to taskList.
 */
public class DeleteCommand extends Command {

    private int integer;

    /**
     * Constructor for DeleteCommand class
     *
     * @param integer integer that determines which item is to be deleted
     */
    public DeleteCommand(int integer) {
        this.integer = integer;
        assert integer > 0 : "Integer is not valid!";
    }

    /**
     * Returns false to indicate this command does not cause Duke to exit
     *
     * @return the boolean false
     */
    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * Removes tasks from taskList, saves the taskList to Duke.txt file, and displays Ui to show update to taskList.
     *
     * @param taskList tasklist that tasks are removed from
     * @param ui ui that displays results of user commands
     * @param storage storage that saves the taskList
     * @return string that contains ui message
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task deletedTask = taskList.getTask(integer - 1);
        taskList.remove(integer);
        storage.saveFile(taskList);
        return ui.showTaskDeleted(taskList, deletedTask);
    }
}
