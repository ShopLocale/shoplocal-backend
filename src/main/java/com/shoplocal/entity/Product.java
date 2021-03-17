package com.shoplocal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;
/**
 * Date: 01/01/21
 *
 * @author Sagar Jain
 */

@Data
@Entity
@DynamicUpdate
@Validated
@Indexed
@EntityListeners(AuditingEntityListener.class)
public class Product extends BaseEntity{

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	UUID id;

	@Column(nullable = false)
	@Size(max = 60, message = "Product Name size cannot exceed 60 characters")
	@FullTextField(analyzer = "english")
	private String name;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false, length = 1000)
	private String image;

	@Column(nullable = false)
	private Boolean active;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name = "shop_id", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Shop shop;

	@Column
	private Double size;

	@Column(length = 10)
	private String metric;

	@Column(length = 100)
	@FullTextField(analyzer = "english")
	private String description;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Column(nullable = false, updatable = false)
	@CreatedDate
	LocalDateTime createdDate;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Column(nullable = false)
	@LastModifiedDate
	LocalDateTime lastModifiedDate;

}
