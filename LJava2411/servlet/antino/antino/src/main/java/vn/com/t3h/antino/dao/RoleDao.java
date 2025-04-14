package vn.com.t3h.antino.dao;

import vn.com.t3h.antino.model.RoleModel;

public interface RoleDao {

    RoleModel findRoleById(Integer roleId);
}
