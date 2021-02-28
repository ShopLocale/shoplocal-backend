package com.shoplocal.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoplocal.dto.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Data
@JsonIgnoreProperties
public class Response {

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @JsonProperty("errors")
  private List<ErrorMessage> errors = new ArrayList<>();
}
