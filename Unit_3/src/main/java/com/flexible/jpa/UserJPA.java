package com.flexible.jpa;

import com.flexible.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-12-05
 * Time: 17:59
 */
public interface UserJPA extends
        JpaRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable{
}