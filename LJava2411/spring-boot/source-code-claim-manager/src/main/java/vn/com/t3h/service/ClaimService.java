package vn.com.t3h.service;

import org.springframework.data.domain.Pageable;
import vn.com.t3h.service.dto.ClaimDTO;
import vn.com.t3h.service.dto.response.ResponsePage;

import java.time.LocalDate;
import java.util.List;

public interface ClaimService {

    ResponsePage<List<ClaimDTO>> getClaims(
            String claimCode, // required = false: có thể truyền vào param hoặc không truyền vào
            LocalDate fromDate,
            LocalDate toDate,
            String codeStatus,
            Pageable pageable
    );
}
