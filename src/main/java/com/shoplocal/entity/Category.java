package com.shoplocal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Date: 25/12/20
 *
 * @author Sagar Jain
 */
@Data
@NoArgsConstructor
@Entity
@DynamicUpdate
@Validated
@EntityListeners(AuditingEntityListener.class)
public class Category extends BaseEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "uuid-char")
  private UUID id;

  @NotEmpty(message = "Type is blank or empty")
  @Column(nullable = false)
  @Size(max = 45, message = "Maximum Type size cannot exceed 45 characters")
  private String type;

  @NotEmpty(message = "Image Url is blank or empty")
  @Column(nullable = false)
  private String image;

  @Column(nullable = false, updatable = false)
  @CreatedDate
  private LocalDateTime createdDate;

  @Column(nullable = false)
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public Category(String type, String image) {
    this.image = image;
    this.type = type;
  }
}
