package com.shoplocal.configuration.controller;

import com.shoplocal.dto.exception.ErrorMessage;
import com.shoplocal.dto.response.Response;

import java.io.FileNotFoundException;
import java.time.OffsetDateTime;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@ControllerAdvice
public class CustomerControllerAdvice {

  /* ---------------- Fields ---------------- */

  private static final Logger log = LogManager.getLogger();

  /* ---------------- Exception Handlers ---------------- */

  @ExceptionHandler(
      value = {
        NullPointerException.class,
        IllegalArgumentException.class,
        NumberFormatException.class,
        UnsupportedOperationException.class
      })
  public ResponseEntity<Response> handleNullPointerException(Exception e) {
    return error(HttpStatus.BAD_REQUEST, e);
  }

  @ExceptionHandler(value = {TaskRejectedException.class})
  public ResponseEntity<Response> handleTaskRejectedException(Exception e) {
    return error(HttpStatus.FORBIDDEN, e);
  }

  @ExceptionHandler(
      value = {
        HttpMessageNotReadableException.class,
        MissingServletRequestParameterException.class
      })
  public ResponseEntity<Response> handleHttpMessageNotReadableException(Exception e) {
    return error(HttpStatus.BAD_REQUEST, e);
  }

  @ExceptionHandler(value = {RuntimeException.class})
  public ResponseEntity<Response> handleRunTimeException(Exception e) {
    return error(HttpStatus.UNAUTHORIZED, e);
  }

  @ExceptionHandler(value = {FileNotFoundException.class, NoSuchElementException.class})
  public ResponseEntity<Response> handleFileNotFoundException(Exception e) {
    return error(HttpStatus.NOT_FOUND, e);
  }

  @ExceptionHandler(
      value = {ConcurrentModificationException.class, DataIntegrityViolationException.class})
  public ResponseEntity<Response> handleConcurrentModificationException(Exception e) {
    return error(HttpStatus.CONFLICT, e);
  }

  private ResponseEntity<Response> error(HttpStatus status, Exception e) {
    log.error("Exception Details: ", e);
    Response errorResponse = new Response();
    errorResponse
        .getErrors()
        .add(new ErrorMessage(OffsetDateTime.now(), status.value(), e.getMessage()));
    return ResponseEntity.status(status).body(errorResponse);
  }
}
