package com.shoplocal.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

/**
 * Date: 12/26/2020
 *
 * @author Kushal Roy
 */
@Data
@Entity
@DynamicUpdate
@Validated
@EntityListeners(AuditingEntityListener.class)
public class Address extends BaseEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "uuid-char")
  private UUID id;

//  @NotEmpty(message = "Name is blank or empty")
  @Size(max = 80, message = "Maximum name size cannot exceed 80 characters")
  private String name;

  @Column(nullable = false)
  @Pattern(
      regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$",
      message = "Contact number is not valid. Contact number should be of format +00 1234567890")
  private String mobileNumber;


  @NotEmpty(message = "Address Line 1 is blank or empty")
  @Column(nullable = false)
  @Size(max = 80, message = "Maximum Address size cannot exceed 80 characters")
  private String addressLine1;

  @NotEmpty(message = "Address Line 2 is blank or empty")
  @Column(nullable = false)
  @Size(max = 70, message = "Maximum Address size cannot exceed 70 characters")
  private String addressLine2;

  @Size(max = 80, message = "Landmark size cannot exceed 80 characters")
  private String landmark;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private String city;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private String state;

  @Column(nullable = false)
  @Pattern(
          regexp = "(^$|[0-9]{6})",
          message = "Pin code is not valid. Contact number should be of format +00 1234567890")
  private String pinCode;

  @Column(nullable = false, updatable = false)
  @CreatedDate
  private LocalDateTime createdDate;

  @Column(nullable = false)
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  // TODO: Need to change latitude and longitude to Double
  @NotEmpty(message = "latitude is blank or empty")
  @Column(nullable = false)
  private String latitude;

  @NotEmpty(message = "longitude is blank or empty")
  @Column(nullable = false)
  private String longitude;

}
