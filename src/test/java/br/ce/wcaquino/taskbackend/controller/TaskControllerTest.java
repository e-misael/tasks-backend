package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {
    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldSaveTask() throws ValidationException {
        Task validTask = new Task();
        validTask.setTask("Task description.");
        validTask.setDueDate(LocalDate.now());

        taskController.save(validTask);

        Mockito.verify(taskRepo).save(validTask);
    }

    @Test
    public void testShouldNotSaveTaskWithoutDescription() {
        Task taskWithoutDescription = new Task();
        taskWithoutDescription.setDueDate(LocalDate.now());

        try {
            taskController.save(taskWithoutDescription);
        } catch (ValidationException e){
            Assert.assertEquals("Fill the task description",e.getMessage());
        }
    }
    @Test
    public void testShouldNotSaveTaskWithoutDate() {
        Task taskWithoutDate = new Task();
        taskWithoutDate.setTask("Task description.");

        try {
            taskController.save(taskWithoutDate);
        } catch (ValidationException e){
            Assert.assertEquals("Fill the due date",e.getMessage());
        }
    }
    @Test
    public void testShouldNotSaveTaskWithPastDate() {
        Task taskWithPastDate = new Task();
        taskWithPastDate.setTask("Task description.");
        taskWithPastDate.setDueDate(LocalDate.now().minusDays(1));

        try {
            taskController.save(taskWithPastDate);
        } catch (ValidationException e){
            Assert.assertEquals("Due date must not be in past",e.getMessage());
        }
    }
}
