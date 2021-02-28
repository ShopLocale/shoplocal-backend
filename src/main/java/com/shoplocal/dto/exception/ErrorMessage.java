package com.shoplocal.dto.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Data
@AllArgsConstructor
public class ErrorMessage {

  @JsonProperty("timestamp")
  private OffsetDateTime timestamp;

  @JsonProperty("status_code")
  private int status;

  @JsonProperty("message")
  private String message;
}
