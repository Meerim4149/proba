package peaksoft.spring_res_api.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_res_api.dto.request.CompanyRequest;
import peaksoft.spring_res_api.dto.response.CompanyResponse;
import peaksoft.spring_res_api.service.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
@PreAuthorize("hasAuthority('SUPER_ADMIN')")
@Tag(name = "Company API", description = "User with role admin can add, update, delete or get all companies")
public class CompanyApi {

    private final CompanyService service;


    @PostMapping
    @Operation(summary = "create company", description = "we can create company")
    public CompanyResponse create(@RequestBody CompanyRequest request) {
        return service.create(request);
    }
    @PutMapping("{id}")
    @Operation(summary = "update company", description = "we can update company")
    public CompanyResponse update(@PathVariable long id, @RequestBody CompanyRequest request) {
        return service.update(id, request);
    }

    @GetMapping("{id}")
    @Operation(summary = "find company", description = "we can find company by id")
    public CompanyResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "delete company", description = "we can delete company by id")
    public CompanyResponse delete(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping
    @Operation(summary = "get all companies", description = "we can get all companies")
    public List<CompanyResponse> getAllCompanies() {
        return service.getAllCompanies();
    }}
