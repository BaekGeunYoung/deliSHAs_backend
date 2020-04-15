package com.primavera.delishas.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@EntityListeners(value=[AuditingEntityListener::class])
@MappedSuperclass
abstract class EntityAuditing {
    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    @JsonIgnore
    lateinit var createdAt : LocalDateTime
        private set

    @UpdateTimestamp
    @Column(name="updated_at", nullable = false)
    @JsonIgnore
    lateinit var updatedAt : LocalDateTime
        private set

    @PrePersist
    fun onPrePersist(){
        this.createdAt = LocalDateTime.now()
        this.updatedAt = this.createdAt
    }

    @PreUpdate
    fun opPreUpdate(){
        this.updatedAt = LocalDateTime.now()
    }
}