package com.hitesh.springbootmongo.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.springbootmongo.model.Task;
import com.hitesh.springbootmongo.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	public Task AddTask(Task task) {
		task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(task);

	}

	public List<Task> findAllTask()
	{
		return repository.findAll();
		}

	public Task getTaskById(String taskId) {
		return repository.findById(taskId).get();

	}

	public List<Task> getTaskByServerity(int severity) {
		return repository.findBySeverity(severity);
	}

	public List<Task> getTakeByAssignee(String assignee)

	{
		return repository.findByAssignee(assignee);

	}

	public Task updateTask(Task taskRequest) {
		Task existingTask = repository.findById(taskRequest.getTaskId()).get();
		existingTask.setDescription(taskRequest.getTaskId());
		existingTask.setSeverity(taskRequest.getSeverity());
		existingTask.setAssignee(taskRequest.getAssignee());
		existingTask.setStroyPoint(taskRequest.getStroyPoint());
		return repository.save(existingTask);
	}

	public String deleteTask(String taskId) {
		boolean delete=false;
		if(repository.existsById(taskId))
		{
			repository.deleteById(taskId);
			delete=true;
		}
		return "Product  With Id" +taskId+ "delete status"+delete;

	}
}
