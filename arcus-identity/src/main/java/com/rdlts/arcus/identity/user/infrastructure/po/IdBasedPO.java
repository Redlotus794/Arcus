package com.rdlts.arcus.identity.user.infrastructure.po;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * IdBasedPO - Id Based Persistent Object
 * 基于ID的持久化对象基类
 *
 * @author wangjialong
 * @since 2025-06-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@MappedSuperclass
public class IdBasedPO {

    // 源自空之女神爱德丝
    public static final String DEFAULT_CREATED_BY = "Adios";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_time", nullable = false)
    private LocalDateTime updatedTime;

    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * JPA 持久化前，自动赋值
     */
    @PrePersist
    protected void onCreate() {
        this.createdTime = LocalDateTime.now();
        this.createdBy = DEFAULT_CREATED_BY;
        this.updatedTime = LocalDateTime.now();
        this.updatedBy = DEFAULT_CREATED_BY;
    }

    /**
     * JPA 更新前,自动赋值
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedTime = LocalDateTime.now();
        this.updatedBy = DEFAULT_CREATED_BY;
    }
}
