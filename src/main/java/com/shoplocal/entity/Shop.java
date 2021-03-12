package com.shoplocal.entity;

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
@Entity
@DynamicUpdate
@Validated
@EntityListeners(AuditingEntityListener.class)
public class Shop extends BaseEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "uuid-char")
  private UUID id;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "seller_id", nullable = false)
  private Seller seller;

  @NotEmpty(message = "Name is blank or empty")
  @Column(nullable = false)
  @Size(max = 70, message = "Maximum First Name size cannot exceed 70 characters")
  private String shopName;

  @NotEmpty(message = "Unique Name is blank or empty")
  @Column(nullable = false, unique = true)
  @Size(max = 50, message = "Maximum Last Name size cannot exceed 50 characters")
  private String shortenedShopUri;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @Column(nullable = false)
  private Boolean active;

  @Size(max = 255, message = "Image url cannot exceed 255 characters")
  private String image;

  @Column(nullable = true)
  private String category;

  @Size(max = 20, message = "Pickup/Delivery")
  private String serviceType;

  private Double deliveryCharge;

  @Column(nullable = false, updatable = false)
  @CreatedDate
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private LocalDateTime createdDate;

  @Column(nullable = false)
  @LastModifiedDate
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private LocalDateTime lastModifiedDate;

  @Transient
  private Double distance;
}
