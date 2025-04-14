package vn.com.t3h.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.service.UserService;
import vn.com.t3h.service.dto.UserDTO;
import vn.com.t3h.service.dto.response.Response;
import vn.com.t3h.service.dto.response.ResponsePage;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<Response<UserDTO>> saveUser(@RequestBody UserDTO userDTO) {
        Response<UserDTO> response = userService.saveUser(userDTO);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/users")
    public ResponseEntity<ResponsePage<List<UserDTO>>> getAllUser(@RequestParam(required = false) String code,
                                                                  @RequestParam(required = false) LocalDate fromDate,
                                                                  @RequestParam(required = false) LocalDate toDate,
                                                                  @RequestParam(required = false) String phone,
                                                                  Pageable pageable){
        ResponsePage<List<UserDTO>> responsePage = userService.getAllUser(code, fromDate, toDate, phone, pageable);
        return ResponseEntity.ok(responsePage);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Response<UserDTO>> getUser(@PathVariable Long id) {
        Response<UserDTO> response = userService.getDetailUser(id);
        return ResponseEntity.ok(response);
    }
}
