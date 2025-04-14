package vn.com.t3h.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.t3h.entity.ClaimEntity;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.service.dto.ClaimDTO;
import vn.com.t3h.service.dto.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDTO userDTO);

    UserDTO toDto(UserEntity userEntity);

    List<UserDTO> toDtos(List<UserEntity> userEntities);
}
