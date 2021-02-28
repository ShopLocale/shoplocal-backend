package com.shoplocal.dto.constant;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
public enum Status {
  SUCCESS("Success"),

  FAILURE("Failure");

  private String status;

  Status(String status) {
    this.status = status;
  }
}
