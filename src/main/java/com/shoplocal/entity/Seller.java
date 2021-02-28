package com.shoplocal.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Date: 25/02/2021
 *
 * @author Sagar Jain
 */
@Data
@Entity
@DynamicUpdate
@Validated
@EntityListeners(AuditingEntityListener.class)
public class Seller extends BaseEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "uuid-char")
  UUID id;

  @NotEmpty(message = "First name is blank or empty")
  @Column(nullable = false)
  @Size(max = 60, message = "Maximum firstName size cannot exceed 60 characters")
  String firstName;

  @NotEmpty(message = "Last Name is blank or empty")
  @Column(nullable = false)
  @Size(max = 40, message = "Maximum lastName size cannot exceed 40 characters")
  String lastName;

  @NaturalId
  @Column(nullable = false, unique = true)
  @Pattern(
          regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$",
          message = "Mobile number is not valid. Mobile number should be of format 1234567890")
  @Size(
          min = 10,
          max = 10,
          message = "Contact number '${validatedValue}' must be {max} characters long")
  private String mobileNumber;

  @Column
  @Size(max = 60, message = "Maximum email size cannot exceed 60 characters")
  @Email
  String email;

  @Column
  private Boolean active;

  @Column(nullable = false, updatable = false)
  @CreatedDate
  LocalDateTime createdDate;

  @Column(nullable = false)
  @LastModifiedDate
  LocalDateTime lastModifiedDate;

  @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Shop> shops = new HashSet<>();
}
