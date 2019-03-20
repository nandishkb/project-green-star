package com.outreach.greenstar.exeption;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GreenStarExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClsNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleClsNotFoundException(
        ClsNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
            ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(GroupNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleGroupNotFoundException(
        GroupNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
            ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(HolidayNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleHolidayNotFoundException(
        HolidayNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
            ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(SchoolNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleSchoolNotFoundException(
        SchoolNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
            ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(SectionNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleSectionNotFoundException(
        SectionNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
            ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleStudentNotFoundException(
        StudentNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
            ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    
    
    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ErrorDetails> handleIllegalArgumentExceptions(IllegalArgumentException ex, WebRequest request) {
      ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
          request.getDescription(false));
      return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
      ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
          request.getDescription(false));
      return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
