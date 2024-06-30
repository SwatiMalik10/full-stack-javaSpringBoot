package net.javaguides.organization_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.organization_service.dto.OrganizationDTO;
import net.javaguides.organization_service.entity.Organization;
import net.javaguides.organization_service.mapper.OrganizationMapper;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
@Tag ( name="Organization Service- Organization Controller",
       description = "Organization Service - Exposes REST APIs for Organization Service")
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    @Operation(
            summary = "SAVE Organization REST API",
            description = "save organization REST API is used to save organization object in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO )
    {
       OrganizationDTO savedOrganization =   organizationService.saveOrganization ( organizationDTO );
       return new ResponseEntity<> ( savedOrganization, HttpStatus.CREATED ) ;
    }

    @GetMapping("{code}")
    @Operation(
            summary = "GET Organization REST API",
            description = "GET organization REST API is used to get a single organization object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 201 SUCCESS"
    )
    public ResponseEntity<OrganizationDTO> getOrganizationByCode (@PathVariable(name = "code") String organizationCode){
       OrganizationDTO orgDTO =  organizationService.getOrganizationByCode ( organizationCode );
       return new ResponseEntity<> ( orgDTO, HttpStatus.CREATED );
    }

}
