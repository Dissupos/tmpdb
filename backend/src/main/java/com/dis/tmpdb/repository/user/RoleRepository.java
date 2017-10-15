package com.dis.tmpdb.repository.user;

import com.dis.tmpdb.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
