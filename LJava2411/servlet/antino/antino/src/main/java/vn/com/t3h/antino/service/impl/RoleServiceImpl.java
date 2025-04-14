package vn.com.t3h.antino.service.impl;

import vn.com.t3h.antino.dao.RoleDao;
import vn.com.t3h.antino.dao.impl.RoleDaoImpl;
import vn.com.t3h.antino.model.RoleModel;
import vn.com.t3h.antino.service.RoleService;

import javax.management.relation.Role;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public RoleModel getRoleById(Integer roleId) {
        return roleDao.findRoleById(roleId);
    }
}
