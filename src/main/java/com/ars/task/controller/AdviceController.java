package com.ars.task.controller;

import com.ars.task.exeptions.BusinessErrorException;
import com.ars.task.exeptions.ProjectNotFoundException;
import com.ars.task.exeptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/*
Controller class to handle certain exceptions
 */
@RestControllerAdvice
public class AdviceController {

    @ResponseBody
    @ExceptionHandler(ProjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String projectNotFoundHandler(ProjectNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String taskNotFoundHandler(TaskNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String BusinessErrorHandler(BusinessErrorException exception) {
        return exception.getMessage();
    }

}
