package com.shoplocal.dto.constant;

import java.time.format.DateTimeFormatter;
import lombok.Data;

/**
 * Date: 13/06/20
 *
 * @author Kushal Roy
 */
@Data
public class DateFormatter {

  /* ---------------- Fields ---------------- */

  public static final DateTimeFormatter DATE_TIME_MILLI_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssssss");

  public static final DateTimeFormatter ZONED_DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.SSSSSS][XXX]");

  public static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static final DateTimeFormatter DAY_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("MMM dd',' yyyy h:mm:ss a");

  public static final DateTimeFormatter ZONED_DAY_FORMATTER =
      DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z uuuu");
}
