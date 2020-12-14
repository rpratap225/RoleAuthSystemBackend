package com.core.assignMent.repository;

import com.core.assignMent.models.ResourceAllocated;
import org.hibernate.secure.spi.IntegrationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceAllocatedRepository extends JpaRepository<ResourceAllocated, Integer> {
    List<ResourceAllocated> findAllByUserId(long userId);
}
