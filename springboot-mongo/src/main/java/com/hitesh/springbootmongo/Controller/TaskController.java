package com.hitesh.springbootmongo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springbootmongo.Service.TaskService;
import com.hitesh.springbootmongo.model.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private  TaskService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task CreateTask(@RequestBody Task task)
	{
		return service.AddTask(task);
		
	}
	@GetMapping("/getall")
	public List<Task> getTask()
	{
		return service.findAllTask();
		 
	}
	@GetMapping("/{taskId}")
	public Task getTask(@PathVariable String taskId)
	{
		return service.getTaskById(taskId);
		
	}
	
	@GetMapping("/severity/{severity}")
	   public List<Task>findTaskUsingServerity(@PathVariable int severity)
	   {
		return service.getTaskByServerity(severity);
		   
	   }
	  
	   @GetMapping("/assignee/{assignee}")
	  public List<Task>getTaskByAssignee(@PathVariable String assignee)
	  {
		return service.getTakeByAssignee(assignee);
		  
	  }
           @PutMapping("/update")
	      public Task modifyTask(@RequestBody Task task)
	      {
			return service.updateTask(task);
	    	  
	      } 
           @DeleteMapping("/delete/{taskId}")
           public ResponseEntity<String> deleteTask(@PathVariable String taskId)
           {
        	   return new ResponseEntity<String>(service.deleteTask(taskId),HttpStatus.OK);
           }
	  

}
