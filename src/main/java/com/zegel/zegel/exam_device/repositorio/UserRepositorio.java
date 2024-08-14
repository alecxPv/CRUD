package com.zegel.zegel.exam_device.repositorio;

import com.zegel.zegel.exam_device.entidades.Seguridad.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositorio extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

